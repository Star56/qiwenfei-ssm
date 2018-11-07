package com.qiwenfei.note.redis;

import redis.clients.jedis.Jedis;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2018/10/31
 * sunshine
 */
public class TestRedis {

    private Jedis jedis;

    @Before
    public void setJedis() {
        //连接redis服务器(在这里是连接本地的)
        jedis = new Jedis("192.168.172.129", 6379);
        // 权限认证
      //  jedis.auth("123");
        System.out.println("连接服务成功"); }
        /*** Redis操作字符串
                */
        @Test
        public void testString() {
            //添加数据
            jedis.set("name", "chx");
            //key为name放入value值为chx
            System.out.println("拼接前:" + jedis.get("name"));
            //读取key为name的值
            // 向key为name的值后面加上数据 ---拼接
            jedis.append("name", " is my name;");
            System.out.println("拼接后:" + jedis.get("name"));
            //删除某个键值对
            jedis.del("name");
            System.out.println("删除后:" + jedis.get("name"));
            //s设置多个键值对
            jedis.mset("name", "chenhaoxiang", "age", "20", "email", "chxpostbox@outlook.com");
            jedis.incr("age");
            //用于将键的整数值递增1。如果键不存在，则在执行操作之前将其设置为0。 如果键包含错误类型的值或包含无法表示为整数的字符串，则会返回错误。此操作限于64位有符号整数。
            System.out.println(jedis.get("name") + " " + jedis.get("age") + " " + jedis.get("email"));

        }

    /**
     * redis hash数据类型操作
      */
    @Test
    public void  testMap(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("name","qiwenfei");
        map.put("sex","男");
        map.put("age","28");

        jedis.hmset("user",map);
        System.out.println("设置user信息成功");
        List<String> list =  jedis.hmget("user","name","sex","age");
        System.out.println("获取user的name信息为："+list);

    }

    /**
     * Redis List数据类型操作
     */
    @Test
    public void testList(){
        //移除javaFramwork所所有内容
        jedis.del("javaFramework");
        //存放数据
        jedis.lpush("javaFramework","Spring");
        jedis.lpush("javaFramework","SpringMVC");
        jedis.lpush("javaFramework","myBaits");

        System.out.println("javaFramework:"+jedis.lrange("javaFramework",0,-1));
    }

    /**
     * Redis Set数据类型操作
     */
    @Test
   public void toSet(){
       jedis.sadd("man","张三","李四","王五");
        System.out.println("set中的数据为："+jedis.smembers("man"));
   }


}
