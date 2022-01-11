
import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    static BonusService service = new BonusService();

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimit() {

        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndOverLimit() {

        long amount = 1_000_000_60;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void shouldCalculateForNotRegisteredAndOverLimit() {

        long amount = 20_000_60;
        boolean registered = false;
        long expected = 200;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void shouldCalculateForNotRegisteredAndUnderLimit() {

        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

}