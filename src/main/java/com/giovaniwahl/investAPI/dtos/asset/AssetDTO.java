package com.giovaniwahl.investAPI.dtos.asset;

import com.giovaniwahl.investAPI.entities.Asset;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class AssetDTO {

    private UUID productId;
    private String ticker;
    private Long amount;
    private BigDecimal averagePrice;
    private BigDecimal totalPrice;
    private BigDecimal totalInvest;
    private BigDecimal pvp;
    private BigDecimal dividendYield;
    private BigDecimal dividendMonthly;
    private BigDecimal jcpMonthly;
    private BigDecimal totalDividend;
    private BigDecimal profitabilityMonthly;
    private BigDecimal profitabilityAverage;
    private BigDecimal assetValue;
    private Instant inclusionDate;
    private Instant buyDate;
    private Long quantityBuy;
    private BigDecimal purchasePrice;
    private Instant soldDate;
    private Long quantitySold;
    private BigDecimal salePrice;

    public AssetDTO(UUID productId,String ticker, Long amount, BigDecimal averagePrice, BigDecimal totalPrice,
                    BigDecimal totalInvest, BigDecimal pvp, BigDecimal dividendYield, BigDecimal dividendMonthly,
                    BigDecimal jcpMonthly, BigDecimal totalDividend, BigDecimal profitabilityMonthly,
                    BigDecimal profitabilityAverage, BigDecimal assetValue, Instant inclusionDate, Instant buyDate,
                    Long quantityBuy, BigDecimal purchasePrice, Instant soldDate, Long quantitySold,
                    BigDecimal salePrice) {
        this.productId = productId;
        this.ticker = ticker;
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
    public AssetDTO(Asset entity) {
        productId = entity.getProduct().getId();
        ticker = entity.getProduct().getSymbol();
        amount = entity.getAmount();
        averagePrice = entity.getAveragePrice();
        totalPrice = entity.getTotalPrice();
        totalInvest = entity.getTotalInvest();
        pvp = entity.getPvp();
        dividendYield = entity.getDividendYield();
        dividendMonthly = entity.getDividendMonthly();
        jcpMonthly = entity.getJcpMonthly();
        totalDividend = entity.getTotalDividend();
        profitabilityMonthly = entity.getProfitabilityMonthly();
        profitabilityAverage = entity.getProfitabilityAverage();
        assetValue = entity.getAssetValue();
        inclusionDate = entity.getInclusionDate();
        buyDate = entity.getBuyDate();
        quantityBuy = entity.getQuantityBuy();
        purchasePrice = entity.getPurchasePrice();
        soldDate = entity.getSoldDate();
        quantitySold = entity.getQuantitySold();
        salePrice = entity.getSalePrice();
    }

    public UUID getProductId() {return productId;}
    public void setProductId(UUID productId) {this.productId = productId;}

    public String getTicker() {return ticker;}
    public void setTicker(String ticker) {this.ticker = ticker;}

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
}
