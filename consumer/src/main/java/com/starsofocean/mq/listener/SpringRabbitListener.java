package com.starsofocean.mq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class SpringRabbitListener {

//    @RabbitListener(queues = "simple.queue")
//    public void listenSimpleQueueMsg(String msg){
//        System.out.println("spring消费者接收到消息:【"+msg+"】");
//    }
@RabbitListener(queues = "simple.queue")
public void listenWorkQueueMsg1(String msg) throws InterruptedException {
    System.out.println("spring消费者1接收到消息:【"+msg+"】"+ LocalTime.now());
    Thread.sleep(20);
}
    @RabbitListener(queues = "simple.queue")
    public void listenWorkQueueMsg2(String msg) throws InterruptedException {
        System.err.println("spring消费者2接收到消息:【"+msg+"】"+LocalTime.now());
        Thread.sleep(100);
    }
}
