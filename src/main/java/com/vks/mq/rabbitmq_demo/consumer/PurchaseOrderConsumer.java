package com.vks.mq.rabbitmq_demo.consumer;

import com.vks.mq.rabbitmq_demo.model.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PurchaseOrderConsumer {
    @Value("&{ust.rabbitmq.queue}")
    private String queue;

    @Value("${ust.rabbitmq.exchange}")
    private String exchange;

    @Value("${ust.rabbitmq.routingkey}")
    private String routing_key;

    @RabbitListener(queues = "ust_queue")
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
        System.out.println("Message recived from queue: " + orderStatus);
    }
}
