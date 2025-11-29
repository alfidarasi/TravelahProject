package manager;

import model.FlightItem;
import model.FlightReservation;
import model.HotelItem;
import model.HotelReservation;
import model.Reservation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ReservationManager {

    // daftar semua reservasi (flight + hotel)
    private static final List<Reservation> reservations = new ArrayList<>();
    private static final Random random = new Random();

    // generate nomor konfirmasi 6 digit
    private static double generateConfirmationNumber() {
        int n = 100000 + random.nextInt(900000); // 6 digit
        return n;
    }

    // ================== BOOK FLIGHT ==================

    public void bookFlight(FlightItem flight, String customerName, int seats) {
        double conf = generateConfirmationNumber();
        FlightReservation res = new FlightReservation(conf, customerName, flight, seats);
        reservations.add(res);

        // optional: kurangi kursi tersedia
        flight.setAvailableSeats(flight.getAvailableSeats() - seats);

        System.out.println("Flight berhasil dipesan. Nomor konfirmasi: " + conf);
    }

    // ================== BOOK HOTEL ==================

    public void bookHotel(HotelItem hotel, String customerName, int guests) {
        double conf = generateConfirmationNumber();
        HotelReservation res = new HotelReservation(conf, customerName, hotel, guests);
        reservations.add(res);

        System.out.println("Hotel berhasil dipesan. Nomor konfirmasi: " + conf);
    }

    // ================== CANCEL RESERVATION ==================

    public void cancel(double confirmationNumber) {
        Iterator<Reservation> it = reservations.iterator();

        while (it.hasNext()) {
            Reservation res = it.next();

            if (res.getConfirmationNumber() == confirmationNumber) {

                // versi Java lama: instanceof + casting manual
                if (res instanceof FlightReservation) {
                    FlightReservation fr = (FlightReservation) res;
                    System.out.println("Membatalkan flight "
                            + fr.getFlight().getId()
                            + " untuk " + fr.getCustomerName());

                    // balikin kursi
                    fr.getFlight().setAvailableSeats(
                            fr.getFlight().getAvailableSeats() + fr.getSeats()
                    );

                } else if (res instanceof HotelReservation) {
                    HotelReservation hr = (HotelReservation) res;
                    System.out.println("Membatalkan hotel "
                            + hr.getHotel().getName()
                            + " untuk " + hr.getCustomerName());
                }

                it.remove();
                System.out.println("Reservasi #" + confirmationNumber + " berhasil dibatalkan.");
                return;
            }
        }

        System.out.println("Reservasi dengan nomor konfirmasi tersebut tidak ditemukan.");
    }

    // ================== VIEW RESERVATIONS ==================

    public static void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("Belum ada reservasi.");
            return;
        }

        System.out.println("\n=== DAFTAR RESERVASI ===");
        for (Reservation r : reservations) {
            r.display(); // polymorphism: FlightReservation/HotelReservation
        }
    }
}
