package com.ms.vn.analysis.config;

import com.ms.vn.rabbitmq.receiver.NorthConsumer;
import com.ms.vn.rabbitmq.receiver.SouthConsumer;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.support.converter.ContentTypeDelegatingMessageConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConsumerConfig {
    @Bean
    public NorthConsumer initNorthConsumer() {
        return new NorthConsumer();
    }

    @Bean
    public SouthConsumer initSouthConsumer() {
        return new SouthConsumer();
    }

    @Bean//("rabbitListenerContainerFactory2")
    public RabbitListenerContainerFactory<?> rabbitListenerContainerFactory(ConnectionFactory connectionFactory, MessageConverter messageConverter){
        //SimpleRabbitListenerContainerFactory发现消息中有content_type有text就会默认将其转换成string类型的
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setConcurrentConsumers(1);// 设置消费者线程数
        factory.setMaxConcurrentConsumers(5);// 设置最大消费者线程数
        factory.setAcknowledgeMode(AcknowledgeMode.AUTO); //设置确认模式手工确认
        factory.setMessageConverter(messageConverter);//设置对象序列化，实现mq传递实体类对象
        return factory;
    }
}
