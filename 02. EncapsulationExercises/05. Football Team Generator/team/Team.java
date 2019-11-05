package footballteamgenerator.team;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String name) {
        boolean isRemoved = false;

        for (Player p : this.players) {
            if (p.getName().equals(name)) {
                this.players.remove(p);
                isRemoved = true;
                break;
            }
        }
        if (!isRemoved) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", name, this.getName()));
        }
    }


    public double getRatting() {
        double result = 0.0;
        for (Player player : this.players) {
            result += player.overallSkillLevel();
        }
        return Math.round(result);
    }

    private void setName(String name) {
        validateName(name);
        this.name = name;
    }

    private static void validateName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
    }

    private static void validateTeam(String validTeam, String teamToCheck) {
        if (!validTeam.equals(teamToCheck)) {
            throw new IllegalArgumentException(String.format("Team %s does not exist.", teamToCheck));
        }
    }
}
