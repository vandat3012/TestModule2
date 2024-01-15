package model;

import java.io.Serializable;

public class Product implements Serializable, Comparable<Product> {
    private static final long filePath = 112l;
    private int id;
    private String name;
    private double price;
    private int number;
    private String description;

    public Product() {
    }

    public Product(int id, String name, double price, int number, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.number = number;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getIntroduction() {
        return description;
    }

    public void setIntroduction(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        return (int) (this.price - o.price);
    }
}
