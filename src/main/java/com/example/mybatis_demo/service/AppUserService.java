package com.example.mybatis_demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.mybatis_demo.entity.AppUser;
import com.example.mybatis_demo.mapper.AppUserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppUserService {

  private final AppUserMapper appUserMapper;

  public List<AppUser> getAllUsers() {
    return appUserMapper.findAll();
  }

  public Optional<AppUser> getUserById(Long id) {
    return appUserMapper.findById(id);
  }

  public Optional<AppUser> getUserByUsername(String username) {
    return appUserMapper.findByUsername(username);
  }

  public boolean createUser(AppUser user) {
    return appUserMapper.insert(user) > 0;
  }

  public boolean updateUser(AppUser user) {
    return appUserMapper.update(user) > 0;
  }

  public boolean deleteUser(Long id) {
    return appUserMapper.deleteById(id) > 0;
  }
}