package military.entities;

public class Repair {
    private String partName;
    private int hoursWorked;

    public Repair(String partName, int hoursWorked) {
        this.partName = partName;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || obj.getClass()!= this.getClass())
            return false;
        Repair repair = (Repair) obj;
        return (repair.partName.equals(this.partName) && repair.hoursWorked == this.hoursWorked);
    }

    @Override
    public int hashCode() {
        return this.partName.hashCode() * 17 + Integer.hashCode(this.hoursWorked);
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d", this.partName, this.hoursWorked);
    }
}

