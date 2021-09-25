package com.example.listingapp.controller;

import com.example.listingapp.model.Listing;
import com.example.listingapp.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ListingEndpoint {
    private final ListingService listingService;

    @GetMapping("/listings")
    public List<Listing> listings() {
        return listingService.findAll();
    }

    @GetMapping("/listings/{id}")
    public ResponseEntity<Listing> getListing(@PathVariable("id") int id) {
        Optional<Listing> byId = listingService.findById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byId.get());
    }

    @PostMapping("/listings")
    public Listing listing(@RequestBody Listing listing) {
        return listingService.save(listing);
    }

    @PutMapping("/listings/{id}")
    public ResponseEntity<Listing> listing(@PathVariable("id") int id, @RequestBody Listing listing) {
        Optional<Listing> byId = listingService.findById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Listing listing1 = byId.get();
        listing1.setTitle(listing.getTitle());
        listing1.setDescription(listing.getDescription());
        listing.setPrice(listing.getPrice());


        return ResponseEntity.ok().body(listingService.save(listing1));
    }

    @DeleteMapping("/listings/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        listingService.deleteById(id);
    }
}
