package course.javaqa.calculator;

import lombok.extern.slf4j.Slf4j;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(JUnit4.class)
@Slf4j
public class CalculatorTest {
    private Calculator calculator;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @BeforeClass
    public static void beforeAll() {
        log.info("Before all tests");
    }

    @AfterClass
    public static void afterAll() {
        log.info("After all tests");
    }


    @Before
    public void setup() {
        log.info("Setup Calculator before test");
        calculator = new Calculator();
    }

    @After
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
        assertEquals("Regular multiplication should work", 40, result);
        assertEquals("Regular multiplication should work", 63, calculator.multiply(7, 9));
    }

    @Test
    public void givenXandY_whenAdd_thenAddResultXplusY() {
        log.info("Testing add");
        //test
        int result = calculator.add(5, 8);

        //verify
        assertEquals("Regular add should work", 13, result);
    }

    @Test
    public void givenXandNonZeroY_whenDivide_thenResultXDividedByY() {
        log.info("Testing divide by nonzero divider");
        //test
        int result = calculator.divide(42, 5);

        //verify
        assertEquals("Divide by nonzero divider should work", 8, result);
    }

    @Test(expected = ArithmeticException.class)
    public void givenXandZeroDivider_whenDivide_thenArithmeticException() {
        log.info("Testing divide by zero divider");
        //test and verify exception is thrown
        calculator.divide(42, 0);
    }

    @Test
    public void givenXandZeroDivider_whenDivide_thenArithmeticExceptionAssertion() {
        log.info("Testing divide by zero divider");
        //test and verify exception is thrown
        assertThrows("Should throw division by zero ArithmenticException",
                ArithmeticException.class, () -> calculator.divide(42, 0));
    }

    @Test
    public void givenXandZeroDivider_whenDivide_thenArithmeticExceptionRule() {
        log.info("Testing divide by zero divider using Rule to verify exception message");
        exception.expect(ArithmeticException.class);
        exception.expectMessage("/ by zero");
        //test and verify exception is thrown
        calculator.divide(42, 0);
    }

}








