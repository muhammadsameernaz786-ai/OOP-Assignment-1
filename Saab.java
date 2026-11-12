
import java.awt.*;

public class Saab extends Car {

    private boolean turboOn;

    public Saab() {
        super(2, 125, Color.red, "Saab");
        turboOn = false;
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    @Override
    protected double speedFactor() {
        double turbo = 1;

        if (turboOn) {
            turbo = 1.3;
        }

        return getEnginePower() * 0.01 * turbo;
    }
}
