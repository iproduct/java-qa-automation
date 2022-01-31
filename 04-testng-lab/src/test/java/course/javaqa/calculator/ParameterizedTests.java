package course.javaqa.calculator;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ParameterizedTests {
    private Calculator calculator;

    @BeforeClass
    public void setup() {
        calculator = new Calculator();
    }

    @AfterClass
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void givenTwoNumbers_whenMultiply_thenProduct() {
        assertEquals(calculator.multiply(6, 8), 48, "6 * 8 == 48");
    }

}
