package com.j.mq.listener;

/**
 * @version 1.0 created by xxxx on 2018/5/19 23:03
 */

/*
@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = MqEventManager.WQ_TEST_QUEUE, durable = "true"), exchange = @Exchange(value = MqEventManager.EXCHANGE_SYNC, type = ExchangeTypes.TOPIC, durable = "true"), key = MqEventManager.WQ_TEST_ROUTINGKEY_COMMON +"#"))
*/
// 设置延迟队列与延迟exchange dinding
/*
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = MqEventManager.WQ_QUEUE_DLX, durable = "true"), exchange = @Exchange(value = MqEventManager.EXCHANGE_SYNC_DELAYED, delayed = "true", type = ExchangeTypes.TOPIC, durable = "true"), key = MqEventManager.WQ_TEST_ROUTINGKEY_COMMON +"#"))
*/
public class WqMqListener {
   /* private final static Logger log = LoggerFactory.getLogger(WqMqListener.class);

    @RabbitHandler
    public void receiveMessage(MqMessage messge) {
        System.out.println("我接受了topic模式的消息;"+ JSON.toJSONString(messge));
    }

    @RabbitHandler
    public void receiveMessage(String messge) {
        System.out.println("我接受了topic模式的消息;"+ JSON.toJSONString(messge));
    }
*/}

