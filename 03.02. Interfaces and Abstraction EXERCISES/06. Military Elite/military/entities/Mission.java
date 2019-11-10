package military.entities;

import military.enumaration.State;

public class Mission {
    private String codeName;
    private State state;

    public Mission(String codeName, State state) {
        this.codeName = codeName;
        this.state = State.valueOf(state.toString());
    }

    public void setState() {
        this.state = State.Finished;
    }

    public State getState() {
        return this.state;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s",
                this.codeName, this.getState());
    }
}
