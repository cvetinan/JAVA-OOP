package box;

import static validator.Validator.validateSide;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private double getLength() {
        return this.length;
    }

    private double getWidth() {
        return this.width;
    }

    private double getHeight() {
        return this.height;
    }

    public double calculateSurfaceArea() {
        return  (2 * getLength() * getWidth()) +
                (2 * getLength() * getHeight()) +
                (2 * getWidth() * getHeight());
    }

    public double calculateLateralSurfaceArea() {
        return  (2 * getLength() * getHeight()) +
                (2 * getWidth() * getHeight());
    }

    public double calculateVolume() {
        return getLength() * getWidth() * getHeight();
    }


    private void setLength(double length) {
        validateSide("Length", length);
        this.length = length;
    }

    private void setWidth(double width) {
        validateSide("Width", width);
        this.width = width;
    }

    private void setHeight(double height) {
        validateSide("Height", height);
        this.height = height;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        String newLine = System.lineSeparator();
        output.append(String.format("Surface Area - %.2f",
                calculateSurfaceArea()))
                .append(newLine)
                .append(String.format("Lateral Surface Area - %.2f",
                        calculateLateralSurfaceArea()))
                .append(newLine)
                .append(String.format("Volume - %.2f",
                        calculateVolume()));

        return output.toString();
    }
}
