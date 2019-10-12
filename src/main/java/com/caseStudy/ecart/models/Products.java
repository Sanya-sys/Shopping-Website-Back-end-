package com.caseStudy.ecart.models;

import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Entity
@Table(name="productInfo")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="productid")
    private int productid;
    @Column(name = "pname")
    private String productName;
    @Column(name = "pprice")
    private int productPrice;

    @Column(name = "image")
    private String image;
    @Column(name = "category")
    private String category;

    @Column(name = "heading")
    private String heading;

    @Column(name = "description")
    private String description;
    @Column(name="active")
private int active;

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
