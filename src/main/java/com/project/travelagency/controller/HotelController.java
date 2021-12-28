package com.project.travelagency.controller;

import com.project.travelagency.entity.Country;
import com.project.travelagency.entity.Hotel;
import com.project.travelagency.service.CountryService;
import com.project.travelagency.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/hotels")
@RestController
public class HotelController {
    private final HotelService hotelService;

    @GetMapping
    public Page<Hotel> getAll(@PageableDefault(size = 15, sort = "id") Pageable pageable) {
        return hotelService.getAll(pageable);
    }

    @PostMapping
    public Object create(@RequestBody Hotel hotel) {
        return hotelService.createHotel(hotel);
    }

    @PutMapping("/{id}")
    public Hotel update(@PathVariable("id") Long id, @RequestBody Hotel hotel) throws Throwable {
        return hotelService.updateHotel(id, hotel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        hotelService.deleteHotelById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable("id") Long id) {
        Hotel hotel = hotelService.getHotelById(id).stream().findFirst().orElseThrow(() -> new RuntimeException());
        return ResponseEntity.ok(hotel);
    }

}
