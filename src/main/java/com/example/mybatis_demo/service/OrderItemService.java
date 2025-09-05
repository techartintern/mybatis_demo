package com.example.mybatis_demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.mybatis_demo.entity.OrderItem;
import com.example.mybatis_demo.mapper.OrderItemMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderItemService {

  private final OrderItemMapper orderItemMapper;

  public List<OrderItem> getAllOrderItems() {
    return orderItemMapper.findAll();
  }

  public Optional<OrderItem> getOrderItemById(Long id) {
    return orderItemMapper.findById(id);
  }

  public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
    return orderItemMapper.findByOrderId(orderId);
  }

  public boolean createOrderItem(OrderItem orderItem) {
    return orderItemMapper.insert(orderItem) > 0;
  }

  public boolean updateOrderItem(OrderItem orderItem) {
    return orderItemMapper.update(orderItem) > 0;
  }

  public boolean deleteOrderItem(Long id) {
    return orderItemMapper.deleteById(id) > 0;
  }
}