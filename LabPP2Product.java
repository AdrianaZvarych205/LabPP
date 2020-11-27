package com.butterfly.product;

import java.util.Date;

public class Product {

    private int id;
    private String naming;
    private String manufacturer;
    private double price;
    private Date expirationPeriod;
    private int quantity;


    public Product(int id, String naming, String manufacturer, double price, Date expirationPeriod, int quantity) {
        this.setId(id);
        this.setNaming(naming);
        this.setManufacturer(manufacturer);
        this.setPrice(price);
        this.setExpirationPeriod(expirationPeriod);
        this.setQuantity(quantity);
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", naming='" + naming + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", expirationPeriod=" + expirationPeriod.toString() +
                ", quantity=" + quantity +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaming() {
        return naming;
    }

    public void setNaming(String naming) {
        this.naming = naming;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getExpirationPeriod() {
        return expirationPeriod;
    }

    public void setExpirationPeriod(Date expirationPeriod) {
        this.expirationPeriod = expirationPeriod;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
