package cn.edu.zucc.controller;

import cn.edu.zucc.handle.ErrorCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zxy on 6/13/2016.
 */
@Controller("errorController")
public class ErrorController {

    @RequestMapping(value = "/view/error/{id}")
    public String error(@PathVariable long id, Model model){
        String error = ErrorCode.getError((int)id);
        model.addAttribute("error",error);
        return "error";
    }

}
