package com.example.mybatis_demo.mapper;

import com.example.mybatis_demo.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface OrderItemMapper {

  List<OrderItem> findAll();

  Optional<OrderItem> findById(@Param("id") Long id);

  List<OrderItem> findByOrderId(@Param("orderId") Long orderId);

  int insert(OrderItem orderItem);

  int update(OrderItem orderItem);

  int deleteById(@Param("id") Long id);
}
