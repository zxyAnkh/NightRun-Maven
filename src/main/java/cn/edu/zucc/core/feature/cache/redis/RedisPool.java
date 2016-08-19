package cn.edu.zucc.core.feature.cache.redis;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by zxy on 2016/7/13.
 * @author zxyAnkh
 * @since 2016-07-13
 */
@Component(value = "redisPool")
public class RedisPool {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 6379;
    private static final int TIMEOUT = 3000;
    private static final String PASSWORD = "zxyankh";

    private static final int MAX_IDLE = 20;
    private static final int MIN_IDLE = 5;
    private static final int MAX_WAIT_MILLIS = 3000;
    private static final Boolean TEST_ON_BORROW = true;
    private static final Boolean TEST_ON_RETURN = true;

    private static JedisPool jedisPool;

    static{
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(MAX_IDLE);
        jedisPoolConfig.setTestOnBorrow(TEST_ON_BORROW);
        jedisPoolConfig.setMaxWaitMillis(MAX_WAIT_MILLIS);
        jedisPoolConfig.setMinIdle(MIN_IDLE);
        jedisPoolConfig.setTestOnReturn(TEST_ON_RETURN);
        jedisPool = new JedisPool(jedisPoolConfig, HOST, PORT, TIMEOUT, PASSWORD);
    }

    public static Jedis getResource() {
        return jedisPool.getResource();
    }

}
