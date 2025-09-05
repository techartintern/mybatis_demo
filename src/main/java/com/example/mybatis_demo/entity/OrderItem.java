package com.example.mybatis_demo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
  private Long id;
  private Long articleId;
  private Article article; // For joined queries
  private Integer orderedQuantity;
  private BigDecimal unitPrice;
  private BigDecimal totalPrice;
  private LocalDateTime createdAt;
}
