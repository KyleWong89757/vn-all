package com.ms.vn.rabbitmq.sender;

import com.ms.vn.domain.dto.LotteryDto;
import com.ms.vn.rabbitmq.config.ExchangeConfig;
import com.ms.vn.rabbitmq.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 消息发送  生产者1
 * @author zhuzhe
 * @date 2018/5/25 14:28
 * @email 1529949535@qq.com
 */
@Component
public class MessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Value("${defineProps.rabbitmq.topic}")
    private String templateTopic;
    /**
     * 发送消息
     * 默认传送routingKey
     * @param dto  消息
     */
    public void send(LotteryDto dto) {
        String uuid = UUID.randomUUID().toString();
        CorrelationData correlationId = new CorrelationData(uuid);
        rabbitTemplate.convertAndSend(templateTopic, "vn.south.henei",
                dto, correlationId);
    }
    /**
     * 发送消息
     * @param routingKey 路由主题
     * @param dto  消息
     */
    public void send(LotteryDto dto, String routingKey) {
        String uuid = UUID.randomUUID().toString();
        CorrelationData correlationId = new CorrelationData(uuid);

        rabbitTemplate.convertAndSend(templateTopic, routingKey,
                dto, correlationId);
    }
}
