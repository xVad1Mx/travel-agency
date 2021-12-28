package com.project.travelagency.controller;

import com.project.travelagency.entity.Review;
import com.project.travelagency.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/reviews")
@RestController
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public Page<Review> getAll(@PageableDefault(size = 15, sort = "id") Pageable pageable) {
        return reviewService.getAll(pageable);
    }
    @PostMapping
    public Object create(@RequestBody Review review) {
        return reviewService.createReview(review);
    }

    @PutMapping("/{id}")
    public Review update(@PathVariable("id") Long id, @RequestBody Review review) {
        return reviewService.updateReview(id, review);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        reviewService.deleteReviewById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable("id") Long id) {
        Review review = reviewService.getReviewById(id).stream().findFirst().orElseThrow(() -> new RuntimeException());
        return ResponseEntity.ok(review);
    }
}
