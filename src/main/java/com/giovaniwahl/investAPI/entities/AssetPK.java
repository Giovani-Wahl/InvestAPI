package com.giovaniwahl.investAPI.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class AssetPK {
    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public AssetPK() {}

    public Stock getStock() {return stock;}
    public void setStock(Stock stock) {this.stock = stock;}

    public Product getProduct() {return product;}
    public void setProduct(Product product) {this.product = product;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssetPK assetPK = (AssetPK) o;
        return Objects.equals(stock, assetPK.stock) && Objects.equals(product, assetPK.product);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(stock);
        result = 31 * result + Objects.hashCode(product);
        return result;
    }
}
