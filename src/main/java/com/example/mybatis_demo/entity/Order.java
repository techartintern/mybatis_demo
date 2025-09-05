package com.example.mybatis_demo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
  private Long id;
  private LocalDateTime orderDate;
  private Long orderedBy;
  private AppUser user; // For joined queries
  private OrderStatus status;
  private BigDecimal totalAmount;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private List<OrderItem> orderItems;
}
