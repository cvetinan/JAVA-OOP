package military.entities;

import military.enumaration.Corp;
import military.interfaces.SpecialisedSoldier;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private Corp corps;

    protected SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corp corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    @Override
    public String getCorps() {
        return this.corps.toString();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(super.toString());
        output
                .append(System.lineSeparator())
                .append(String.format("Corps: %s", this.getCorps()));
        return output.toString();
    }
}
