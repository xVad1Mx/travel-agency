package com.project.travelagency.service.impl;

import com.project.travelagency.entity.Review;
import com.project.travelagency.repository.ReviewRepository;
import com.project.travelagency.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Page<Review> getAll(Pageable pageable) {
        return reviewRepository.findAll(pageable);
    }

    @Override
    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public Review updateReview(Long id, Review review) {
        Review reviewToUpdate = reviewRepository.findById(id).stream().findFirst().orElseThrow(() -> new EntityNotFoundException(String.format("Can not found entity with id %s", id)));
        reviewToUpdate.setDate(review.getDate());
        reviewToUpdate.setText(review.getText());
        reviewToUpdate.setUserId(review.getUserId());
        reviewToUpdate.setTourId(review.getTourId());
        return reviewRepository.save(reviewToUpdate);
    }

    @Override
    public void deleteReviewById(Long id) {
        reviewRepository.deleteById(id);
    }
}
