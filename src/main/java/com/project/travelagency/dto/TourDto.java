package com.project.travelagency.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TourDto {

    private Long id;
    private String photo;
    private LocalDate date;
    private Long duration;
    private String description;
    private BigDecimal cost;
    private Long hotel;
    private Long country;
}
