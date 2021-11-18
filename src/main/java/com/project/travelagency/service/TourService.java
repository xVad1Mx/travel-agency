package com.project.travelagency.service;

import com.project.travelagency.entity.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TourService {
    Tour createTour(Tour tour);

    Page<Tour> getAll(Pageable pageable);

    Optional<Tour> getTourById(Long id);

    Tour updateTour(Long id, Tour tour);

    void deleteTourById(Long id);
}
