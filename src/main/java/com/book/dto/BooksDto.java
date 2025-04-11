package com.book.dto;

import java.math.BigDecimal;

public class BooksDto {

    private Long id;
    private String vendorCode;
    private String title;
    private int year;
    private String brand;
    private int stock;
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BooksDto() {
    }

    public BooksDto(Long id, String vendorCode, String title, int year, String brand, int stock, BigDecimal price) {
        this.id = id;
        this.vendorCode = vendorCode;
        this.title = title;
        this.year = year;
        this.brand = brand;
        this.stock = stock;
        this.price = price;
    }

    @Override
    public String toString() {
        return "BooksDto{" +
                "id=" + id +
                ", vendorCode='" + vendorCode + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", brand='" + brand + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }
}
