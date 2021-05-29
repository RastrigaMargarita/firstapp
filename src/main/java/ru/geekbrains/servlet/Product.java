package ru.geekbrains.servlet;

public class Product {
   private int id, cost;
   private String title;

    public Product(int id, int cost, String title) {
        this.id = id;
        this.cost = cost;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", cost=" + cost +
                ", title='" + title + '\'' +
                '}';
    }
}
