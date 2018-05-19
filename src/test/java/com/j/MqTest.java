package com.j;

import com.j.mq.config.MqEventManager;
import com.j.mq.config.model.TestMqMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @version 1.0 created by xxxx on 2018/5/19 23:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MqTest {

    @Autowired
    MqEventManager mqEventManager;
    @Test
    public void test1(){
        //发送一个消息
        for(int i=0;i<10;i++){
            TestMqMessage mqMessage = new TestMqMessage();
            mqMessage.setMessge("我发送了mq消息"+i);
            mqEventManager.publish(MqEventManager.WQ_TEST_ROUTINGKEY_COMMON+"test",mqMessage);

        }
    }
    @Test
    public void test2(){
        //发送一个消息
        for(int i=0;i<10;i++){
            mqEventManager.publish(MqEventManager.WQ_TEST_ROUTINGKEY_COMMON+"test","我发送了mq消息"+i);

        }
    }
}
