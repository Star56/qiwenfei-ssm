package com.qiwenfei.java8.callback;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * Callback回调接口实现异步
 * 2019/8/23
 * sunshine
 */
public class MyCallback {
    static ExecutorService es = Executors.newFixedThreadPool(2);
    public static void dosm(final ICallback callback){
        Thread thread = new Thread(()->{
            //业务逻辑处理
            System.out.println("子任务执行："+Thread.currentThread().getId());
            try{
                Thread.sleep(5);
            }catch (Exception e){
                e.printStackTrace();
            }
            //业务逻辑处理完成，执行回调
            Map<String, Object> params = new HashMap<>();
            params.put("a1", "这是我返回的参数字符串...");
            callback.callback(params);
        });
        es.execute(thread);
        //一定要调用这个方法，不然executorService.isTerminated()永远不为true
        es.shutdown();
    }

    public static void main(String[] args) {
         dosm((params)->{
             System.out.println("单个线程也已经处理完毕了，返回参数a1=" + params.get("a1"));
         });
         try{
             Thread.sleep(5);
         }catch (Exception e){
             e.printStackTrace();
         }
        System.out.println("主线任务已经执行完了:"+Thread.currentThread().getId());
    }
}
