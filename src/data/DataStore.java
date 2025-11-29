package data;

import model.FlightItem;
import model.HotelItem;

import java.util.ArrayList;
import java.util.List;

public class DataStore {

    private static List<FlightItem> flights = new ArrayList<>();
    private static List<HotelItem> hotels = new ArrayList<>();

    public static void loadData() {

        if (!flights.isEmpty()) return; // biar nggak dobel kalau main dipanggil lagi

        flights.add(new FlightItem(
                "F001", "Sriwijaya 230",
                "Jakarta", "Bali",
                "2025-11-28",
                930000, 30));

        flights.add(new FlightItem(
                "F002", "AirAsia 340",
                "Jakarta", "Singapore",
                "2025-11-29",
                1700000, 40));

        flights.add(new FlightItem(
                "F003", "Batik Air 110",
                "Surabaya", "Bali",
                "2025-12-01",
                600000, 25));

        hotels.add(new HotelItem(
                "H001", "Hotel Neo+",
                "Jakarta",
                "2025-11-27", "2025-11-28",
                400000, 50));

        hotels.add(new HotelItem(
                "H002", "Ritz Carlton",
                "Bali",
                "2025-12-01", "2025-12-02",
                1200000, 70));

        hotels.add(new HotelItem(
                "H003", "Marina Bay Sands",
                "Singapore",
                "2025-11-29", "2025-11-30",
                12300000, 60));
    }

    public static List<FlightItem> getFlights() { return flights; }
    public static List<HotelItem> getHotels() { return hotels; }
}
