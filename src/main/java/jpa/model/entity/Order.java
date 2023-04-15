package jpa.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Table(name = "orders")
@Getter
@Entity
public class Order {
    @Id @GeneratedValue
    private Long orderId;

    private Long memberId;

    private LocalDate orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @Builder
    public Order(Long memberId, LocalDate orderDate, OrderStatus status) {
        this.memberId = memberId;
        this.orderDate = orderDate;
        this.status = status;
    }
}
