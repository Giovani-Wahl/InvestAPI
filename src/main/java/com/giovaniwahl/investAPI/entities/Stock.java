package com.giovaniwahl.investAPI.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome; // Nome da carteira

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User client; // Usuario ao qual a carteira pertence

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant creationDate; // Data de criação da carteira

    @OneToMany(mappedBy = "id.stock")
    private Set<Asset> assets = new HashSet<>(); // Lista de ativos na carteira
}
