package com.project.travelagency.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(schema = "public", name = "reviews")
public class Review {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "text")
    private String text;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "tour_id")
    private Long tour_id;
}
