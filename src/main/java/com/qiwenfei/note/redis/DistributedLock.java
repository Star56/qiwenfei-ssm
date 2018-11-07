package com.qiwenfei.note.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.UUID;

/**
 * 2018/11/1
 * sunshine
 */
public class DistributedLock {

    public  String acquireLock(String lockname,long acquireTimeout,long lockTimeout){
        String identifier = UUID.randomUUID().toString() ;
        int lockExpire = (int)(lockTimeout/1000) ;
        long end = System.currentTimeMillis()+acquireTimeout ;
        Jedis jedis = null ;

        try {
            jedis  = JedisConnectionUtils.getJedis();

            while(System.currentTimeMillis()<end){
                //设置成功
                if(jedis.setnx(lockname,identifier) ==1 ){
                    //设置key的过期时间
                    jedis.expire(lockname,lockExpire);
                    return  identifier ;
                }
                if(jedis.ttl(lockname) == -1){
                    jedis.expire(lockname,lockExpire) ;//设置超时时间
                }
                try {
                    //等待1s后进行获取锁重试
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        } finally {
             if(null != jedis){jedis.close();}
        }

        return null ;
    }

    /**
     * 通过Lua脚本释放锁
     * @param lockname
     * @param identifer
     * @return
     */
    public boolean releaseLockLua(String lockname ,String identifer){
        Jedis   jedis =  JedisConnectionUtils.getJedis() ;

        String lua = " if redis.call(\"get\",KEYS[1])==ARGV[1] then " +
                " return redis.call(\"del\",KEYS[1]) " +
                " else return 0 end ";
        Long rs = (Long)jedis.eval(lua,1,new String[]{lockname,identifer});
        if(rs.intValue()>0){
            return true ;
        }
        return false ;

    }

    public boolean  releaseLock(String lockname , String identifer){

        boolean  isRelease = false ;
        Jedis  jedis = null ;

        try {
            jedis = JedisConnectionUtils.getJedis() ;
            while (true){
              jedis.watch(lockname);

              //判断是否为同一把锁
              if(identifer.equals(jedis.get(lockname))){
                  Transaction   transaction = jedis.multi();
                  transaction.del(lockname);
                  if(transaction.exec().isEmpty()){
                      continue;
                  }
                  isRelease = true ;
              }
              jedis.unwatch();
              break ;

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }

        return  isRelease ;
    }

}
