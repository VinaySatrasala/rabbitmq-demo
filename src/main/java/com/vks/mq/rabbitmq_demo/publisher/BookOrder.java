package com.vks.mq.rabbitmq_demo.publisher;

import org.springframework.beans.factory.annotation.Value;

public class BookOrder {
    @Value("&{ust.rabbitmq.queue}")
    private String queue;

    @Value("${ust.rabbitmq.exchange}")
    private String exchange;

    @Value("${ust.rabbitmq.routingkey}")
    private String routing_key;
}
