package ru.netology.product;
public class Smartphone extends Product {

    protected String generator;

    public Smartphone(int id, String name, int price, String generator) {
        super(id, name, price);
        this.generator = generator;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }
}
