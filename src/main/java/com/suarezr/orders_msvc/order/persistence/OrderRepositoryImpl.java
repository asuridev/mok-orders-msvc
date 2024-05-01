package com.suarezr.orders_msvc.order.persistence;

import com.suarezr.orders_msvc.order.persistence.entities.OrderEntity;
import com.suarezr.orders_msvc.order.persistence.mappers.OrderMapper;
import com.suarezr.orders_msvc.order.persistence.repositories.OrderCrudRepository;
import com.suarezr.orders_msvc.order.persistence.repositories.OrderPaginationRepository;
import com.suarezr.orders_msvc.order.services.OrderServiceRepository;
import com.suarezr.orders_msvc.order.services.dtos.CreateOrderDto;
import com.suarezr.orders_msvc.order.services.dtos.UpdateOrderDto;
import com.suarezr.orders_msvc.order.services.dtos.OrderDto;
import com.suarezr.orders_msvc.orderItem.services.dtos.OrderItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderServiceRepository {

    private final OrderCrudRepository orderCrudRepository;
    private final OrderPaginationRepository orderPaginationRepository;
    private final OrderMapper orderMapper;

    @Override
    public OrderDto createOrder(CreateOrderDto createOrderDto) {
        OrderEntity newOrder = this.orderMapper.toOrderEntity(createOrderDto);
        OrderEntity responseQuery = this.orderCrudRepository.save(newOrder);
        return orderMapper.toOrderDto(responseQuery);
    }

    @Override
    public Page<OrderEntity> findAllOrders(int page, int limit, String sortBy) {
        Pageable pageRequest = PageRequest.of(page, limit, Sort.by(sortBy));
        return this.orderPaginationRepository.findAll(pageRequest);

    }

    @Override
    public Optional<OrderEntity> findOneOrder(String id) {
        return this.orderCrudRepository.findById(id);
    }

    @Override
    public Optional<OrderEntity> updateOrder(UpdateOrderDto updateOrderDto, String id) {
        OrderEntity orderEntityById = this.orderCrudRepository.findById(id).orElse(null);
        if(orderEntityById == null) return Optional.empty();;
        OrderEntity orderEntityUpdate = this.orderMapper.merge(updateOrderDto, orderEntityById);
        OrderEntity responseQuery = this.orderCrudRepository.save(orderEntityUpdate);
        return Optional.of(responseQuery);
    }

    @Override
    public void removeOrder(String id) {
        this.orderCrudRepository.deleteById(id);
    }
}

  