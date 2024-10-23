package com.giovaniwahl.investAPI.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

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

    public Asset() {}

    public Asset(Stock stock,Product product, Long amount, BigDecimal averagePrice, BigDecimal totalPrice,
                 BigDecimal totalInvest, BigDecimal pvp, BigDecimal dividendYield, BigDecimal dividendMonthly,
                 BigDecimal jcpMonthly, BigDecimal totalDividend, BigDecimal profitabilityMonthly,
                 BigDecimal profitabilityAverage, BigDecimal assetValue, Instant inclusionDate, Instant buyDate,
                 Long quantityBuy, BigDecimal purchasePrice, Instant soldDate,Long quantitySold,BigDecimal salePrice) {
        id.setStock(stock);
        id.setProduct(product);
        this.amount = amount;
        this.averagePrice = averagePrice;
        this.totalPrice = totalPrice;
        this.totalInvest = totalInvest;
        this.pvp = pvp;
        this.dividendYield = dividendYield;
        this.dividendMonthly = dividendMonthly;
        this.jcpMonthly = jcpMonthly;
        this.totalDividend = totalDividend;
        this.profitabilityMonthly = profitabilityMonthly;
        this.profitabilityAverage = profitabilityAverage;
        this.assetValue = assetValue;
        this.inclusionDate = inclusionDate;
        this.buyDate = buyDate;
        this.quantityBuy = quantityBuy;
        this.purchasePrice = purchasePrice;
        this.soldDate = soldDate;
        this.quantitySold = quantitySold;
        this.salePrice = salePrice;
    }

    public Stock getStock(){return id.getStock();}
    public void setStock(Stock stock){id.setStock(stock);}

    public Product getProduct(){return id.getProduct();}
    public void setProduct(Product product){id.setProduct(product);}

    public Long getAmount() {return amount;}
    public void setAmount(Long amount) {this.amount = amount;}

    public BigDecimal getAveragePrice() {return averagePrice;}
    public void setAveragePrice(BigDecimal averagePrice) {this.averagePrice = averagePrice;}

    public BigDecimal getTotalPrice() {return totalPrice;}
    public void setTotalPrice(BigDecimal totalPrice) {this.totalPrice = totalPrice;}

    public BigDecimal getTotalInvest() {return totalInvest;}
    public void setTotalInvest(BigDecimal totalInvest) {this.totalInvest = totalInvest;}

    public BigDecimal getPvp() {return pvp;}
    public void setPvp(BigDecimal pvp) {this.pvp = pvp;}

    public BigDecimal getDividendYield() {return dividendYield;}
    public void setDividendYield(BigDecimal dividendYield) {this.dividendYield = dividendYield;}

    public BigDecimal getDividendMonthly() {return dividendMonthly;}
    public void setDividendMonthly(BigDecimal dividendMonthly) {this.dividendMonthly = dividendMonthly;}

    public BigDecimal getJcpMonthly() {return jcpMonthly;}
    public void setJcpMonthly(BigDecimal jcpMonthly) {this.jcpMonthly = jcpMonthly;}

    public BigDecimal getTotalDividend() {return totalDividend;}
    public void setTotalDividend(BigDecimal totalDividend) {this.totalDividend = totalDividend;}

    public BigDecimal getProfitabilityMonthly() {return profitabilityMonthly;}
    public void setProfitabilityMonthly(BigDecimal profitabilityMonthly) {this.profitabilityMonthly = profitabilityMonthly;}

    public BigDecimal getProfitabilityAverage() {return profitabilityAverage;}
    public void setProfitabilityAverage(BigDecimal profitabilityAverage) {this.profitabilityAverage = profitabilityAverage;}

    public BigDecimal getAssetValue() {return assetValue;}
    public void setAssetValue(BigDecimal assetValue) {this.assetValue = assetValue;}

    public Instant getInclusionDate() {return inclusionDate;}
    public void setInclusionDate(Instant inclusionDate) {this.inclusionDate = inclusionDate;}

    public Instant getBuyDate() {return buyDate;}
    public void setBuyDate(Instant buyDate) {this.buyDate = buyDate;}

    public Long getQuantityBuy() {return quantityBuy;}
    public void setQuantityBuy(Long quantityBuy) {this.quantityBuy = quantityBuy;}

    public BigDecimal getPurchasePrice() {return purchasePrice;}
    public void setPurchasePrice(BigDecimal purchasePrice) {this.purchasePrice = purchasePrice;}

    public Instant getSoldDate() {return soldDate;}
    public void setSoldDate(Instant soldDate) {this.soldDate = soldDate;}

    public Long getQuantitySold() {return quantitySold;}
    public void setQuantitySold(Long quantitySold) {this.quantitySold = quantitySold;}

    public BigDecimal getSalePrice() {return salePrice;}
    public void setSalePrice(BigDecimal salePrice) {this.salePrice = salePrice;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Asset asset = (Asset) o;
        return Objects.equals(id, asset.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
