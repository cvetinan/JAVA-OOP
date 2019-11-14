package military.entities;

import military.interfaces.Private;

public class PrivateImpl extends SoldierImpl implements Private {
    private double salary;

    public PrivateImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        if (salary > 0) {
            this.salary = salary;
        }
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(super.toString());
        output.append(String.format(" Salary: %.2f", this.getSalary()));
        return output.toString();
    }
}