package com.protobuf;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class ProtoBufClientHandler extends SimpleChannelInboundHandler<DataInfo.Person> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Person msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        int randoNum = new Random().nextInt(2);
        DataInfo.Person person=null;
        if (0==randoNum){
            person = DataInfo.Person.newBuilder()
                    .setType(DataInfo.Person.Type.StudentType)
                    .setStudent(DataInfo.Student.newBuilder().setName("小李").setAddress("成都高新区").build())
                    .build();
        }else {
            person = DataInfo.Person.newBuilder()
                    .setType(DataInfo.Person.Type.TeacherType)
                    .setTeacher(DataInfo.Teacher.newBuilder().setName("tang").setAddress("成都锦江区").build())
                    .build();
        }
        ctx.channel().writeAndFlush(person);



    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(cause.getMessage());
    }
}
