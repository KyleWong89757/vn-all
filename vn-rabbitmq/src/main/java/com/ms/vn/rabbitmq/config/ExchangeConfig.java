package com.ms.vn.rabbitmq.config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消息交换机配置  可以配置多个
 */
@Configuration
public class ExchangeConfig {

    /** 消息交换机的名字*/
    @Value("${defineProps.rabbitmq.topic}")
    private String templateTopic;

    /**
     *   1.定义topic exchange，绑定路由
     *   2.direct交换器相对来说比较简单，匹配规则为：如果路由键匹配，消息就被投送到相关的队列
     *     fanout交换器中没有路由键的概念，他会把消息发送到所有绑定在此交换器上面的队列中。
     *     topic交换器你采用模糊匹配路由键的原则进行转发消息到队列中
     *   3.durable="true" rabbitmq重启的时候不需要创建新的交换机
     *   4.autoDelete:false ,默认不自动删除
     *   5.key: queue在该topic exchange中的key值，当消息符合topic exchange中routing_key规则，
     *   消息将会转发给queue参数指定的消息队列
     */
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(templateTopic, true, false);
    }
}
