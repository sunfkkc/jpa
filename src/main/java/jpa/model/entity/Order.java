package jpa.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;


@Table(name = "orders")
@Getter
@Entity
public class Order {
    @Id @GeneratedValue
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDate orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

}
