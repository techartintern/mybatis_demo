package com.example.mybatis_demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mybatis_demo.entity.OrderItem;
import com.example.mybatis_demo.service.OrderItemService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/order-items")
@RequiredArgsConstructor
public class OrderItemController {

  private final OrderItemService orderItemService;

  @GetMapping
  public ResponseEntity<List<OrderItem>> getAllOrderItems() {
    return ResponseEntity.ok(orderItemService.getAllOrderItems());
  }

  @GetMapping("/{id}")
  public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Long id) {
    return orderItemService.getOrderItemById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping("/order/{orderId}")
  public ResponseEntity<List<OrderItem>> getOrderItemsByOrderId(@PathVariable Long orderId) {
    return ResponseEntity.ok(orderItemService.getOrderItemsByOrderId(orderId));
  }

  @PostMapping
  public ResponseEntity<String> createOrderItem(@RequestBody OrderItem orderItem) {
    boolean created = orderItemService.createOrderItem(orderItem);
    return created ? ResponseEntity.ok("Order item created successfully") :
                     ResponseEntity.badRequest().body("Failed to create order item");
  }

  @PutMapping
  public ResponseEntity<String> updateOrderItem(@RequestBody OrderItem orderItem) {
    boolean updated = orderItemService.updateOrderItem(orderItem);
    return updated ? ResponseEntity.ok("Order item updated successfully") :
                     ResponseEntity.badRequest().body("Failed to update order item");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteOrderItem(@PathVariable Long id) {
    boolean deleted = orderItemService.deleteOrderItem(id);
    return deleted ? ResponseEntity.ok("Order item deleted successfully") :
                     ResponseEntity.badRequest().body("Failed to delete order item");
  }
}