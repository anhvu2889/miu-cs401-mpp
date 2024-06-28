package lab3.prob4;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    public static double computeTotalRent(Property[] properties) {
        double totalRent = 0;
        for (Property property : properties) {
            totalRent += property.computeRent();
        }
        return totalRent;
    }

    public static List<Property> getPropertyByCity(Property[] properties, String city) {
        List<Property> result = new ArrayList<>();
        for (Property property : properties) {
            if (property.getAddress() != null &&
                    property.getAddress().getCity() != null &&
                    property.getAddress().getCity().equals(city)) {
                result.add(property);
            }
        }
        return result;
    }
}
