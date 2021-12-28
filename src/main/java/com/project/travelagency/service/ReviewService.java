package com.project.travelagency.service;

import com.project.travelagency.entity.Review;
import com.project.travelagency.repository.ReviewRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ReviewService {
    Object createReview(Review review);

    Page<Review> getAll(Pageable pageable);

    Optional<Review> getReviewById(Long id);

    Review updateReview(Long id, Review review);

    void deleteReviewById(Long id);
}
