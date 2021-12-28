package com.project.travelagency.entity;

import lombok.Data;

import javax.persistence.*;
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

    //@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Long userId;

    //@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_id")
    private Long tourId;
}
