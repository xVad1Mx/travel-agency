package com.project.travelagency.service;

import com.project.travelagency.entity.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CountryService {
    Object createCountry(Country country);

    Page<Country> getAll(Pageable pageable);

    Optional<Country> getCountryById(Long id);

    Country updateCountry(Long id, Country country) throws Throwable;

    void deleteCountryById(Long id);
}
