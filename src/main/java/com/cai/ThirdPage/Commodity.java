package com.cai.ThirdPage;

public class Commodity {
	private String title;
    private String id;
    private String price;
    private String picture;
    private String sku;
    private String url;
    private String brand;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) { this.sku = sku; }

    public String getPicture() { return picture; }

    public void setPicture(String pic) {
        this.picture = picture;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() { return brand; }

    public void setBrand(String brand) { this.brand = brand; }

    public Commodity(String id, String title, String price, String brand, String url, String picture, String sku) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.brand = brand;
        this.url = url;
        this.picture = picture;
        this.sku = sku;

    }


}
