package com.giovaniwahl.investAPI.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
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

    public Stock() {}

    public Stock(UUID id, String nome, User client, Instant creationDate) {
        this.id = id;
        this.nome = nome;
        this.client = client;
        this.creationDate = creationDate;
    }

    public UUID getId() {return id;}
    public void setId(UUID id) {this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public User getClient() {return client;}
    public void setClient(User client) {this.client = client;}

    public Instant getCreationDate() {return creationDate;}
    public void setCreationDate(Instant creationDate) {this.creationDate = creationDate;}

    public Set<Asset> getAssets() {return assets;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;
        return Objects.equals(id, stock.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
