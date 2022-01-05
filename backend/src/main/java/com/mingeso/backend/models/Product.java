package com.mingeso.backend.models;
import java.sql.Date;

public class Product {
    private Long code;
    private String name;
    private Date expiration_date;
    private Boolean category;
    private double price;
    private Boolean delete;

    public Product(Long code, String name, Date expiration_date, Boolean category, double price, Boolean delete) {
        this.code = code;
        this.name = name;
        this.expiration_date = expiration_date;
        this.category = category;
        this.price = price;
        this.delete = delete;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    public Boolean getCategory() {
        return category;
    }

    public void setCategory(Boolean category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }
}



