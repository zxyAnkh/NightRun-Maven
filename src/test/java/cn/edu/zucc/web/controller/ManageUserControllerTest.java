package cn.edu.zucc.web.controller;

import cn.edu.zucc.core.feature.test.TestSupport;
import cn.edu.zucc.web.json.StudentNoPojo;
import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zxy on 12/3/2016.
 */
public class ManageUserControllerTest extends TestSupport {

    @Test
    public void test(){
        Gson gson = new Gson();
        StudentNoPojo studentNoPojo = new StudentNoPojo();
        List<String> list = new ArrayList<String>();
        list.add("31301600");
        studentNoPojo.setNos(list);
        System.out.println(gson.toJson(studentNoPojo));
    }

}