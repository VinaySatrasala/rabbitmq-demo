package com.vks.mq.rabbitmq_demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PurchaseOrder {
    private String orderId;
    private String company;
    private int qty;
    private int price;
}
