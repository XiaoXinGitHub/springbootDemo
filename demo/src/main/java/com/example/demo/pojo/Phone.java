package com.example.demo.pojo;

import java.io.Serializable;

public class Phone implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;

    private String name;

    private Double originalPrice;

    private Double sellingPrice;

    private String description;

    private String storeName;

    private String storeType;

    private String color;

    private String vsesion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType == null ? null : storeType.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getVsesion() {
        return vsesion;
    }

    public void setVsesion(String vsesion) {
        this.vsesion = vsesion == null ? null : vsesion.trim();
    }
    
}