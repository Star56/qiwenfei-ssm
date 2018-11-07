package com.qiwenfei.note.redis;

/**
 * 2018/11/1
 * sunshine
 */
public class LockTest extends Thread {

    @Override
    public void run() {

        while (true){
            DistributedLock  distributedLock = new DistributedLock();
            String identifer  = distributedLock.acquireLock("update",
                    2000,500000);
            ////成功获取锁
            if(identifer != null) {
                System.out.println(Thread.currentThread().getName() + "成功获得锁" + identifer);

                try {
                    Thread.sleep(1000);
                    //释放锁
                    boolean isRelease = distributedLock.releaseLockLua("update",identifer);
                    if(isRelease){
                        System.out.println(Thread.currentThread().getName() + "成功释放锁");
                    }
                    break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        LockTest  lockTest = new LockTest();

        for (int i =0 ;i<10 ;i++){
              new Thread(lockTest,"tsname"+i).start();
        }
    }

}
