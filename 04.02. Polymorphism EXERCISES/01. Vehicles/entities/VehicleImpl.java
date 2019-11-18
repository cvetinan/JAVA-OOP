package entities;

import interfaces.Vehicle;

public abstract class VehicleImpl implements Vehicle {
    protected double fuelQuantity;
    protected double fuelConsumptionPerKm;

    protected VehicleImpl(double fuelQuantity, double fuelConsumptionPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
    }

    protected void setFuelConsumptionPerKm(double index) {
        this.fuelConsumptionPerKm += index;
    }

    protected void setFuelQuantity(double liters) {
        this.fuelQuantity += liters;
    }
}
