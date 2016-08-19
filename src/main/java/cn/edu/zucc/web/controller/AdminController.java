package cn.edu.zucc.web.controller;

import cn.edu.zucc.core.feature.cache.redis.RedisCache;
import cn.edu.zucc.core.util.PasswordHash;
import cn.edu.zucc.core.util.ReadExcel;
import cn.edu.zucc.web.form.UserForm;
import cn.edu.zucc.web.form.UserInfoForm;
import cn.edu.zucc.web.model.*;
import cn.edu.zucc.web.security.PermissionSign;
import cn.edu.zucc.web.security.RoleSign;
import cn.edu.zucc.web.service.RunService;
import cn.edu.zucc.web.service.UserService;
import cn.edu.zucc.web.transcoder.RunTranscoder;
import cn.edu.zucc.web.transcoder.UserTranscoder;
import cn.edu.zucc.web.transcoder.ViewRunTranscoder;
import cn.edu.zucc.web.transcoder.ViewTotalTranscoder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 管理员页面处理
 * Created by zxy on 2016/7/7.
 * @author zxyAnkh
 * @since 2016-07-07
 */
@Controller("adminController")
@RequestMapping("/admin")
public class AdminController {

    private static final Log logger = LogFactory.getLog(UserController.class);

    @Autowired
    private RunService runService;
    @Autowired
    private UserService userService;
    @Autowired
    private RedisCache redisCache;

    /**
     * 四个序列化工具
     */
    private RunTranscoder runTranscoder = new RunTranscoder();
    private UserTranscoder userTranscoder = new UserTranscoder();
    private ViewRunTranscoder viewRunTranscoder = new ViewRunTranscoder();
    private ViewTotalTranscoder viewTotalTranscoder = new ViewTotalTranscoder();

    /**
     * 管理员首页
     *
     * @return "admin/main"
     */
    @RequestMapping(value = "/main", method = {RequestMethod.GET, RequestMethod.POST})
    @RequiresRoles(value = RoleSign.ADMIN)
    public String mainGet(Model model, HttpSession httpSession) {
        logger.info("/admin/mainget");
        User user = (User) httpSession.getAttribute("userInfo");
        List<ViewRun> viewRunList = null;
        byte[] in = redisCache.getByte("viewRunList");
        if (in == null) {
            viewRunList = runService.selectRuns();
            redisCache.cache("viewRunList", viewRunTranscoder.serialize(viewRunList), 60 * 24);
        } else {
            viewRunList = viewRunTranscoder.deserialize(in);
        }
        model.addAttribute("viewRunList", viewRunList);
        return "admin/main";
    }

    /**
     * 查询用户数据
     *
     * @param type
     * @param keyword 查询关键词
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @RequiresRoles(value = RoleSign.ADMIN)
    public String search(@RequestParam("type") String type, @RequestParam("keyword") String keyword, Model model) {
        logger.info("/admin/search");
        if ("all".equals(type)) {
            logger.info("search all");
            List<User> result = userService.selectByKeyword(keyword);
            model.addAttribute("searchResult", result);
        } else if ("details".equals(type)) {
            logger.info("search details");
            List<ViewRun> result_list = runService.selectRunsByUserid(userService.selectByUserno(keyword).getId());
            ViewTotal result_total = runService.selectRunByUserid(userService.selectByUserno(keyword).getId());
            model.addAttribute("searchDetailsList", result_list);
            model.addAttribute("searchDetailsTotal", result_total);
        }
        return "admin/search";
    }


    /**
     * 查看活跃用户
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/users")
    @RequiresRoles(value = RoleSign.ADMIN)
    public String users(Model model) {
        logger.info("/admin/users");
        List<User> users = null;
        byte[] in = redisCache.getByte("usersAList");
        if (in == null) {
            users = userService.selectActiveUsers();
            redisCache.cache("usersAList", userTranscoder.serialize(users), 60 * 24);
        } else {
            users = userTranscoder.deserialize(in);
        }
        model.addAttribute("usersAList", users);
        return "admin/users";
    }

    /**
     * 查看注销用户
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/usersAll")
    @RequiresRoles(value = RoleSign.ADMIN)
    public String usersAll(Model model) {
        logger.info("/admin/usersAll");
        List<User> users = null;
        byte[] in = redisCache.getByte("usersNAList");
        if (in == null) {
            users = userService.selectNActiveUsers();
            redisCache.cache("usersNAList", userTranscoder.serialize(users), 60 * 24);
        } else {
            users = userTranscoder.deserialize(in);
        }
        model.addAttribute("usersNAList", users);
        return "admin/usersAll";
    }

    /**
     * 单独添加用户 get
     *
     * @return
     */
    @RequestMapping(value = "/userAdd", method = RequestMethod.GET)
    @RequiresRoles(value = RoleSign.ADMIN)
    @RequiresPermissions(value = PermissionSign.USER_CREATE)
    public String userAdd() {
        logger.info("admin/userAdd get");
        return "admin/userAdd";
    }

    /**
     * 单独添加用户 post
     *
     * @param userForm 用户表单数据
     * @return
     */
    @RequestMapping(value = "/userAdd", method = RequestMethod.POST)
    @RequiresRoles(value = RoleSign.ADMIN)
    @RequiresPermissions(value = PermissionSign.USER_CREATE)
    public String userAdd(UserForm userForm, HttpServletRequest request) {
        logger.info("admin/userAdd post");
        if (userService.selectByUserno(userForm.getUserno()) == null) {
            userService.insert(userForm);
            redisCache.delCache("usersAList");
        }
        return "redirect:users";
    }

    /**
     * 判断用户是否已存在
     *
     * @param userno
     * @return 1:不存在  0:存在
     */
    @RequestMapping(value = "/checkUser", method = RequestMethod.POST)
    @RequiresRoles(value = RoleSign.ADMIN)
    @RequiresPermissions(value = PermissionSign.USER_CREATE)
    public String checkUser(@RequestBody String userno) {
        logger.info("admin/checkUser");
        return String.valueOf(userService.selectByUserno(userno) == null ? 1 : 0);
    }

    /**
     * 批量添加用户 get
     *
     * @return
     */
    @RequestMapping(value = "/usersAdd", method = RequestMethod.GET)
    @RequiresRoles(value = RoleSign.ADMIN)
    @RequiresPermissions(value = PermissionSign.USER_CREATE)
    public String usersAdd() {
        return "admin/usersAdd";
    }

    /**
     * 批量添加用户 post
     *
     * @param multipartFile 上传的excel文件
     * @return
     */
    @RequestMapping(value = "/usersAdd", method = RequestMethod.POST)
    @RequiresRoles(value = RoleSign.ADMIN)
    @RequiresPermissions(value = PermissionSign.USER_CREATE)
    public String usersAdd(HttpSession httpSession, @RequestParam("file") MultipartFile multipartFile) {
        String path = httpSession.getServletContext().getRealPath("/app/upload");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileName = simpleDateFormat.format(new Date());
        File file = new File(path, fileName + ".xls");
        try {
            multipartFile.transferTo(file);
            List<UserForm> formList = new ReadExcel().readExcel(file.getPath());
            if (formList != null) {
                for (UserForm userForm : formList) {
                    if (userService.selectByUserno(userForm.getUserno()) == null) {
                        userService.insert(userForm);
                    }
                    System.out.println(userForm.getUserno());
                }
            }
            redisCache.delCache("usersAList");
            return "redirect:users";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:users";
    }

    /**
     * 删除用户
     *
     * @param usernos 用户编号字符串
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    @RequiresRoles(value = RoleSign.ADMIN)
    @RequiresPermissions(value = PermissionSign.USER_DELETE)
    public int deleteUser(@RequestBody String usernos) {
        logger.info("/admin/delete");
        int flag = 1;
        for (int i = 0; i < usernos.length() - 1; i += 8) {
            String str = usernos.substring(i, i + 8);
            flag++;
            if (userService.deleteByUserid(userService.selectByUserno(str).getId()) != 1)
                flag = 0;
        }
        redisCache.delCache("usersAList");
        redisCache.delCache("usersNAList");
        return flag;
    }

    /**
     * 恢复用户
     *
     * @param usernos 用户编号字符串
     * @return
     */
    @RequestMapping(value = "/restore", method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles(value = RoleSign.ADMIN)
    @RequiresPermissions(value = PermissionSign.USER_RESTORE)
    public int restoreUser(@RequestBody String usernos) {
        int flag = 1;
        for (int i = 0; i < usernos.length() - 1; i += 8) {
            String str = usernos.substring(i, i + 8);
            flag++;
            if (userService.updateDelByUserid(userService.selectByUserno(str).getId()) != 1)
                flag = 0;
        }
        redisCache.delCache("usersAList");
        redisCache.delCache("usersNAList");
        return flag;
    }

    /**
     * 管理员查看并修改个人信息
     *
     * @param userInfoForm 用户个人信息表单
     * @return
     */
    @RequestMapping(value = "/info", method = {RequestMethod.POST, RequestMethod.GET})
    @RequiresRoles(value = RoleSign.ADMIN)
    @RequiresPermissions(value = PermissionSign.ADMIN_UPDATE)
    public String updateInfo(Model model, HttpSession httpSession, UserInfoForm userInfoForm) {
        logger.info("/admin/info");
        User user = (User) httpSession.getAttribute("userInfo");
        try {
            if (userInfoForm.getOldpassword() != null && PasswordHash.validatePassword(userInfoForm.getOldpassword(), user.getPassword())) {
                if (userInfoForm.getNewpassword2() != null && !"".equals(userInfoForm.getNewpassword2()))
                    user.setPassword(userInfoForm.getNewpassword2());
                user.setUsername(userInfoForm.getUsername());
                if (userService.updateByRecord(user) == 1) {
                    httpSession.setAttribute("userInfo", user);
                }
                return "admin/info";
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return "admin/info";
    }

}
