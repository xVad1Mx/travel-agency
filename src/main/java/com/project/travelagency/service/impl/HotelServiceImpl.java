package com.project.travelagency.service.impl;

import com.project.travelagency.entity.Hotel;
import com.project.travelagency.repository.HotelRepository;
import com.project.travelagency.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        return (Hotel) hotelRepository.save(hotel);
    }

    @Override
    public Page<Hotel> getAll(Pageable pageable) {
        return hotelRepository.findAll(pageable);
    }

    @Override
    public Optional<Hotel> getHotelById(Long id) {
        return hotelRepository.findById(id);
    }

    @Override
    public Hotel updateHotel(Long id, Hotel hotel) throws Throwable {
        Hotel hotelToUpdate = (Hotel) hotelRepository.findById(id).stream().findFirst().orElseThrow(() -> new EntityNotFoundException(String.format("Can not found entity with id %s", id)));
        hotelToUpdate.setName(hotel.getName());
        hotelToUpdate.setStars(hotel.getStars());
        hotelToUpdate.setWebsite(hotel.getWebsite());
        hotelToUpdate.setLatitude(hotel.getLatitude());
        hotelToUpdate.setLongitude(hotel.getLongitude());
        hotelToUpdate.setFeatures(hotel.getFeatures());
        return (Hotel) hotelRepository.save(hotelToUpdate);
    }

    @Override
    public void deleteHotelById(Long id) {
        hotelRepository.deleteById(id);
    }
}
