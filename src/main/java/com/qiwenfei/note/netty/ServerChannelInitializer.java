package com.qiwenfei.note.netty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * 2019/3/27
 * sunshine
 */
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline   pipeline = socketChannel.pipeline() ;
        pipeline.addLast("decoder",new StringDecoder());
        pipeline.addLast("encoder",new StringEncoder());

        pipeline.addLast(new MyServerHandler());
    }
}
