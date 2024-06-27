package lab3.prob2;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private final List<Apartment> apartments;
    private final double maintenanceCost;

    public Building(double maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
        apartments = new ArrayList<>();
    }

    public Building(List<Apartment> apartments, double maintenanceCost) {
        this.apartments = apartments;
        this.maintenanceCost = maintenanceCost;
    }

    public void addApartment(Apartment apartment) {
        apartments.add(apartment);
    }

    public double calculateProfit() {
        double grossProfit = 0.0;
        for (Apartment apartment : apartments) {
            grossProfit += apartment.getRentPrice();
        }
        return grossProfit - maintenanceCost;
    }
}
