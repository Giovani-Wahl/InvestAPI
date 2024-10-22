package com.giovaniwahl.investAPI.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Long cnpj;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "id.product")
    private Set<Asset> assets = new HashSet<>();

    private String symbol; // Código de negociação (ticker) "symbol"
    private String currency; // Moeda (ex: "BRL")   "currency"
    private String shortName; // Nome curto da empresa  "shortName"
    private String longName;  // Nome longo da empresa  "longName"
    private String isinCode;  // Código ISIN  "isinCode"
    private Long regularMarketPrice; // Preço atual  "regularMarketPrice"
    private String logourl; // URL do logo  "logourl"
    private BigDecimal equityValue; // Valor Patrimonial P/Cota
    private BigDecimal pvp; // P/VP calculado com base no preço medio dividido pelo patrimonial
    private BigDecimal dividendYield; // calculado com base nos proventos dos ultimos 12 meses
    private BigDecimal dividendMonthly; // dividendo referente o meses
    private BigDecimal jcpMonthly; // JCP referente o meses
    private BigDecimal profitabilityMonthly; // rentabilidade do mes calculada dividindo o valor do dividendo mensal pelo valor total investido no fundo
    private BigDecimal profitabilityAverage; // rentabilidade media dos ultimos 12 meses
}
