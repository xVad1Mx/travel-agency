package com.project.travelagency.service;

import com.project.travelagency.entity.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface HotelService {
    Object createHotel(Hotel hotel);

    Page<Hotel> getAll(Pageable pageable);

    Optional<Hotel> getHotelById(Long id);

    Hotel updateHotel(Long id, Hotel hotel) throws Throwable;

    void deleteHotelById(Long id);
}
