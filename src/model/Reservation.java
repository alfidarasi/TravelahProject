package model;

public abstract class Reservation {

    private final double confirmationNumber;
    private final String customerName;

    public Reservation(double confirmationNumber, String customerName) {
        this.confirmationNumber = confirmationNumber;
        this.customerName = customerName;
    }

    public double getConfirmationNumber() {
        return confirmationNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public abstract void display();
}
