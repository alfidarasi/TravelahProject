package app;

import data.DataStore;
import manager.ReservationManager;
import model.FlightItem;
import model.HotelItem;
import util.MainUtil;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Travelah {

    private static final Scanner sc = new Scanner(System.in);
    private static final ReservationManager rm = new ReservationManager();

    public static void main(String[] args) {
        DataStore.loadData();
        showHomeScreen();
    }

    // ======================================================
    // SEARCH FLIGHT + BOOK
    // ======================================================
    public static void searchFlight() {

        System.out.println("\n=== CARI PENERBANGAN ===");

        System.out.print("Asal: ");
        String origin = sc.nextLine();

        System.out.print("Tujuan: ");
        String destination = sc.nextLine();

        System.out.print("Tanggal (YYYY-MM-DD): ");
        String date = sc.nextLine();

        System.out.print("Jumlah penumpang    : ");
        int seatsNeeded = safeInt();

        ArrayList<FlightItem> results = DataStore.getFlights().stream()
                .filter(f -> f.getOrigin().equalsIgnoreCase(origin))
                .filter(f -> f.getDestination().equalsIgnoreCase(destination))
                .filter(f -> f.getDate().equals(date))
                .filter(f -> f.getAvailableSeats() >= seatsNeeded)
                .collect(Collectors.toCollection(ArrayList::new));

        if (results.isEmpty()) {
            System.out.println("Tidak ada penerbangan yang tersedia.");
            pressEnter();
            return;
        }

        System.out.println("\n=== HASIL PENCARIAN ===");
        for (int i = 0; i < results.size(); i++) {
            System.out.println((i + 1) + ". " + results.get(i));
        }

        System.out.print("Pilih nomor (0 untuk batal): ");
        int ch = safeInt();

        if (ch == 0) return;
        if (ch < 1 || ch > results.size()) {
            System.out.println("Pilihan tidak valid.");
            pressEnter();
            return;
        }

        FlightItem f = results.get(ch - 1);

        System.out.print("Nama pemesan: ");
        String name = sc.nextLine();

        System.out.print("Jumlah kursi: ");
        int seats = safeInt();

        rm.bookFlight(f, name, seats);

        pressEnter();
    }

    // ======================================================
    // SEARCH HOTEL + BOOK
    // ======================================================
    public static void searchHotel() {

        System.out.println("\n=== CARI HOTEL ===");

        System.out.print("Lokasi: ");
        String location = sc.nextLine();

        System.out.print("Tanggal check-in (YYYY-MM-DD): ");
        String checkIn = sc.nextLine();

        System.out.print("Tanggal check-out (YYYY-MM-DD): ");
        String checkOut = sc.nextLine();

        System.out.print("Jumlah tamu: ");
        int guests = safeInt();

        ArrayList<HotelItem> results = DataStore.getHotels().stream()
                .filter(h -> h.getLocation().equalsIgnoreCase(location))
                .filter(h -> h.getCheckInDate().equals(checkIn))
                .filter(h -> h.getCheckOutDate().equals(checkOut))
                .filter(h -> h.getMaxGuests() >= guests)
                .collect(Collectors.toCollection(ArrayList::new));

        if (results.isEmpty()) {
            System.out.println("Tidak ada hotel yang tersedia.");
            pressEnter();
            return;
        }

        System.out.println("\n=== HASIL PENCARIAN ===");
        for (int i = 0; i < results.size(); i++) {
            System.out.println((i + 1) + ". " + results.get(i));
        }

        System.out.print("Pilih nomor hotel (0 untuk batal): ");
        int ch = safeInt();

        if (ch == 0) return;
        if (ch < 1 || ch > results.size()) {
            System.out.println("Pilihan tidak valid.");
            pressEnter();
            return;
        }

        HotelItem h = results.get(ch - 1);

        System.out.print("Nama pemesan: ");
        String name = sc.nextLine();

        System.out.print("Jumlah tamu: ");
        int g = safeInt();

        rm.bookHotel(h, name, g);

        pressEnter();
    }

    // ======================================================
    // CANCEL
    // ======================================================
    public static void cancelReservation() {
        System.out.println("\n=== BATALKAN RESERVASI ===");
        System.out.print("Nomor konfirmasi: ");

        double conf = safeDouble();
        rm.cancel(conf);

        pressEnter();
    }

    // ======================================================
    // VIEW RESERVATIONS
    // ======================================================
    public static void showReservations() {
        ReservationManager.viewReservations();
        pressEnter();
    }

    // ======================================================
    // EXIT APP
    // ======================================================
    private static void exit() {
        System.out.println("Terima kasih sudah memakai Travelah!");
        sc.close();
        System.exit(0);
    }

    // ======================================================
    // MENU
    // ======================================================
    public static void showHomeScreen() {

        MainUtil util = new MainUtil();

        while (true) {
            util.showTitle("Travelah");

            System.out.println("\n1. Cari & Pesan Penerbangan");
            System.out.println("2. Cari & Pesan Hotel");
            System.out.println("3. Lihat Reservasi");
            System.out.println("4. Batalkan Reservasi");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");

            int ch = safeInt();

            switch (ch) {
                case 1: searchFlight(); break;
                case 2: searchHotel(); break;
                case 3: showReservations(); break;
                case 4: cancelReservation(); break;
                case 0: exit(); break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    pressEnter();
            }
        }
    }

    // ======================================================
    // SAFE INPUT
    // ======================================================
    private static int safeInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.print("Masukkan angka: ");
            }
        }
    }

    private static double safeDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.print("Masukkan angka: ");
            }
        }
    }

    // ======================================================
    // PRESS ENTER TO CONTINUE
    // ======================================================
    private static void pressEnter() {
        System.out.print("\nTekan ENTER untuk kembali ke menu...");
        sc.nextLine();
    }
}
