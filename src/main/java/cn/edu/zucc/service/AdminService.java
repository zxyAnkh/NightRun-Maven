package cn.edu.zucc.service;

import cn.edu.zucc.entity.*;
import cn.edu.zucc.form.BeanuserForm;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * Created by zxy on 5/12/2016.
 */
public interface AdminService {
    BeanadminEntity doLogin(String no, String pwd);
    List<ViewJsAsEntity> loadUser(String ano, Boolean isAll);
    List<ViewJsRunEntity> loadRun(String ano, int branch);
    List<ViewJsRunEntity> findRun(String type, String keyword, int branch);
    List<ViewJsAsEntity> findUser(String keyword, int branch);
    List<ViewJsTotalEntity> findTotal(String keyword, int branch);
    Boolean modifyAdmin(BeanadminEntity beanadminEntity);
    Boolean addUser(BeanuserForm beanuserForm);
    Boolean deleteUser(String sno,int branch);
}
