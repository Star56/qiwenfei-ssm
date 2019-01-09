package com.qiwenfei.note.concurrency;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 2018/11/12
 * sunshine
 */
public class SaveProcessor extends Thread implements RequestProcessor {

    private final LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<Request>();

    @Override
    public void run() {
        while(true){
            try {
                Request   request = requests.take() ;
                if(null == request){
                    continue;
                }
                System.out.println("处理保存任务："+ request.getName());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void processRequest(Request request) {
     //   System.out.println("保存添加请求任务："+request.getName());
        requests.add(request);
    }
}
