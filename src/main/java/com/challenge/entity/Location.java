package com.challenge.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Location {
	@Id
	@GeneratedValue
    private long id;
    private String city;
    private double latitude;
    private double longitude;
}
