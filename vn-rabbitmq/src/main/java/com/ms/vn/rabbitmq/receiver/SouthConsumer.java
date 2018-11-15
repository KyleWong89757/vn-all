package com.ms.vn.rabbitmq.receiver;

import com.ms.vn.domain.dto.LotteryDto;
import com.ms.vn.rabbitmq.dispatcher.AbstractNorthDispatcher;
import com.ms.vn.rabbitmq.dispatcher.AbstractSouthDispatcher;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * 消息消费者1
 * @author zhuzhe
 * @date 2018/5/25 17:32
 * @email 1529949535@qq.com
 */
//@Component
@RabbitListener(queues = {"south-queue"})
public class SouthConsumer {
    @Autowired
    private AbstractSouthDispatcher dispatcher;
    /**
     * queues  指定从哪个队列（queue）订阅消息
     * @param dto
     */
    @RabbitHandler
    public void handleMessage(LotteryDto dto, Channel channel,@Header(AmqpHeaders.DELIVERY_TAG) long tag){
        try{
            System.out.println("====接收到消费消息===handleMessage2"+dto+"222222222222222222222222222222");
            Thread.sleep(3000);
            dispatcher.Dispatch(dto);
//`设置手动确认消费 ：AcknowledgeMode.MANUAL
//          channel.basicAck(tag,false);            // 确认消息
//          channel.basicAck(tag,false);    //重新入队列然后一直重新消费
//          channel.basicReject(tag,false);        //拒绝消息
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
