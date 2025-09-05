package com.example.mybatis_demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mybatis_demo.entity.Order;
import com.example.mybatis_demo.entity.OrderStatus;
import com.example.mybatis_demo.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;

  @GetMapping
  public ResponseEntity<List<Order>> getAllOrders() {
    return ResponseEntity.ok(orderService.getAllOrders());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
    return orderService.getOrderById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping("/{id}/items")
  public ResponseEntity<Order> getOrderByIdWithItems(@PathVariable Long id) {
    return orderService.getOrderByIdWithItems(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping("/user/{userId}")
  public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable Long userId) {
    return ResponseEntity.ok(orderService.getOrdersByUserId(userId));
  }

  @GetMapping("/user/{userId}/items")
  public ResponseEntity<List<Order>> getOrdersByUserIdWithItems(@PathVariable Long userId) {
    return ResponseEntity.ok(orderService.getOrdersByUserIdWithItems(userId));
  }

  @GetMapping("/status/{status}")
  public ResponseEntity<List<Order>> getOrdersByStatus(@PathVariable OrderStatus status) {
    return ResponseEntity.ok(orderService.getOrdersByStatus(status));
  }

  @PostMapping
  public ResponseEntity<String> createOrder(@RequestBody Order order) {
    boolean created = orderService.createOrder(order);
    return created ? ResponseEntity.ok("Order created successfully") :
                     ResponseEntity.badRequest().body("Failed to create order");
  }

  @PutMapping
  public ResponseEntity<String> updateOrder(@RequestBody Order order) {
    boolean updated = orderService.updateOrder(order);
    return updated ? ResponseEntity.ok("Order updated successfully") :
                     ResponseEntity.badRequest().body("Failed to update order");
  }

  @PatchMapping("/{id}/status")
  public ResponseEntity<String> updateOrderStatus(@PathVariable Long id, @RequestParam OrderStatus status) {
    boolean updated = orderService.updateOrderStatus(id, status);
    return updated ? ResponseEntity.ok("Order status updated successfully") :
                     ResponseEntity.badRequest().body("Failed to update status");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
    boolean deleted = orderService.deleteOrder(id);
    return deleted ? ResponseEntity.ok("Order deleted successfully") :
                     ResponseEntity.badRequest().body("Failed to delete order");
  }

  @PostMapping("/{orderId}/items/{orderItemId}")
  public ResponseEntity<String> addOrderItem(@PathVariable Long orderId, @PathVariable Long orderItemId) {
    boolean added = orderService.addOrderItem(orderId, orderItemId);
    return added ? ResponseEntity.ok("Order item added successfully") :
                   ResponseEntity.badRequest().body("Failed to add order item");
  }

  @DeleteMapping("/{orderId}/items/{orderItemId}")
  public ResponseEntity<String> removeOrderItem(@PathVariable Long orderId, @PathVariable Long orderItemId) {
    boolean removed = orderService.removeOrderItem(orderId, orderItemId);
    return removed ? ResponseEntity.ok("Order item removed successfully") :
                     ResponseEntity.badRequest().body("Failed to remove order item");
  }
}