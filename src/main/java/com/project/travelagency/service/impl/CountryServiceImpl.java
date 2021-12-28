package com.project.travelagency.service.impl;

import com.project.travelagency.entity.Country;
import com.project.travelagency.repository.CountryRepository;
import com.project.travelagency.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public Country createCountry(Country country) {
        return (Country) countryRepository.save(country);
    }

    @Override
    public Page<Country> getAll(Pageable pageable) {
        return countryRepository.findAll(pageable);
    }

    @Override
    public Optional<Country> getCountryById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Country updateCountry(Long id, Country country) throws Throwable {
        Country countryToUpdate = (Country) countryRepository.findById(id).stream().findFirst().orElseThrow(() -> new EntityNotFoundException(String.format("Can not found entity with id %s", id)));
        countryToUpdate.setName(country.getName());
        return (Country) countryRepository.save(countryToUpdate);
    }

    @Override
    public void deleteCountryById(Long id) {
        countryRepository.deleteById(id);
    }
}
