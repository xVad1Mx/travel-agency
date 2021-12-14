package com.project.travelagency.entity;

import lombok.Data;

import javax.persistence.*;
import java.awt.font.NumericShaper;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(schema = "public", name = "tour")
public class Tour {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "photo")
    private String photo;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "duration")
    private Long duration;

    @Column(name = "description")
    private String description;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "tour_type")
    private String tour_type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;
}
