
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

    public static void main(String[] args) {

        testTurbo();
        testStartEngine();
        testStopEngine();

    }
}
