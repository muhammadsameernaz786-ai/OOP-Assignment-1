
public class CarTest {

    private static void reportResult(String testName, boolean success) {
        System.out.println(
            (success ? "SUCCESS: " : "FAILURE: ") + testName
        );
    }

    private static void testTurbo() {
        Saab slowSaab = new Saab();
        Saab fastSaab = new Saab();

        slowSaab.setTurboOff();
        fastSaab.setTurboOn();

        slowSaab.gas(0.5);
        fastSaab.gas(0.5);

        boolean result =
            slowSaab.getCurrentSpeed() < fastSaab.getCurrentSpeed();

        reportResult("Turbo yields more speed", result);
    }

    private static void testStartEngine() {
        Saab saab = new Saab();
        saab.startEngine();

        boolean result = saab.getCurrentSpeed() == 0.1;

        reportResult("Engine starts correctly", result);
    }

    private static void testStopEngine() {
        Saab saab = new Saab();
        saab.startEngine();
        saab.stopEngine();

        boolean result = saab.getCurrentSpeed() == 0;

        reportResult("Engine stops correctly", result);
    }

    private static void testGasIncreasesSpeed() {
        Saab saab = new Saab();
        saab.startEngine();

        double oldSpeed = saab.getCurrentSpeed();
        saab.gas(0.5);

        boolean result = saab.getCurrentSpeed() > oldSpeed;

        reportResult("Gas increases speed", result);
    }

    private static void testBrakeDecreasesSpeed() {
        Saab saab = new Saab();
        saab.startEngine();
        saab.gas(0.5);

        double oldSpeed = saab.getCurrentSpeed();
        saab.brake(0.5);

        boolean result = saab.getCurrentSpeed() < oldSpeed;

        reportResult("Brake decreases speed", result);
    }

    private static void testMaximumSpeed() {
        Saab saab = new Saab();
        saab.startEngine();

        for (int i = 0; i < 1000; i++) {
            saab.gas(1);
        }

        boolean result =
            saab.getCurrentSpeed() <= saab.getEnginePower();

        reportResult("Speed never exceeds engine power", result);
    }

    private static void testMinimumSpeed() {
        Saab saab = new Saab();
        saab.startEngine();

        for (int i = 0; i < 1000; i++) {
            saab.brake(1);
        }

        boolean result = saab.getCurrentSpeed() >= 0;

        reportResult("Speed never goes below zero", result);
    }

    private static void testInvalidGasAmount() {
        Saab saab = new Saab();
        boolean result = false;

        try {
            saab.gas(1.5);
        } catch (IllegalArgumentException e) {
            result = true;
        }

        reportResult("Gas rejects invalid values", result);
    }

    private static void testInvalidBrakeAmount() {
        Saab saab = new Saab();
        boolean result = false;

        try {
            saab.brake(-0.5);
        } catch (IllegalArgumentException e) {
            result = true;
        }

        reportResult("Brake rejects invalid values", result);
    }

    public static void main(String[] args) {
        testTurbo();
        testStartEngine();
        testStopEngine();
        testGasIncreasesSpeed();
        testBrakeDecreasesSpeed();
        testMaximumSpeed();
        testMinimumSpeed();
        testInvalidGasAmount();
        testInvalidBrakeAmount();
    }
}
