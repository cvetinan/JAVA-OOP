package entities;

import java.text.DecimalFormat;

public class Truck extends VehicleImpl {
    public Truck(double fuelQuantity, double fuelConsumptionPerKm) {
        super(fuelQuantity, fuelConsumptionPerKm);
        this.setFuelConsumptionPerKm(1.6);
    }


    @Override
    public void drive(double distance) {
        double totalConsumption = this.fuelConsumptionPerKm * distance;
        if (totalConsumption <= this.fuelQuantity){
            this.fuelQuantity -= totalConsumption;
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            System.out.println("Truck travelled "+ decimalFormat.format(distance) + " km");
        } else {
            System.out.println("Truck needs refueling");
        }
    }

    @Override
    public void refuel(double liters) {
        this.setFuelQuantity(liters * 0.95);
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", this.fuelQuantity);
    }
}
