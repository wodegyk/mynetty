package com.webchat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * <p>描述: CmpSystemMsgDao</p>
 * <p>公司: 瑞华康源科技有限公司</p>
 * <p>版权: rivamed2018</p>
 *
 * @author wanghualin
 * @version V1.0
 * @date 2019/4/26
 */
public class MyClient {
    public static void main(String[] args) throws Exception {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try{
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).
                    handler(new MyClientInitializer());
            Channel channel = bootstrap.connect("192.168.11.215", 8899).sync().channel();
            BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
            for (;;){
                channel.writeAndFlush(br.readLine()+"\r\n");
            }

        }finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
