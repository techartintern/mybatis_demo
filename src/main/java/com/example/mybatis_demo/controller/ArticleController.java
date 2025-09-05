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

import com.example.mybatis_demo.entity.Article;
import com.example.mybatis_demo.entity.Category;
import com.example.mybatis_demo.service.ArticleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class ArticleController {

  private final ArticleService articleService;

  @GetMapping
  public ResponseEntity<List<Article>> getAllArticles() {
    return ResponseEntity.ok(articleService.getAllArticles());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
    return articleService.getArticleById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping("/category/{category}")
  public ResponseEntity<List<Article>> getArticlesByCategory(@PathVariable Category category) {
    return ResponseEntity.ok(articleService.getArticlesByCategory(category));
  }

  @GetMapping("/search")
  public ResponseEntity<List<Article>> searchArticlesByName(@RequestParam String name) {
    return ResponseEntity.ok(articleService.searchArticlesByName(name));
  }

  @GetMapping("/available")
  public ResponseEntity<List<Article>> getAvailableArticles() {
    return ResponseEntity.ok(articleService.getAvailableArticles());
  }

  @PostMapping
  public ResponseEntity<String> createArticle(@RequestBody Article article) {
    boolean created = articleService.createArticle(article);
    return created ? ResponseEntity.ok("Article created successfully") :
                     ResponseEntity.badRequest().body("Failed to create article");
  }

  @PutMapping
  public ResponseEntity<String> updateArticle(@RequestBody Article article) {
    boolean updated = articleService.updateArticle(article);
    return updated ? ResponseEntity.ok("Article updated successfully") :
                     ResponseEntity.badRequest().body("Failed to update article");
  }

  @PatchMapping("/{id}/quantity")
  public ResponseEntity<String> updateQuantity(@PathVariable Long id, @RequestParam Integer quantity) {
    boolean updated = articleService.updateArticleQuantity(id, quantity);
    return updated ? ResponseEntity.ok("Quantity updated successfully") :
                     ResponseEntity.badRequest().body("Failed to update quantity");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteArticle(@PathVariable Long id) {
    boolean deleted = articleService.deleteArticle(id);
    return deleted ? ResponseEntity.ok("Article deleted successfully") :
                     ResponseEntity.badRequest().body("Failed to delete article");
  }
}