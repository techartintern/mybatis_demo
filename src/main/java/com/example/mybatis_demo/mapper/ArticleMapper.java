package com.example.mybatis_demo.mapper;

import com.example.mybatis_demo.entity.Article;
import com.example.mybatis_demo.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ArticleMapper {

  List<Article> findAll();

  Optional<Article> findById(@Param("id") Long id);

  List<Article> findByCategory(@Param("category") Category category);

  List<Article> findByNameContaining(@Param("name") String name);

  List<Article> findAvailableArticles();

  int insert(Article article);

  int update(Article article);

  int updateQuantity(@Param("id") Long id, @Param("quantity") Integer quantity);

  int deleteById(@Param("id") Long id);
}
