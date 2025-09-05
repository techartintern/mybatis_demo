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

import com.example.mybatis_demo.entity.AppUser;
import com.example.mybatis_demo.service.AppUserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class AppUserController {

  private final AppUserService appUserService;

  @GetMapping
  public ResponseEntity<List<AppUser>> getAllUsers() {
    return ResponseEntity.ok(appUserService.getAllUsers());
  }

  @GetMapping("/{id}")
  public ResponseEntity<AppUser> getUserById(@PathVariable Long id) {
    return appUserService.getUserById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping("/username/{username}")
  public ResponseEntity<AppUser> getUserByUsername(@PathVariable String username) {
    return appUserService.getUserByUsername(username)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<String> createUser(@RequestBody AppUser user) {
    boolean created = appUserService.createUser(user);
    return created ? ResponseEntity.ok("User created successfully") :
                     ResponseEntity.badRequest().body("Failed to create user");
  }

  @PutMapping
  public ResponseEntity<String> updateUser(@RequestBody AppUser user) {
    boolean updated = appUserService.updateUser(user);
    return updated ? ResponseEntity.ok("User updated successfully") :
                     ResponseEntity.badRequest().body("Failed to update user");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteUser(@PathVariable Long id) {
    boolean deleted = appUserService.deleteUser(id);
    return deleted ? ResponseEntity.ok("User deleted successfully") :
                     ResponseEntity.badRequest().body("Failed to delete user");
  }
}