package model;

public class HotelItem {

    private String id;
    private String name;
    private String location;
    private String checkInDate;   // YYYY-MM-DD (dummy, untuk demo)
    private String checkOutDate;
    private double pricePerNight;
    private int maxGuests;

    public HotelItem(String id,
                     String name,
                     String location,
                     String checkInDate,
                     String checkOutDate,
                     double pricePerNight,
                     int maxGuests) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.pricePerNight = pricePerNight;
        this.maxGuests = maxGuests;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public String getCheckInDate() { return checkInDate; }
    public String getCheckOutDate() { return checkOutDate; }
    public double getPricePerNight() { return pricePerNight; }
    public int getMaxGuests() { return maxGuests; }

    @Override
    public String toString() {
        return id + " | " + name
                + " | " + location
                + " | " + checkInDate + " - " + checkOutDate
                + " | Rp" + pricePerNight + "/malam"
                + " | Kapasitas: " + maxGuests + " tamu";
    }
}
