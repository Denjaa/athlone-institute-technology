package com.ait.assignment.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class MotorbikeShop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    private int year;
    private int price;

    public MotorbikeShop(String name, String description, int year, int price) {
        this.name = name;
        this.description = description;
        this.year = year;
        this.price = price;
    }

}