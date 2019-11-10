package military.interfaces;

import military.army.Mission;

import java.util.Collection;

public interface Commando extends SpecialisedSoldier{
    void addMission(Mission mission);
    Collection<Mission> getMissions();
}
