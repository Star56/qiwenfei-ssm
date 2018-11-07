package com.qiwenfei.note.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 2018/11/1
 * sunshine
 */
public class JedisConnectionUtils {
    private  static JedisPool  jedisPool = null ;

    static {
        JedisPoolConfig  jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(100);
        jedisPool = new JedisPool(jedisPoolConfig,"192.168.172.129",6379);
    }

    public static Jedis getJedis(){
        return jedisPool.getResource() ;
    }
}
