package com.example.mybatis_demo.mapper;

import java.util.List;
import java.util.Optional;

import com.example.mybatis_demo.entity.AppUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AppUserMapper {

  List<AppUser> findAll();

  Optional<AppUser> findById(@Param("id") Long id);

  Optional<AppUser> findByUsername(@Param("username") String username);

  int insert(AppUser user);

  int update(AppUser user);

  int deleteById(@Param("id") Long id);
}
