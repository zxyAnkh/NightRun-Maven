package cn.edu.zucc.core;

import cn.edu.zucc.core.feature.cache.redis.RedisCache;
import cn.edu.zucc.core.feature.test.TestSupport;
import cn.edu.zucc.web.model.User;
import cn.edu.zucc.web.model.ViewRun;
import cn.edu.zucc.web.service.RunService;
import cn.edu.zucc.web.transcoder.RunTranscoder;
import cn.edu.zucc.web.transcoder.UserTranscoder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxy on 2016/7/8.
 */
public class JredisTest extends TestSupport{
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private RunService runService;

    @Test
    public void testOne() throws Exception{
        List<User> list = new ArrayList<User>();
        UserTranscoder userTranscoder = new UserTranscoder();

        list.add(new User("test1","test1"));
        list.add(new User("test2","test2"));
        redisCache.cache("list",userTranscoder.serialize(list) ,60 * 24);
        byte[] in = redisCache.getByte("list");
        List<User> get = userTranscoder.deserialize(in);
        for(User user : get){
            System.out.println("user no is:" + user.getUserno());
        }
        redisCache.delCache("list".getBytes());
        in = redisCache.getByte("list");
        if(in == null){
            System.out.println("redis delete success");
        }
    }

}
