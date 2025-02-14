package com.vks.mq.rabbitmq_demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderStatus {
    private PurchaseOrder order;
    private String status;
    private String message;
}
