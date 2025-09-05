package com.example.mybatis_demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.mybatis_demo.entity.Order;
import com.example.mybatis_demo.entity.OrderStatus;
import com.example.mybatis_demo.mapper.OrderMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

  private final OrderMapper orderMapper;

  public List<Order> getAllOrders() {
    return orderMapper.findAll();
  }

  public Optional<Order> getOrderById(Long id) {
    return orderMapper.findById(id);
  }

  public Optional<Order> getOrderByIdWithItems(Long id) {
    return orderMapper.findByIdWithItems(id);
  }

  public List<Order> getOrdersByUserId(Long userId) {
    return orderMapper.findByUserId(userId);
  }

  public List<Order> getOrdersByUserIdWithItems(Long userId) {
    return orderMapper.findByUserIdWithItems(userId);
  }

  public List<Order> getOrdersByStatus(OrderStatus status) {
    return orderMapper.findByStatus(status);
  }

  public boolean createOrder(Order order) {
    return orderMapper.insert(order) > 0;
  }

  public boolean updateOrder(Order order) {
    return orderMapper.update(order) > 0;
  }

  public boolean updateOrderStatus(Long id, OrderStatus status) {
    return orderMapper.updateStatus(id, status) > 0;
  }

  public boolean deleteOrder(Long id) {
    return orderMapper.deleteById(id) > 0;
  }

  public boolean addOrderItem(Long orderId, Long orderItemId) {
    return orderMapper.addOrderItem(orderId, orderItemId) > 0;
  }

  public boolean removeOrderItem(Long orderId, Long orderItemId) {
    return orderMapper.removeOrderItem(orderId, orderItemId) > 0;
  }
}