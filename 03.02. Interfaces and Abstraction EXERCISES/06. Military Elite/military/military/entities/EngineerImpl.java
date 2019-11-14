package military.entities;

import military.enumaration.Corp;
import military.interfaces.Engineer;

import java.util.*;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private Set<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corp corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new LinkedHashSet<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return this.repairs;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(super.toString());
        output.append(System.lineSeparator()).append("Repairs:");
        for (Repair repair : this.repairs) {
            output
                    .append(System.lineSeparator())
                    .append("  ")
                    .append(repair.toString());
        }
        return output.toString();
    }
}
