package model;

public final class FlightReservation extends Reservation {

    private final FlightItem flight;
    private int seats;

    public FlightReservation(double confirmationNumber,
                             String customerName,
                             FlightItem flight,
                             int seats) {
        super(confirmationNumber, customerName);
        this.flight = flight;
        this.seats = seats;
    }

    public FlightItem getFlight() { return flight; }
    public int getSeats() { return seats; }
    public void setSeats(int seats) { this.seats = seats; }

    @Override
    public void display() {
        System.out.println("[Flight] #" + getConfirmationNumber()
                + " | " + getCustomerName()
                + " | " + flight.getId() + " "
                + flight.getOrigin() + " -> " + flight.getDestination()
                + " | Tanggal: " + flight.getDate()
                + " | Kursi: " + seats);
    }
}
