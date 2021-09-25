package com.example.listingapp.service;

import com.example.listingapp.model.CategoryMd;
import com.example.listingapp.model.Listing;
import com.example.listingapp.repository.ListingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ListingService {
    private final ListingRepository listingRepository;

    public List<Listing> findAll() {
        return listingRepository.findAll();
    }

    public Optional<Listing> findById(int id) {
        return listingRepository.findById(id);
    }

    public Listing save(Listing listing) {
        return listingRepository.save(listing);
    }

    public boolean deleteById(int id) {
        listingRepository.deleteById(id);
        return true;
    }
}
