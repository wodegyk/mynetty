package com.protobuf;

import com.webchat.MyClientInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;


public class ProtoBufClientServer {
    public static void main(String[] args) throws Exception {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try{
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).
                    handler(new ProtoBufClientInitializer());
            ChannelFuture channelFuture = bootstrap.connect("localhost", 8899).sync();
//            BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
            channelFuture.channel().closeFuture().sync();

        }finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
