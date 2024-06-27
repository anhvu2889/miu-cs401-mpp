package lab3.prob2;

public class Main {

    public static void main(String[] args) {
        Apartment[] apartments1 = {
                new Apartment(600),
                new Apartment(700)};
        Apartment[] apartments2 = {
                new Apartment(500),
                new Apartment(450)
        };
        Apartment[] apartments3 = {
                new Apartment(1100),
                new Apartment(650)};

        Apartment[] apartments4 = {
                new Apartment(6750),
                new Apartment(945)
        };
        Building[] buildings = {
                new Building(400),
                new Building(900),
                new Building(300),
                new Building(775)
        };
        for (Apartment apartment : apartments1) {
            buildings[0].addApartment(apartment);
        }
        for (Apartment apartment : apartments2) {
            buildings[1].addApartment(apartment);
        }
        for (Apartment apartment : apartments3) {
            buildings[2].addApartment(apartment);
        }
        for (Apartment apartment : apartments4) {
            buildings[3].addApartment(apartment);
        }

        Landlord landlord = new Landlord();
        for (Building building : buildings) {
            landlord.addBuilding(building);
        }
        System.out.println(landlord.calculateProfit());
    }

}



