package com.starsofocean.mq.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
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
    @RabbitListener(queues = "fanout.queue1")
    public void listenFanoutQueueMsg1(String msg) {
        System.out.println("spring消费者接收到fanout.queue1消息:【"+msg+"】"+LocalTime.now());
    }
    @RabbitListener(queues = "fanout.queue2")
    public void listenFanoutQueueMsg2(String msg) {
        System.out.println("spring消费者接收到fanout.queue2消息:【"+msg+"】"+LocalTime.now());
    }
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue1"),
            exchange = @Exchange(name = "starsofocean.direct",type = ExchangeTypes.DIRECT),
            key = {"red","blue"}
    ))
    public void listenDirectQueue1(String msg){
        System.out.println("spring消费者1接收到direct消息:【"+msg+"】"+LocalTime.now());
    }
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue2"),
            exchange = @Exchange(name = "starsofocean.direct",type = ExchangeTypes.DIRECT),
            key = {"red","black"}
    ))
    public void listenDirectQueue2(String msg){
        System.out.println("spring消费者2接收到direct消息:【"+msg+"】"+LocalTime.now());
    }
}
