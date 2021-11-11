package com.project.travelagency.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "public", name = "countries")
public class Country {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

}
