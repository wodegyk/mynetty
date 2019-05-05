package com.protobuf;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * <p>描述: CmpSystemMsgDao</p>
 * <p>公司: 瑞华康源科技有限公司</p>
 * <p>版权: rivamed2018</p>
 *
 * @author wanghualin
 * @version V1.0
 * @date 2019/4/28
 */
public class ProtoBufClientServer {
    public static void main(String[] args) throws Exception {
        EventLoopGroup eventLoopGrou = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventLoopGrou).channel(NioSocketChannel.class).handler(null);

        ChannelFuture channelFuture = bootstrap.connect("localhost", 8899).sync();
        channelFuture.channel().closeFuture().sync();
    }
}
