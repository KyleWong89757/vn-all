package com.ms.vn.rabbitmq;

import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class VnRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(VnRabbitmqApplication.class, args);
        //SimpleMessageListenerContainer运行时动态的添加监听队列
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(VnRabbitmqApplication.class);
//        SimpleMessageListenerContainer container = context.getBean(SimpleMessageListenerContainer.class);
//        container.addQueueNames("queue2");
//        container.removeQueueNames("queue2");//SimpleMessageListenerContainer运行时后动态的移除监听队列
//        context.close();
    }
}
