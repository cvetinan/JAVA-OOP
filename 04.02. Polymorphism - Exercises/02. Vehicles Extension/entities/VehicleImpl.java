package entities;

import interfaces.Vehicle;

public abstract class VehicleImpl implements Vehicle {
    protected double fuelQuantity;
    protected double fuelConsumptionPerKm;
    protected double tankCapacity;

    protected VehicleImpl(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
        this.tankCapacity = tankCapacity;
    }

    protected void setFuelConsumptionPerKm(double index) {
        this.fuelConsumptionPerKm += index;
    }

    protected void setFuelQuantity(double liters) {
        if (liters <= 0) {
            System.out.println("Fuel must be a positive number");
            return;
        }
        if ((this.fuelQuantity + liters) > this.tankCapacity) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            this.fuelQuantity += liters;
        }
    }
}
