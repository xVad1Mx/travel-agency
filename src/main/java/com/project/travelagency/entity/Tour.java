package com.project.travelagency.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.awt.font.NumericShaper;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(schema = "public", name = "tour")
public class Tour {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "photo")
    private String photo;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "duration")
    private long duration;

    @Column(name = "description")
    private String description;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "tour_type")
    private String tour_type;

    @Column(name = "hotel_id")
    private long hotel_id;

    @Column(name = "country_id")
    private long country_id;
}
