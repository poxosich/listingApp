package com.example.listingapp.controller;

import com.example.listingapp.model.CategoryMd;
import com.example.listingapp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
public class CategoryMdEndPoint {
    private final CategoryService categoryService;

    @GetMapping("/categoryMds")
    public List<CategoryMd> categoryMds() {
        return categoryService.findAll();
    }

    @GetMapping("/categoryMds/{id}")
    public ResponseEntity<CategoryMd> getCategory(@PathVariable("id") int id) {
        Optional<CategoryMd> byId = categoryService.findById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byId.get());
    }

    @PostMapping("/categoryMds")
    public CategoryMd categoryMd(@RequestBody CategoryMd categoryMd) {
        return categoryService.save(categoryMd);
    }

    @PutMapping("/categoryMds/{id}")
    public ResponseEntity<CategoryMd> categoryMd(@PathVariable("id") int id, @RequestBody CategoryMd categoryMd) {
        Optional<CategoryMd> byId = categoryService.findById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        CategoryMd categoryMdDb = byId.get();
        categoryMdDb.setName(categoryMd.getName());

        return ResponseEntity.ok().body(categoryService.save(categoryMdDb));
    }
    @DeleteMapping("/categoryMds/{id}")
    public ResponseEntity<CategoryMd> deleteById(@PathVariable("id") int id) {
        Optional<CategoryMd> byId = categoryService.findById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}