package com.webSocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * <p>描述: CmpSystemMsgDao</p>
 * <p>公司: 瑞华康源科技有限公司</p>
 * <p>版权: rivamed2018</p>
 *
 * @author wanghualin
 * @version V1.0
 * @date 2019/4/25
 */
public class WebSocketServer {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                .childHandler(null);
        ChannelFuture channelFuture = serverBootstrap.bind(new InetSocketAddress(8899)).sync();
        channelFuture.channel().closeFuture().sync();
    }

}
