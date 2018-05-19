package com.j.mq.config;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author Administrator
 *         #Date 02
 */
@Component
public class MqEventManager {
    /**
     * 核心交换机
     */
    public static final String EXCHANGE_SYNC                                            = "amq.topic";
    /**
     * 延迟交换机
     */
    public static final String EXCHANGE_SYNC_DELAYED                                        = "delayed.topic";


    /**
     * 发送消息的routingkey
     */
    public static final String WQ_TEST_ROUTINGKEY_COMMON ="wq.test.routingkey.";

    /**
     * 发送消息的队列
     */
    public static final String WQ_TEST_QUEUE="wq.test.queue";

    /**
     * 定时上线的死信队列
     */
    public static final String WQ_QUEUE_DLX = "wq_queue_dlx";

    @Resource
    private RabbitTemplate     rabbitTemplate;

    /**
     * 发布消息到指定的exchange,routekey
     *
     * @param exchange
     * @param routeKey
     * @param event
     */
    public void publish(String exchange, String routeKey, Object event) {
        rabbitTemplate.convertAndSend(exchange, routeKey, event);
    }

    public void publish(String exchange, String routeKey, Object event, MessagePostProcessor messagePostProcessor) {
        rabbitTemplate.convertAndSend(exchange, routeKey, event, messagePostProcessor);
    }

    public void publish(String routeKey, Object event) {
        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setHeader("routingKey", routeKey);
                return message;
            }
        };
        rabbitTemplate.convertAndSend(EXCHANGE_SYNC, routeKey, event, messagePostProcessor);
    }

    /**
     * 这里主要是用来给同步系统发送回执的,现在只有cms的同步需要
     *
     * @param routeKey
     * @param event
     * @param syncId
     */
    public void publishNeedAck(String routeKey, Object event, String syncId) {
        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setHeader("routingKey", routeKey);
                message.getMessageProperties().setHeader("syncId", syncId);
                return message;
            }
        };
        rabbitTemplate.convertAndSend(EXCHANGE_SYNC, routeKey, event, messagePostProcessor);
    }

    /**
     * 发送延迟消息
     *
     * @param routeKey
     * @param event
     *            消息
     * @param delayed
     *            单位为毫秒
     */
    public void publishDxl(final long delayed, final String routeKey, Object event) {
        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setHeader("routingKey", routeKey);
                message.getMessageProperties().setHeader("x-delay", delayed);
                return message;
            }
        };
        rabbitTemplate.convertAndSend(EXCHANGE_SYNC_DELAYED, routeKey, event, messagePostProcessor);
    }


}
