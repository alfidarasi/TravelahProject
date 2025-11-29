package model;

public class FlightItem {

    private String id;
    private String name;
    private String origin;
    private String destination;
    private String date;          // format: YYYY-MM-DD
    private double price;
    private int availableSeats;

    public FlightItem(String id,
                      String name,
                      String origin,
                      String destination,
                      String date,
                      double price,
                      int availableSeats) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.price = price;
        this.availableSeats = availableSeats;
    }

    // getters & setters (enkapsulasi)
    public String getId() { return id; }
    public String getName() { return name; }
    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public String getDate() { return date; }
    public double getPrice() { return price; }
    public int getAvailableSeats() { return availableSeats; }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | "
                + origin + " -> " + destination
                + " | " + date
                + " | Rp" + price
                + " | Kursi tersedia: " + availableSeats;
    }
}
