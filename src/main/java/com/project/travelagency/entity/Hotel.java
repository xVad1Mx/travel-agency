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
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "stars")
    private int stars;

    @Column(name = "website")
    private String website;

    @Column(name = "latitude")
    private float latitude;

    @Column(name = "longitude")
    private float longitude;

    @Column(name = "features")
    private String features;
}
