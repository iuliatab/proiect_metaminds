package org.tablet.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String storeName;
    private double price;
    private String url;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    public Long getId() { return id; }
    public void setId(Long id) { this. id = id; }

    public String getStoreName() { return storeName; }
    public void setStoreName(String storeName) { this.storeName = storeName; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
}