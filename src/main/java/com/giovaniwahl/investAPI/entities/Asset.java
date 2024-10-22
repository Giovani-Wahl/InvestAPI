package com.giovaniwahl.investAPI.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "tb_asset")
public class Asset {
    @EmbeddedId
    private AssetPK id = new AssetPK();

    private Long amount; // Quantidade de cotas
    private BigDecimal averagePrice; // Preço médio
    private BigDecimal totalPrice; // Preço total
    private BigDecimal totalInvest; // total investido

    private BigDecimal pvp; // P/VP calculado com base no preço medio dividido pelo patrimonial
    private BigDecimal dividendYield; // calculado com base nos proventos dos ultimos 12 meses
    private BigDecimal dividendMonthly; // dividendo referente o meses
    private BigDecimal jcpMonthly; // JCP referente o meses
    private BigDecimal totalDividend; // soma total de dividendos recebidos desde a data que aquisição + jcp
    private BigDecimal profitabilityMonthly; // rentabilidade do mes calculada dividindo o valor do dividendo mensal pelo valor total investido no fundo
    private BigDecimal profitabilityAverage; // rentabilidade media dos ultimos 12 meses
    private BigDecimal assetValue; // preço medio descontado do dividendo recebidos

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant inclusionDate; // Data da 1° compra

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant buyDate; // Data da ultima compra
    private Long quantityBuy; // Quantidade da ultima compra
    private BigDecimal purchasePrice; // Preço de compra

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant soldDate; // Data da ultima venda
    private Long quantitySold; // Quantidade da ultima venda
    private BigDecimal salePrice; // Preço de venda
}
