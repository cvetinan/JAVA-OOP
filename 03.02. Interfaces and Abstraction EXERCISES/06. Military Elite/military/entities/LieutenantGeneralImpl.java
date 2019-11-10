package military.entities;

import military.interfaces.LeutenantGeneral;
import military.interfaces.Private;

import java.util.Set;
import java.util.TreeSet;

//2do Lieutenant1
public class LieutenantGeneralImpl extends PrivateImpl implements LeutenantGeneral {
    private Set<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new TreeSet<>((first, second) -> second.getId() - first.getId());
    }

    @Override
    public void addPrivate(Private priv) {
        this.privates.add(priv);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(super.toString());
        output.append(System.lineSeparator()).append("Privates:");
        for (Private priv : this.privates) {
            output
                    .append(System.lineSeparator())
                    .append("  ").append(priv.toString());
        }
        return output.toString();
    }
}
