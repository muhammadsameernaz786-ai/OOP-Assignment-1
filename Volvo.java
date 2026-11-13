
import java.awt.*;

public class Volvo extends Car {

    private static final double trimFactor = 1.25;

    public Volvo() {
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }
    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
}
