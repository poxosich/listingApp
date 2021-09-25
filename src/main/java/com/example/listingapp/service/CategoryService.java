package com.example.listingapp.service;

import com.example.listingapp.model.CategoryMd;
import com.example.listingapp.repository.CategoryMdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryMdRepository categoryMdRepository;

    public List<CategoryMd> findAll() {
        return categoryMdRepository.findAll();
    }

    public Optional<CategoryMd> findById(int id) {
        return categoryMdRepository.findById(id);
    }

    public CategoryMd save(CategoryMd categoryMd) {
        return categoryMdRepository.save(categoryMd);
    }

    public boolean deleteById(int id) {
        categoryMdRepository.deleteById(id);
        return true;
    }
}
