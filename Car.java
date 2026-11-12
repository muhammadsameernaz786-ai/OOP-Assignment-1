
import java.awt.*;

public abstract class Car implements Movable {

    // Common car attributes
    private int nrDoors;
    private double enginePower;
    private double currentSpeed;
    private Color color;
    private String modelName;

    // Car position
    private double x = 0;
    private double y = 0;

    // Direction: 0 = North, 1 = East, 2 = South, 3 = West
    private int direction = 0;

    // Constructor
    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    // Getters and setter
    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public String getModelName() {
        return modelName;
    }

    // Position getters
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    // Engine methods
    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    // Speed calculation
    protected abstract double speedFactor();

    public void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    public void gas(double amount) {
        incrementSpeed(amount);
    }

    public void brake(double amount) {
        decrementSpeed(amount);
    }

    // Movement method
    @Override
    public void move() {
        if (direction == 0) {
            y += currentSpeed;
        } else if (direction == 1) {
            x += currentSpeed;
        } else if (direction == 2) {
            y -= currentSpeed;
        } else if (direction == 3) {
            x -= currentSpeed;
        }
    }

    // Turning methods
    @Override
    public void turnLeft() {
        direction = (direction + 3) % 4;
    }

    @Override
    public void turnRight() {
        direction = (direction + 1) % 4;
    }
}
