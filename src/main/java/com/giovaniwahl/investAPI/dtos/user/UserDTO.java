package com.giovaniwahl.investAPI.dtos.user;

import com.giovaniwahl.investAPI.dtos.stock.StockDTO;
import com.giovaniwahl.investAPI.entities.Stock;
import com.giovaniwahl.investAPI.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class UserDTO {
    private UUID id;
    @NotBlank(message = "Required field.")
    private String name;
    @Email(message = "The email provided is not valid.")
    private String email;
    private Set<StockDTO> stocks = new HashSet<>();

    public UserDTO(UUID id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public UserDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        entity.getStocks().forEach(stock -> this.stocks.add(new StockDTO(stock)));
    }

    public UUID getId() {return id;}
    public void setId(UUID id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public Set<StockDTO> getStocks() {return stocks;}
}
