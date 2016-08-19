package cn.edu.zucc.core.feature.cache.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.*;

/**
 * RedisCache : redis 缓存 插件
 *
 * @author zxyAnkh
 * @since 2016-07-08
 */
@Component(value = "redisCache")
public class RedisCache {

    private String password = "zxyankh";

    private Jedis jedis = RedisPool.getResource();

    public String cache(String key, String value, int seconds) {
        jedis.auth(password);
        jedis.del(key);
        String result = jedis.set(key, value);
        jedis.expire(key, seconds);
        return result;
    }

    public String cache(String key, byte[] value, int seconds) {
        jedis.auth(password);
        jedis.del(key);
        String result = jedis.set(key.getBytes(), value);
        jedis.expire(key, seconds);
        return result;
    }

    public String getString(String key) {
        jedis.auth(password);
        return jedis.get(key);
    }

    public byte[] getByte(String key) {
        jedis.auth(password);
        return jedis.get(key.getBytes());
    }

    public void delCache(String key){
        jedis.auth(password);
        jedis.del(key);
    }

    public void delCache(byte[] key){
        jedis.auth(password);
        jedis.del(key);
    }

}
