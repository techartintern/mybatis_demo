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
public class Article {
  private Long id;
  private String name;
  private String description;
  private Category category;
  private BigDecimal price;
  private Integer availableQuantity;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
