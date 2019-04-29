package com.protobuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

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
}
