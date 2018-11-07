package com.qiwenfei.note.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

/**
 * 2018/10/31
 * sunshine
 */
public class JedisClientDemo {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.172.129", 6379);

      //  JedisSentinelPool  sentinelPool = new JedisSentinelPool();

       Set<HostAndPort> hostAndPortSet = new HashSet<HostAndPort>();
        hostAndPortSet.add(new HostAndPort("192.168.172.129",6379));
        hostAndPortSet.add(new HostAndPort("192.168.172.128",6379));

        JedisCluster  jedisCluster = new JedisCluster(hostAndPortSet,6000);


    }
}
