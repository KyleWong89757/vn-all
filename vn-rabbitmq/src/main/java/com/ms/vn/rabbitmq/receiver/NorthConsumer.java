package com.ms.vn.rabbitmq.receiver;

import com.ms.vn.domain.dto.LotteryDto;
import com.ms.vn.rabbitmq.dispatcher.AbstractNorthDispatcher;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

/**
 * 消息消费者1
 * @author zhuzhe
 * @date 2018/5/25 17:32
 * @email 1529949535@qq.com
 */
//@Component
public class NorthConsumer {
    @Autowired
    private AbstractNorthDispatcher dispatcher;
    /**
     * queues  指定从哪个队列（queue）订阅消息
     * @param dto
     */
    @RabbitListener(queues = {"north-queue"} )
    public void handleMessage(LotteryDto dto){
        // 处理消息
        try{
             System.out.println("FirstConsumer1111111111接收到消费了FirstConsumer {} handleMessage :"+dto+"1111111111111111111");
             Thread.sleep(3000);
             dispatcher.Dispatch(dto);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
