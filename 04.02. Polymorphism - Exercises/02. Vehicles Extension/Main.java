import entities.Bus;
import entities.Car;
import entities.Truck;
import interfaces.Vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static Vehicle car;
    public static Vehicle truck;
    public static Vehicle bus;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            String[] vehicleInfo = reader.readLine().split("\\s+");
            String type = vehicleInfo[0];
            double initialFuelQuantity = Double.parseDouble(vehicleInfo[1]);
            double fuelConsumptionPerKm = Double.parseDouble(vehicleInfo[2]);
            double tankCapacity = Double.parseDouble(vehicleInfo[3]);

            switch (type) {
                case "Car":
                    car = new Car(initialFuelQuantity, fuelConsumptionPerKm, tankCapacity);
                    break;
                case "Truck":
                    truck = new Truck(initialFuelQuantity, fuelConsumptionPerKm, tankCapacity);
                    break;
                case "Bus":
                    bus = new Bus(initialFuelQuantity, fuelConsumptionPerKm, tankCapacity);
                    break;
            }
        }

        int numberOfCommands = Integer.parseInt(reader.readLine());
        while (numberOfCommands-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String type = tokens[1];
            double distance = Double.parseDouble(tokens[2]);
            switch (tokens[0]) {
                case "Drive":
                    drive(type, distance);
                    break;
                case "DriveEmpty":
                    driveEmpty(type, distance);
                    break;
                case "Refuel":
                    refuel(tokens[1], Double.parseDouble(tokens[2]));
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }

    private static void refuel(String vehicleType, double liters) {
        switch (vehicleType) {
            case "Car":
                car.refuel(liters);
                break;
            case "Truck":
                truck.refuel(liters);
                break;
            case "Bus":
                bus.refuel(liters);
                break;
        }
    }

    private static void drive(String vehicleType, double distance) {
        switch (vehicleType) {
            case "Car":
                car.drive(distance);
                break;
            case "Truck":
                truck.drive(distance);
                break;
            case "Bus":
                bus.drive(distance);
        }
    }

    private static void driveEmpty(String type, double distance) {
        bus.driveEmpty(distance);
    }
}
