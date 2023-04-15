package jpa.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class OrderItem {
    @Id @GeneratedValue
    private Long orderItemId;

    private Long itemId;
    private Long orderId;
    private int orderPrice;
    private int count;
    @Builder
    public OrderItem(Long itemId, Long orderId, int orderPrice, int count) {
        this.itemId = itemId;
        this.orderId = orderId;
        this.orderPrice = orderPrice;
        this.count = count;
    }
}
