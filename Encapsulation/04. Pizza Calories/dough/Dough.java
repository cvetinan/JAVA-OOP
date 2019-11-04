package pizzacalories.dough;

import static pizzacalories.validator.DataValidation.*;

public class Dough {
    private final static double BASE_CALORIES_INDEX = 2.0;
    private final static double WHITE_DOUGH = 1.5;
    private final static double WHOLEGRAIN_DOUGH = 1.0;
    private final static double CRISPY = 0.9;
    private final static double CHEWY = 1.1;
    private final static double HOMEMADE = 1.0;

    private String flourType;
    private String backingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight){
            setFlourType(flourType);
            setBackingTechnique(bakingTechnique);
            setWeight(weight);
    }

    public String getFlourType() {
        return this.flourType;
    }

    public String getBackingTechnique() {
        return this.backingTechnique;
    }

    public double getWeight() {
        return this.weight;
    }

    public double calculateCalories(){
        double flourCalories = getFlourCalories(getFlourType());
        double backingTechCalories = getBackingTechniqueCalories(getBackingTechnique());
        return (BASE_CALORIES_INDEX * this.weight) * flourCalories * backingTechCalories;
    }

    private double getBackingTechniqueCalories(String backingTechnique) {
        double backingTechCalories = 0.0;
        switch (backingTechnique.toLowerCase()){
            case "crispy":
                backingTechCalories = CRISPY;
                break;
            case "chewy":
                backingTechCalories = CHEWY;
                break;
            case "homemade":
                backingTechCalories = HOMEMADE;
                break;
        }
        return backingTechCalories;
    }

    private double getFlourCalories(String flourType){
        double flourCalories = 0.0;
        switch (flourType.toLowerCase()){
            case "white":
                flourCalories = WHITE_DOUGH;
                break;
            case "wholegrain":
                flourCalories = WHOLEGRAIN_DOUGH;
                break;
        }
        return flourCalories;
    }

    private void setFlourType(String flourType) {
        validateDoughType(flourType);
        this.flourType = flourType;
    }

    private void setBackingTechnique(String backingTechnique) {
        validateBackingTechnique(backingTechnique);
        this.backingTechnique = backingTechnique;
    }

    private void setWeight(double weight) {
        validateDoughWeigh(weight);
        this.weight = weight;
    }
}
