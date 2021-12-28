package com.project.travelagency.controller;

import com.project.travelagency.entity.Country;
import com.project.travelagency.entity.Review;
import com.project.travelagency.service.CountryService;
import com.project.travelagency.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/countries")
@RestController
public class CountryController {
    private final CountryService countryService;

    @GetMapping
    public Page<Country> getAll(@PageableDefault(size = 15, sort = "id") Pageable pageable) {
        return countryService.getAll(pageable);
    }
    @PostMapping
    public Object create(@RequestBody Country country) {
        return countryService.createCountry(country);
    }

    @PutMapping("/{id}")
    public Country update(@PathVariable("id") Long id, @RequestBody Country country) throws Throwable {
        return countryService.updateCountry(id, country);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        countryService.deleteCountryById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable("id") Long id) {
        Country country = countryService.getCountryById(id).stream().findFirst().orElseThrow(() -> new RuntimeException());
        return ResponseEntity.ok(country);
    }
}
