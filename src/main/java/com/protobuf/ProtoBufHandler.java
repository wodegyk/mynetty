package com.protobuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

<<<<<<< HEAD
/**
 * <p>描述: CmpSystemMsgDao</p>
 * <p>公司: 瑞华康源科技有限公司</p>
 * <p>版权: rivamed2018</p>
 *
 * @author wanghualin
 * @version V1.0
 * @date 2019/4/28
 */
public class ProtoBufHandler extends SimpleChannelInboundHandler<DataInfo.Student> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Student msg) throws Exception {

    }
=======
public class ProtoBufHandler extends SimpleChannelInboundHandler<DataInfo.Person> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Person msg) throws Exception {
        DataInfo.Person.Type type = msg.getType();
        if (DataInfo.Person.Type.TeacherType.equals(type)){
            DataInfo.Teacher teacher = msg.getTeacher();
            System.out.println(teacher.getName());
            System.out.println(teacher.getAddress());
        }else {
            DataInfo.Student student = msg.getStudent();
            System.out.println(student.getName());
            System.out.println(student.getAddress());
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(cause.getMessage());
    }
>>>>>>> eb6afe03d89e8d84b79daba740ee6895cac11bcc
}
