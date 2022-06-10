package com.starsofocean.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {
    //声明FanoutExchange交换机
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("starsofocean.fanout");
    }
    //声明Queue队列1
    @Bean
    public Queue fanoutQueue1(){
        return new Queue("fanout.queue1");
    }
    //绑定队列1和交换机
    @Bean
    public Binding bindQueueAndFanoutExchange1(Queue fanoutQueue1,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }
    //声明Queue队列2
    @Bean
    public Queue fanoutQueue2(){
        return new Queue("fanout.queue2");
    }
    //绑定队列2和交换机
    @Bean
    public Binding bindQueueAndFanoutExchange2(Queue fanoutQueue2,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
    }
}
