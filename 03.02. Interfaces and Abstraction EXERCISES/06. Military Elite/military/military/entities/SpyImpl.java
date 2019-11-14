package military.entities;

import military.interfaces.Spy;

public class SpyImpl extends SoldierImpl implements Spy {
    private Integer codeNumber;

    public SpyImpl(int id, String firstName, String lastName, Integer codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public Integer getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(super.toString());
        output.append(System.lineSeparator())
                .append(String.format("Code Number: %d", this.codeNumber));
        return output.toString();
    }
}
