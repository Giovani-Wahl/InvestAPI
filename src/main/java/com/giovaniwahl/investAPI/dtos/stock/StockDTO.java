package com.giovaniwahl.investAPI.dtos.stock;

import com.giovaniwahl.investAPI.dtos.asset.AssetDTO;
import com.giovaniwahl.investAPI.dtos.user.UserDTO;
import com.giovaniwahl.investAPI.entities.Stock;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class StockDTO {

    private UUID id;
    @NotBlank(message = "Required field.")
    private String nome;
    private UserDTO client;
    private Instant creationDate;
    @NotEmpty(message = "Must contain at least one asset!")
    private Set<AssetDTO> assets = new HashSet<>();

    public StockDTO(UUID id, String nome, UserDTO client, Instant creationDate) {
        this.id = id;
        this.nome = nome;
        this.client = client;
        this.creationDate = creationDate;
    }
    public StockDTO(Stock entity) {
        id = entity.getId();
        nome = entity.getNome();
        client = new UserDTO(entity.getClient());
        creationDate = entity.getCreationDate();
        entity.getAssets().forEach(asset -> this.assets.add(new AssetDTO(asset)));
    }

    public UUID getId() {return id;}
    public void setId(UUID id) {this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public UserDTO getClient() {return client;}

    public Instant getCreationDate() {return creationDate;}
    public void setCreationDate(Instant creationDate) {this.creationDate = creationDate;}

    public Set<AssetDTO> getAssets() {return assets;}
}
