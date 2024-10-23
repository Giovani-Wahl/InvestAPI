package com.giovaniwahl.investAPI.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
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
    private String logoUrl; // URL do logo  "logourl"
    private BigDecimal equityValue; // Valor Patrimonial P/Cota
    private BigDecimal pvp; // P/VP calculado com base no preço medio dividido pelo patrimonial
    private BigDecimal dividendYield; // calculado com base nos proventos dos ultimos 12 meses
    private BigDecimal dividendMonthly; // dividendo referente o meses
    private BigDecimal jcpMonthly; // JCP referente o meses
    private BigDecimal profitabilityMonthly; // rentabilidade do mes calculada dividindo o valor do dividendo mensal pelo valor total investido no fundo
    private BigDecimal profitabilityAverage; // rentabilidade media dos ultimos 12 meses

    public Product() {}

    public Product(UUID id, Long cnpj, Category category, String symbol, String currency, String shortName,
                   String longName, String isinCode, Long regularMarketPrice, String logoUrl, BigDecimal equityValue,
                   BigDecimal pvp, BigDecimal dividendYield, BigDecimal dividendMonthly, BigDecimal jcpMonthly,
                   BigDecimal profitabilityMonthly, BigDecimal profitabilityAverage) {
        this.id = id;
        this.cnpj = cnpj;
        this.category = category;
        this.symbol = symbol;
        this.currency = currency;
        this.shortName = shortName;
        this.longName = longName;
        this.isinCode = isinCode;
        this.regularMarketPrice = regularMarketPrice;
        this.logoUrl = logoUrl;
        this.equityValue = equityValue;
        this.pvp = pvp;
        this.dividendYield = dividendYield;
        this.dividendMonthly = dividendMonthly;
        this.jcpMonthly = jcpMonthly;
        this.profitabilityMonthly = profitabilityMonthly;
        this.profitabilityAverage = profitabilityAverage;
    }

    public UUID getId() {return id;}
    public void setId(UUID id) {this.id = id;}

    public Long getCnpj() {return cnpj;}
    public void setCnpj(Long cnpj) {this.cnpj = cnpj;}

    public Category getCategory() {return category;}
    public void setCategory(Category category) {this.category = category;}

    public String getSymbol() {return symbol;}
    public void setSymbol(String symbol) {this.symbol = symbol;}

    public String getCurrency() {return currency;}
    public void setCurrency(String currency) {this.currency = currency;}

    public String getShortName() {return shortName;}
    public void setShortName(String shortName) {this.shortName = shortName;}

    public String getLongName() {return longName;}
    public void setLongName(String longName) {this.longName = longName;}

    public String getIsinCode() {return isinCode;}
    public void setIsinCode(String isinCode) {this.isinCode = isinCode;}

    public Long getRegularMarketPrice() {return regularMarketPrice;}
    public void setRegularMarketPrice(Long regularMarketPrice) {this.regularMarketPrice = regularMarketPrice;}

    public String getLogoUrl() {return logoUrl;}
    public void setLogoUrl(String logoUrl) {this.logoUrl = logoUrl;}

    public BigDecimal getEquityValue() {return equityValue;}
    public void setEquityValue(BigDecimal equityValue) {this.equityValue = equityValue;}

    public BigDecimal getPvp() {return pvp;}
    public void setPvp(BigDecimal pvp) {this.pvp = pvp;}

    public BigDecimal getDividendYield() {return dividendYield;}
    public void setDividendYield(BigDecimal dividendYield) {this.dividendYield = dividendYield;}

    public BigDecimal getDividendMonthly() {return dividendMonthly;}
    public void setDividendMonthly(BigDecimal dividendMonthly) {this.dividendMonthly = dividendMonthly;}

    public BigDecimal getJcpMonthly() {return jcpMonthly;}
    public void setJcpMonthly(BigDecimal jcpMonthly) {this.jcpMonthly = jcpMonthly;}

    public BigDecimal getProfitabilityMonthly() {return profitabilityMonthly;}
    public void setProfitabilityMonthly(BigDecimal profitabilityMonthly) {this.profitabilityMonthly = profitabilityMonthly;}

    public BigDecimal getProfitabilityAverage() {return profitabilityAverage;}
    public void setProfitabilityAverage(BigDecimal profitabilityAverage) {this.profitabilityAverage = profitabilityAverage;}

    public Set<Asset> getAssets() {return assets;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
