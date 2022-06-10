package com.starsofocean.mq.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

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
    @Test
    public void sendMsg2FanoutExchange(){
        String exchangeName="starsofocean.fanout";
        String message="hello!";
        rabbitTemplate.convertAndSend(exchangeName,"",message);
    }
    @Test
    public void sendMsg2DirectExchangeBlue(){
        String exchangeName="starsofocean.direct";
        String message="hello,blue!";
        rabbitTemplate.convertAndSend(exchangeName,"blue",message);
    }
    @Test
    public void sendMsg2DirectExchangeBlack(){
        String exchangeName="starsofocean.direct";
        String message="hello,black!";
        rabbitTemplate.convertAndSend(exchangeName,"black",message);
    }
    @Test
    public void sendMsg2DirectExchangeRed(){
        String exchangeName="starsofocean.direct";
        String message="hello,red!";
        rabbitTemplate.convertAndSend(exchangeName,"red",message);
    }
    @Test
    public void sendMsg2TopicExchangeChinaNews(){
        String exchangeName="starsofocean.topic";
        String message="hello,China.news";
        rabbitTemplate.convertAndSend(exchangeName,"China.news",message);
    }
    @Test
    public void sendMsg2TopicExchangeChinaWeather(){
        String exchangeName="starsofocean.topic";
        String message="hello,China.weather";
        rabbitTemplate.convertAndSend(exchangeName,"China.weather",message);
    }
    @Test
    public void sendMsg2TopicExchangeUKNews(){
        String exchangeName="starsofocean.topic";
        String message="hello,UK.news";
        rabbitTemplate.convertAndSend(exchangeName,"UK.news",message);
    }
    @Test
    public void sendMsg2TopicExchangeUKWeather(){
        String exchangeName="starsofocean.topic";
        String message="hello,UK.weather";
        rabbitTemplate.convertAndSend(exchangeName,"UK.weather",message);
    }
    @Test
    public void sendMsg2ObjectQueue(){
        Map<String,Object> msg=new HashMap<>();
        msg.put("name","星辰");
        msg.put("age","20");
        rabbitTemplate.convertAndSend("object.queue",msg);
    }
}
