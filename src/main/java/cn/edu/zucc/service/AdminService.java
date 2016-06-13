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

    Boolean modifyAdmin(BeanadminEntity beanadminEntity);

}
