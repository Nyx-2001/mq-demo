package com.starsofocean.mq.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAmqpTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    public void sendMsg2SimpleQueue(){
        String queue="simple.queue";
        String message="hello,spring amqp!";
        rabbitTemplate.convertAndSend(queue,message);
    }
    @Test
    public void sendMsg2WorkQueue() throws InterruptedException {
        String queue="simple.queue";
        String message="hello,msg__";
        for (int i=1;i<=50;i++) {
            rabbitTemplate.convertAndSend(queue,message+i);
            Thread.sleep(20);
        }
    }
}
