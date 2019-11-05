package footballteamgenerator.team;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance,
                  int sprint, int dribble,
                  int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    public String getName() {
        return this.name;
    }

    public double overallSkillLevel() {
        return calculateSkillLevel();
    }

    private double calculateSkillLevel() {
        int[] results = new int[]{this.shooting, this.passing, this.dribble, this.sprint, this.endurance};
        Integer sum = 0;
        for (int result : results) {
            sum += result;
        }
        return sum.doubleValue() / results.length;
    }

    private void setShooting(int shooting) {
        validateRange(shooting, "Shooting");
        this.shooting = shooting;
    }

    private void setPassing(int passing) {
        validateRange(passing, "Passing");
        this.passing = passing;
    }

    private void setDribble(int dribble) {
        validateRange(dribble, "Dribble");
        this.dribble = dribble;
    }

    private void setSprint(int sprint) {
        validateRange(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setEndurance(int endurance) {
        validateRange(endurance, "Endurance");
        this.endurance = endurance;
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

    private static void validateRange(int value, String statName) {
        if (value < 0 || value > 100) {
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.", statName));
        }
    }
}
