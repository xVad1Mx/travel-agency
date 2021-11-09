package com.project.travelagency.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(schema = "public", name = "user_tour")
public class UserTour {
    @Id
    @Column(name = "user_id")
    private long user_id;

    @Column(name = "tour_id")
    private long tour_id;
}
