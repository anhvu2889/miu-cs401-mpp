package lab3.prob2;

import java.util.ArrayList;
import java.util.List;

public class Landlord {
    private final List<Building> buildings;

    public Landlord(List<Building> buildings) {
        this.buildings = buildings;
    }

    public Landlord() {
        buildings = new ArrayList<>();
    }

    public void addBuilding(Building building) {
        buildings.add(building);
    }

    public double calculateProfit() {
        double profit = 0;
        for (Building building : buildings) {
            profit += building.calculateProfit();
        }
        return profit;
    }
}
