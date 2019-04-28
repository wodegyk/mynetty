package com.webchat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * <p>描述: CmpSystemMsgDao</p>
 * <p>公司: 瑞华康源科技有限公司</p>
 * <p>版权: rivamed2018</p>
 *
 * @author wanghualin
 * @version V1.0
 * @date 2019/4/26
 */
public class MyChatClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg);
    }
}
