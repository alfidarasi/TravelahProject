package model;

public abstract class TravelItem {

    protected String id;
    protected String name;
    protected double price;

    public TravelItem(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}


