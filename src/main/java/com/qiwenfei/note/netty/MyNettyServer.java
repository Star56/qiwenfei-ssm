package com.qiwenfei.note.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 2019/3/27
 * sunshine
 */
public class MyNettyServer {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup  bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup  workGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap  serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup,workGroup).channel(NioServerSocketChannel.class)
                    .childHandler( new ServerChannelInitializer());

            ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
