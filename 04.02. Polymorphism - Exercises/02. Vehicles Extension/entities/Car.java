package entities;

import java.text.DecimalFormat;

public class Car extends VehicleImpl {
    public Car(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKm, tankCapacity);
        this.setFuelConsumptionPerKm(0.9);
    }

    @Override
    public void drive(double distance) {
        double totalConsumption = this.fuelConsumptionPerKm * distance;
        if (totalConsumption <= this.fuelQuantity) {
            this.fuelQuantity -= totalConsumption;
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            System.out.println("Car travelled " + decimalFormat.format(distance) + " km");
        } else {
            System.out.println("Car needs refueling");
        }
    }

    @Override
    public void refuel(double liters) {
        this.setFuelQuantity(liters);
    }

    @Override
    public void driveEmpty(double distance) {
        //implement logic if needed
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", this.fuelQuantity);
    }
}
