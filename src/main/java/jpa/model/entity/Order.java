package jpa.model.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "orders")
@Getter
@Entity
@NoArgsConstructor
public class Order {
    @Id @GeneratedValue
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItem;

    private LocalDate orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Builder
    public Order(Member member, List<OrderItem> orderItem, LocalDate orderDate, OrderStatus status) {
        this.member = member;
        this.orderItem = orderItem;
        this.orderDate = orderDate;
        this.status = status;
    }

    public void setMember(Member member) {
        if(this.member != null) {
            this.member.getOrders().remove(this);
        }
        this.member = member;
        member.getOrders().add(this);
    }
}
