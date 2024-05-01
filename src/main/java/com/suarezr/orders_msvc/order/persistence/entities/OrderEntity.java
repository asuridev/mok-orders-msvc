package com.suarezr.orders_msvc.order.persistence.entities;

import com.suarezr.orders_msvc.common.audit.AuditableEntity;
import com.suarezr.orders_msvc.orderItem.persistence.entities.OrderItemEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@EntityListeners({AuditingEntityListener.class})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="orders")
@Entity
public class OrderEntity extends AuditableEntity {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String id;

    private String owner;

    private String address;

    private String state;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    List<OrderItemEntity> orderItem;
}

  