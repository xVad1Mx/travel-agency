package com.project.travelagency.service.impl;

import com.project.travelagency.entity.Tour;
import com.project.travelagency.repository.TourRepository;
import com.project.travelagency.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TourServiceImpl implements TourService {

    private final TourRepository tourRepository;

    @Override
    @Transactional
    public Tour createTour(Tour tour) {
        return tourRepository.save(tour);
    }

    @Override
    public Page<Tour> getAll(Pageable pageable) {
        return tourRepository.findAll(pageable);
    }

    @Override
    public Optional<Tour> getTourById(Long id) {
        return tourRepository.findById(id);
    }

    @Override
    public Tour updateTour(Long id, Tour tour) {
        Tour tourToUpdate = tourRepository.findById(id).stream().findFirst().orElseThrow(() -> new EntityNotFoundException(String.format("Can not found entity with id %s", id)));
        tour.setPhoto(tourToUpdate.getPhoto());
        tour.setDate(tourToUpdate.getDate());
        tour.setDuration(tourToUpdate.getDuration());
        tour.setCost(tourToUpdate.getCost());
        tour.setDescription(tourToUpdate.getDescription());
        tour.setTour_type(tourToUpdate.getTour_type());

        return tourRepository.save(tour);
    }

    @Override
    public void deleteTourById(Long id) {
        tourRepository.deleteById(id);
    }
}
