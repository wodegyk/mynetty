package com.protobuf;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;


public class ProtoBufClientServer {
    public static void main(String[] args) throws Exception {
        EventLoopGroup eventLoopGrou = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventLoopGrou).channel(NioSocketChannel.class).handler(null);

        ChannelFuture channelFuture = bootstrap.connect("localhost", 8899).sync();
        channelFuture.channel().closeFuture().sync();
    }
}