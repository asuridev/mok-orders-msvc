package com.suarezr.orders_msvc.orderItem.persistence;

import com.suarezr.orders_msvc.orderItem.persistence.entities.OrderItemEntity;
import com.suarezr.orders_msvc.orderItem.persistence.mappers.OrderItemMapper;
import com.suarezr.orders_msvc.orderItem.persistence.repositories.OrderItemCrudRepository;
import com.suarezr.orders_msvc.orderItem.persistence.repositories.OrderItemPaginationRepository;
import com.suarezr.orders_msvc.orderItem.services.OrderItemServiceRepository;
import com.suarezr.orders_msvc.orderItem.services.dtos.CreateOrderItemDto;
import com.suarezr.orders_msvc.orderItem.services.dtos.UpdateOrderItemDto;
import com.suarezr.orders_msvc.orderItem.services.dtos.OrderItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class OrderItemRepositoryImpl implements OrderItemServiceRepository {

    private final OrderItemCrudRepository orderItemCrudRepository;
    private final OrderItemPaginationRepository orderItemPaginationRepository;
    private final OrderItemMapper orderItemMapper;

    @Override
    public OrderItemDto createOrderItem(CreateOrderItemDto createOrderItemDto) {
        OrderItemEntity newOrderItem = this.orderItemMapper.toOrderItemEntity(createOrderItemDto);
        OrderItemEntity responseQuery = this.orderItemCrudRepository.save(newOrderItem);
        return orderItemMapper.toOrderItemDto(responseQuery);
    }

    @Override
    public Page<OrderItemDto> findAllOrderItems(int page, int limit, String sortBy) {
        Pageable pageRequest = PageRequest.of(page, limit, Sort.by(sortBy));
        return this.orderItemPaginationRepository.findAll(pageRequest).map(this.orderItemMapper::toOrderItemDto);
    }

    @Override
    public Optional<OrderItemDto> findOneOrderItem(String id) {
        return this.orderItemCrudRepository.findById(id).map(this.orderItemMapper::toOrderItemDto);
    }

    @Override
    public Optional<OrderItemDto> updateOrderItem(UpdateOrderItemDto updateOrderItemDto, String id) {
        OrderItemEntity orderItemEntityById = this.orderItemCrudRepository.findById(id).orElse(null);
        if(orderItemEntityById == null) return Optional.empty();;
        OrderItemEntity orderItemEntityUpdate = this.orderItemMapper.merge(updateOrderItemDto, orderItemEntityById);
        OrderItemEntity responseQuery = this.orderItemCrudRepository.save(orderItemEntityUpdate);
        return Optional.of(orderItemMapper.toOrderItemDto(responseQuery));
    }

    @Override
    public void removeOrderItem(String id) {
        this.orderItemCrudRepository.deleteById(id);
    }
}

  