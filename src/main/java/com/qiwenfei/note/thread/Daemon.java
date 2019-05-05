package com.qiwenfei.note.thread;

import java.util.concurrent.TimeUnit;

/**
 * 2019/3/25
 * sunshine
 * 运行Daemon程序，可以看到在终端或者命令提示符上没有任何输出。
 * main线程（非 Daemon线程）在启动了线程DaemonRunner之后随着main方法执行完毕而终止，
 * 而此时Java虚拟 机中已经没有非Daemon线程，虚拟机需要退出。
 * Java虚拟机中的所有Daemon线程都需要立即 终止，
 * 因此DaemonRunner立即终止，但是DaemonRunner中的finally块并没有执行
 */
public class Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("DaemonThread  run.");
                TimeUnit.SECONDS.sleep(10);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}

