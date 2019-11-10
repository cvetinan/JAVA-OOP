package military.entities;

import military.enumaration.Corp;
import military.interfaces.Commando;

import java.util.*;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private Set<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corp corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new LinkedHashSet<>();
    }

    public void completeMission() {
        for (Mission mission : missions) {
            mission.setState();
        }
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(super.toString());
        output.append(System.lineSeparator()).append("Missions:");
        for (Mission mission: this.getMissions()) {
            output
                    .append(System.lineSeparator())
                    .append("  ")
                    .append(mission.toString());
        }
        return output.toString();
    }
}
