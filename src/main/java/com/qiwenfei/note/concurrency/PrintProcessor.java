package com.qiwenfei.note.concurrency;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 2018/11/12
 * sunshine
 */
public class PrintProcessor extends Thread implements RequestProcessor{

    private final LinkedBlockingQueue<Request>  requests = new LinkedBlockingQueue<Request>();

    private RequestProcessor  nextProcessor ;

    public  PrintProcessor(RequestProcessor nextProcessor){
        this.nextProcessor = nextProcessor ;
    }

    @Override
    public void run() {

        while(true){
            try {
                Request  request =  requests.take() ;
                if(null == request){
                    continue;
                }
                System.out.println("处理打印请求："+ request.getName());
                nextProcessor.processRequest(request);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public void processRequest(Request request) {
     //   System.out.println("打印添加请求任务："+request.getName());
        requests.add(request);
    }
}
