package com.example.mybatis_demo.mapper;

import com.example.mybatis_demo.entity.Order;
import com.example.mybatis_demo.entity.OrderStatus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface OrderMapper {

  List<Order> findAll();

  Optional<Order> findById(@Param("id") Long id);

  Optional<Order> findByIdWithItems(@Param("id") Long id);

  List<Order> findByUserId(@Param("userId") Long userId);

  List<Order> findByUserIdWithItems(@Param("userId") Long userId);

  List<Order> findByStatus(@Param("status") OrderStatus status);

  int insert(Order order);

  int update(Order order);

  int updateStatus(@Param("id") Long id, @Param("status") OrderStatus status);

  int deleteById(@Param("id") Long id);

  // Junction table operations
  int addOrderItem(@Param("orderId") Long orderId, @Param("orderItemId") Long orderItemId);

  int removeOrderItem(@Param("orderId") Long orderId, @Param("orderItemId") Long orderItemId);
}
