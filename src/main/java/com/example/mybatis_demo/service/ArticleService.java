package com.example.mybatis_demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.mybatis_demo.entity.Article;
import com.example.mybatis_demo.entity.Category;
import com.example.mybatis_demo.mapper.ArticleMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleService {

  private final ArticleMapper articleMapper;

  public List<Article> getAllArticles() {
    return articleMapper.findAll();
  }

  public Optional<Article> getArticleById(Long id) {
    return articleMapper.findById(id);
  }

  public List<Article> getArticlesByCategory(Category category) {
    return articleMapper.findByCategory(category);
  }

  public List<Article> searchArticlesByName(String name) {
    return articleMapper.findByNameContaining(name);
  }

  public List<Article> getAvailableArticles() {
    return articleMapper.findAvailableArticles();
  }

  public boolean createArticle(Article article) {
    return articleMapper.insert(article) > 0;
  }

  public boolean updateArticle(Article article) {
    return articleMapper.update(article) > 0;
  }

  public boolean updateArticleQuantity(Long id, Integer quantity) {
    return articleMapper.updateQuantity(id, quantity) > 0;
  }

  public boolean deleteArticle(Long id) {
    return articleMapper.deleteById(id) > 0;
  }
}
