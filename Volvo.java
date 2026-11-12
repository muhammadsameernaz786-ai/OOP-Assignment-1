
import java.awt.*;

public class Volvo extends Car {

    private static final double trimFactor = 1.25;

    public Volvo() {
        super(4, 100, Color.black, "Volvo");
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
}
