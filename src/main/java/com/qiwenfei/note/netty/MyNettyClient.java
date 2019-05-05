package com.qiwenfei.note.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * 2019/3/27
 * sunshine
 */
public class MyNettyClient {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup  group = new NioEventLoopGroup();

        Bootstrap  bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioSocketChannel.class)
                .handler(new ClientChannelInitializer());

        try {
            ChannelFuture  future = bootstrap.connect("127.0.0.1",8899).sync();
            future.channel().closeFuture().sync() ;
        } finally {
            group.shutdownGracefully();
        }

    }
}
