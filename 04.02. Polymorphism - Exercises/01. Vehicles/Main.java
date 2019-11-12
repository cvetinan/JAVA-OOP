import entities.Car;
import entities.Truck;
import interfaces.Vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static Vehicle car;
    public static Vehicle truck;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carInfo = reader.readLine().split("\\s+");
        car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]));
        String[] truckInfo = reader.readLine().split("\\s+");
        truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]));

        int numberOfCommands = Integer.parseInt(reader.readLine());
        while (numberOfCommands-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            switch (tokens[0]) {
                case "Drive":
                    drive(tokens[1], Double.parseDouble(tokens[2]));
                    break;
                case "Refuel":
                    refuel(tokens[1], Double.parseDouble(tokens[2]));
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);
    }

    private static void refuel(String vehicleType, double liters) {
        switch (vehicleType){
            case "Car":
                car.refuel(liters);
                break;
            case "Truck":
                truck.refuel(liters);
                break;
        }
    }

    private static void drive(String vehicleType, double distance) {
        switch (vehicleType){
            case "Car":
                car.drive(distance);
                break;
            case "Truck":
                truck.drive(distance);
                break;
        }
    }
}
