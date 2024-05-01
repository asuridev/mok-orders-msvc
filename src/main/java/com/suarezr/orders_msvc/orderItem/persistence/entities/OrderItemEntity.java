package com.suarezr.orders_msvc.orderItem.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.suarezr.orders_msvc.common.audit.AuditableEntity;
import com.suarezr.orders_msvc.order.persistence.entities.OrderEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners({AuditingEntityListener.class})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="order_items")
@Entity
public class OrderItemEntity extends AuditableEntity {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String id;

    @Column(name = "product_id")
    private String productId;

    private Integer quantity;

    @JsonIgnore
    @JoinColumn(name="order_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private OrderEntity order;
}

  