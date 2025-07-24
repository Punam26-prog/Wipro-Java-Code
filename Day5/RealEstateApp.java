package DayFive;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Consumer;

// Program:Lambda Expression in Real Estate

class RealEstateProperty {
    private String address;
    private double price;
    private int bedrooms;

    public RealEstateProperty(String addr, double price, int beds) {
        this.address = addr;
        this.price = price;
        this.bedrooms = beds;
    }

    public String getAddress() {
        return address;
    }

    public double getPrice() {
        return price;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    @Override
    public String toString() {
        return String.format("Property[address='%s', price=%.2f, bedrooms=%d]",
                address, price, bedrooms);
    }
}


public class RealEstateApp {
    static List<RealEstateProperty> properties = new ArrayList<>();

    public static void main(String[] args) {
        properties.add(new RealEstateProperty("123 Main St", 250_000, 3));
        properties.add(new RealEstateProperty("456 Oak Ave", 150_000, 2));
        properties.add(new RealEstateProperty("789 Pine Rd", 500_000, 4));
        properties.add(new RealEstateProperty("321 Cedar Ln", 200_000, 3));

        
        filterAndAct(p -> p.getPrice() < 300_000,
                p -> System.out.println("Affordable: " + p));

        System.out.println();

        
        filterAndAct(p -> p.getBedrooms() == 3,
                p -> System.out.println("Schedule showing: " + p));
    }

    static void filterAndAct(Predicate<RealEstateProperty> tester, Consumer<RealEstateProperty> action) {
        for (RealEstateProperty p : properties) {
            if (tester.test(p)) {
                action.accept(p);
            }
        }
    }
}
