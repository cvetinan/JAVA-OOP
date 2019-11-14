package entities;

import java.text.DecimalFormat;

public class Bus extends VehicleImpl {


    public Bus(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKm, tankCapacity);
    }

    @Override
    public void drive(double distance) {
        double currentConsumptionPerKm = this.fuelConsumptionPerKm + 1.4;
        calculateTotalConsumption(distance, currentConsumptionPerKm);
    }

    public void driveEmpty(double distance) {
        calculateTotalConsumption(distance, this.fuelConsumptionPerKm);
    }

    @Override
    public void refuel(double liters) {
        setFuelQuantity(liters);
    }

    private void calculateTotalConsumption(double distance, double consumption) {
        double totalConsumption = consumption * distance;
        if (totalConsumption <= this.fuelQuantity) {
            this.fuelQuantity -= totalConsumption;
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            System.out.println("Bus travelled " + decimalFormat.format(distance) + " km");
        } else {
            System.out.println("Bus needs refueling");
        }
    }

    @Override
    public String toString() {
        return String.format("Bus: %.2f", this.fuelQuantity);
    }
}
