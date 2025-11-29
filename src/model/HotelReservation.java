package model;

public final class HotelReservation extends Reservation {

    private final HotelItem hotel;
    private int guests;

    public HotelReservation(double confirmationNumber,
                            String customerName,
                            HotelItem hotel,
                            int guests) {
        super(confirmationNumber, customerName);
        this.hotel = hotel;
        this.guests = guests;
    }

    public HotelItem getHotel() { return hotel; }
    public int getGuests() { return guests; }
    public void setGuests(int guests) { this.guests = guests; }

    @Override
    public void display() {
        System.out.println("[Hotel]  #" + getConfirmationNumber()
                + " | " + getCustomerName()
                + " | " + hotel.getName()
                + " | " + hotel.getLocation()
                + " | Tamu: " + guests
                + " | " + hotel.getCheckInDate()
                + " - " + hotel.getCheckOutDate());
    }
}
