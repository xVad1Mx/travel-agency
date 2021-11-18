package com.project.travelagency.controller;

import com.project.travelagency.entity.Tour;
import com.project.travelagency.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/tours")
@RestController
public class TourController {
    private final TourService tourService;

    public Page<Tour> getAll(@PageableDefault(size = 15, sort = "duration") Pageable pageable) {
        return tourService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tour> getTourById(@PathVariable("id") Long id) {
        Tour tour = tourService.getTourById(id).stream().findFirst().orElseThrow(() -> new RuntimeException());
        return ResponseEntity.ok(tour);
    }
}
