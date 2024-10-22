package com.giovaniwahl.investAPI.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
}
