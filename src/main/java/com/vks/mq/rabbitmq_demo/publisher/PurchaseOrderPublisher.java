package com.vks.mq.rabbitmq_demo.publisher;

import com.vks.mq.rabbitmq_demo.model.OrderStatus;
import com.vks.mq.rabbitmq_demo.model.PurchaseOrder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class PurchaseOrderPublisher {
    @Autowired
    private RabbitTemplate template;
    @Value("&{ust.rabbitmq.queue}")
    private String queue;

    @Value("${ust.rabbitmq.exchange}")
    private String exchange;

    @Value("${ust.rabbitmq.routingkey}")
    private String routing_key;

    @PostMapping("/{consumerName}")
    public String bookOrder(@RequestBody PurchaseOrder order, @PathVariable String consumerName) {
        order.setOrderId(UUID.randomUUID().toString());
        OrderStatus orderStatus = new OrderStatus(order,"ACCEPTED","order places succefully by " + consumerName);
        template.convertAndSend(exchange, routing_key, orderStatus);
        return "Sucess";
    }

}
