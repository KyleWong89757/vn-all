package com.ms.vn.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 队列配置  可以配置多个队列
 */
@Configuration
public class QueueConfig {
    @Value("${defineProps.rabbitmq.queuename.north}")
    private String north;
    @Value("${defineProps.rabbitmq.queuename.south}")
    private String south;
    @Bean
    public Queue northQueue() {
        /**
         durable="true" 持久化 rabbitmq重启的时候不需要创建新的队列
         auto-delete 表示消息队列没有在使用时将被自动删除 默认是false
         exclusive  表示该消息队列是否只在当前connection生效,默认是false
         */
        return new Queue(north,true,false,false);
    }

    @Bean
    public Queue southQueue() {
        return new Queue(south,true,false,false);
    }
}
