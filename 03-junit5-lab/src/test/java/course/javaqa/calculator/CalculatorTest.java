package course.javaqa.calculator;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
public class CalculatorTest {
    private Calculator calculator;


    @BeforeAll
    public static void beforeAll() {
        log.info("Before all tests");
    }

    @AfterAll
    public static void afterAll() {
        log.info("After all tests");
    }


    @BeforeEach
    public void setup() {
        log.info("Setup Calculator before test");
        calculator = new Calculator();
    }

    @AfterEach
    public void cleanup() {
        log.info("Cleanup Calculator after test");
        calculator = null;
    }

    @Test
    public void givenXandY_whenMultiply_thenMultiplicationResultXY() {
        log.info("Testing multiply");
        //test
        int result = calculator.multiply(5, 8);

        //verify
        assertEquals( 40, result, "Regular multiplication should work");
        assertEquals( 63, calculator.multiply(7, 9), "Regular multiplication should work");
    }

    @Test
    public void givenXandY_whenAdd_thenAddResultXplusY() {
        log.info("Testing add");
        //test
        int result = calculator.add(5, 8);

        //verify
        assertEquals( 13, result, "Regular add should work");
    }

    @Test
    public void givenXandNonZeroY_whenDivide_thenResultXDividedByY() {
        log.info("Testing divide by nonzero divider");
        //test
        int result = calculator.divide(42, 5);

        //verify
        assertEquals(8, result, "Divide by nonzero divider should work");
    }

    @Test
    public void givenXandZeroDivider_whenDivide_thenArithmeticExceptionAssertion() {
        log.info("Testing divide by zero divider");
        //test and verify exception is thrown
        Throwable exception = assertThrows(ArithmeticException.class, () -> calculator.divide(42, 0),
                "Should throw division by zero ArithmenticException");
        assertEquals("/ by zero", exception.getMessage());
    }

}








