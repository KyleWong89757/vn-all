package com.ms.vn.rabbitmq.config;

import com.ms.vn.domain.dto.LotteryDto;
import com.ms.vn.rabbitmq.mqcallback.MsgSendConfirmCallBack;
import com.ms.vn.rabbitmq.mqcallback.MsgSendReturnCallback;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.ConsumerTagStrategy;
import org.springframework.amqp.support.converter.ContentTypeDelegatingMessageConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMq配置
 */
@Configuration
public class RabbitMqConfig {

    @Value("${spring.rabbitmq.host}")
    private String host;
    @Value("${spring.rabbitmq.port}")
    private int port;
    @Value("${spring.rabbitmq.username}")
    private String username;
    @Value("${spring.rabbitmq.password}")
    private String password;
    @Value("${spring.rabbitmq.virtual-host}")
    private String vhost;

    @Value("${defineProps.rabbitmq.queue1_pattern}")
    private String queue1_pattern;
    @Value("${defineProps.rabbitmq.queue2_pattern}")
    private String queue2_pattern;

    @Autowired
    private QueueConfig queueConfig;
    @Autowired
    private ExchangeConfig exchangeConfig;

    /**
     * 连接工厂 不需要在容器中去声明ConnectionFactory，RabbitAdmin，RabbitTemplate了，sprngboot自动帮我们管理了。
     */
//    @Bean
//    public ConnectionFactory connectionFactory() {
//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host, port);
//        connectionFactory.setUsername(username);
//        connectionFactory.setPassword(password);
//        connectionFactory.setVirtualHost(vhost);
//        return connectionFactory;
//    }

    /**
     将消息队列1和交换机进行绑定,，binding_key为queue1_pattern模糊匹配
     */
    @Bean
    public Binding binding_one() {
        return BindingBuilder.bind(queueConfig.northQueue()).to(exchangeConfig.topicExchange()).with(queue1_pattern);
    }

    /**
     * 将消息队列2和交换机进行绑定
     */
    @Bean
    public Binding binding_two() {
        return BindingBuilder.bind(queueConfig.southQueue()).to(exchangeConfig.topicExchange()).with(queue2_pattern);
    }

    /**
     * queue listener  观察 监听模式
     * 当有消息到达时会通知监听在对应的队列上的监听对象
     * @return
     */
//    @Bean
//    public SimpleMessageListenerContainer simpleMessageListenerContainer_one(ConnectionFactory connectionFactory){
//        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer(connectionFactory);
//        simpleMessageListenerContainer.addQueues(queueConfig.firstQueue(),queueConfig.secondQueue()); //可以监听多个队列,逗号隔开
//        simpleMessageListenerContainer.setExposeListenerChannel(true);
//        simpleMessageListenerContainer.setMaxConcurrentConsumers(5);// 设置最大消费者线程数
//        simpleMessageListenerContainer.setConcurrentConsumers(1);// 设置消费者线程数
//        simpleMessageListenerContainer.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
////        simpleMessageListenerContainer.setMessageListener((MessageListener) message -> {
////            System.out.println("====接收到消息=====");
////            System.out.println(message.getMessageProperties());
////            System.out.println(new String(message.getBody()));
////        });
//        simpleMessageListenerContainer.setMessageListener(null);
//        simpleMessageListenerContainer.setMessageConverter(new Jackson2JsonMessageConverter());//RabbitMQ 提供了 Jackson2JsonMessageConverter 来支持消息内容 JSON 序列化与反序列化,消息发送者在发送消息时应设置 MessageConverter 为 Jackson2JsonMessageConverter
////        simpleMessageListenerContainer.setMessageListener(wechatPushMessageListener());
//        //后置处理器，接收到的消息都添加了Header请求头
////        simpleMessageListenerContainer.setAfterReceivePostProcessors(message -> {
////            message.getMessageProperties().getHeaders().put("desc",10);
////            return message;
////        });
//        return simpleMessageListenerContainer;
//    }


    @Bean
    public MessageConverter messageConverter() {
        return new ContentTypeDelegatingMessageConverter(new Jackson2JsonMessageConverter());
    }
//    @Bean//("rabbitListenerContainerFactory2")
//    public RabbitListenerContainerFactory<?> rabbitListenerContainerFactory(ConnectionFactory connectionFactory,MessageConverter messageConverter){
//        //SimpleRabbitListenerContainerFactory发现消息中有content_type有text就会默认将其转换成string类型的
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory);
//        factory.setConcurrentConsumers(1);// 设置消费者线程数
//        factory.setMaxConcurrentConsumers(5);// 设置最大消费者线程数
//        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
//        factory.setMessageConverter(messageConverter);//设置对象序列化，实现mq传递实体类对象
//        return factory;
//    }
//    /**
//     * 定义rabbit template用于数据的接收和发送
//     * @return
//     */
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,MessageConverter messageConverter) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        /**若使用confirm-callback或return-callback，
         * 必须要配置publisherConfirms或publisherReturns为true
         * 每个rabbitTemplate只能有一个confirm-callback和return-callback
         */
        template.setConfirmCallback(msgSendConfirmCallBack());
        template.setReturnCallback(msgSendReturnCallback());
        template.setMessageConverter(messageConverter);////设置对象序列化，实现mq传递实体类对象
        /**
         * 使用return-callback时必须设置mandatory为true，或者在配置中设置mandatory-expression的值为true，
         * 可针对每次请求的消息去确定’mandatory’的boolean值，
         * 只能在提供’return -callback’时使用，与mandatory互斥
         */
//          template.setMandatory(true);
        return template;
    }

    /**
     * 消息确认机制
     * Confirms给客户端一种轻量级的方式，能够跟踪哪些消息被broker处理，
     * 哪些可能因为broker宕掉或者网络失败的情况而重新发布。
     * 确认并且保证消息被送达，提供了两种方式：发布确认和事务。(两者不可同时使用)
     * 在channel为事务时，不可引入确认模式；同样channel为确认模式下，不可使用事务。
     * @return
     */
    @Bean
    public MsgSendConfirmCallBack msgSendConfirmCallBack(){
        return new MsgSendConfirmCallBack();
    }
    /**  关于 msgSendConfirmCallBack 和 msgSendReturnCallback 的回调说明：
       1.如果消息没有到exchange,则confirm回调,ack=false
       2.如果消息到达exchange,则confirm回调,ack=true
       3.exchange到queue成功,则不回调return
       4.exchange到queue失败,则回调return(需设置mandatory=true,否则不回回调,消息就丢了)
   */
    @Bean
    public MsgSendReturnCallback msgSendReturnCallback(){
        return new MsgSendReturnCallback();
    }
}
