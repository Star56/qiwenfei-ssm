package com.qiwenfei.note.netty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * 2019/3/27
 * sunshine
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {
    private int counter ;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String body = (String)msg ;

        System.out.println("服务端接收到信息: "+body+" counter: "+ ++counter);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
