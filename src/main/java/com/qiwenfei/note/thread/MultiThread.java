package com.qiwenfei.note.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 2019/1/15
 * sunshine
 * JMX查看线程数量
 */
public class MultiThread {

    public static void main(String[] args) {
        ThreadMXBean  mxBean = ManagementFactory.getThreadMXBean();
        ThreadInfo [] threadInfos = mxBean.dumpAllThreads(false,false);
        for (ThreadInfo threadInfo :
                threadInfos) {
            System.out.println(threadInfo.getThreadId()+"---"+threadInfo.getThreadName());
        }
    }
}
