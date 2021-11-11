package com.project.travelagency.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "public", name = "hotels")
public class Hotel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "stars")
    private Integer stars;

    @Column(name = "website")
    private String website;

    @Column(name = "latitude")
    private Float latitude;

    @Column(name = "longitude")
    private Float longitude;

    @Column(name = "features")
    private String features;
}
