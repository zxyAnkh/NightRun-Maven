package cn.edu.zucc.core;

import cn.edu.zucc.core.feature.test.TestSupport;
import org.json.JSONObject;
import org.junit.Test;

/**
 * Created by zxy on 2016/7/8.
 */
public class JSONTest extends TestSupport{

    @Test
    public void jsonTest() throws Exception{
        String str = "{\"userno\":[\"1\",\"2\",\"3\"]}";
        JSONObject json = new JSONObject(str);
        System.out.println(json);
        System.out.println(json.get("userno"));
    }

}
