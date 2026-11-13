
import java.awt.*;

public abstract class Car implements Movable {

    public int nrDoors;
    public double enginePower;
    private double currentSpeed;
    private double x = 0;
    private double y = 0;
    private int direction = 0;
    public Color color;
    public String modelName;


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

    public void startEngine() {
        currentSpeed = Math.min(0.1, enginePower);
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    protected abstract double speedFactor();


    private void incrementSpeed(double amount) {

        currentSpeed = Math.min(
            enginePower,
            currentSpeed + speedFactor() * amount
        );
    }

    private void decrementSpeed(double amount) {

        currentSpeed = Math.max(
            0,
            currentSpeed - speedFactor() * amount
        );
    }

    public void gas(double amount) {
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        }
    }

    public void brake(double amount) {
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
    }

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

    @Override
    public void turnLeft() {
        direction = (direction + 3) % 4;
    }

    @Override
    public void turnRight() {
        direction = (direction + 1) % 4;
    }
}
