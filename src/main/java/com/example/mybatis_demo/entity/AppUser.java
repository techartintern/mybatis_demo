package com.example.mybatis_demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUser {
  private Long id;
  private String firstName;
  private String lastName;
  private String username;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
