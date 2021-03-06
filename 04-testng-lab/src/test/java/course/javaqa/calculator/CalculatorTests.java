package course.javaqa.calculator;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorTests {
    private Calculator calculator;

    @BeforeClass
    public void setup() {
        calculator = new Calculator();
    }

    @BeforeGroups(groups="regression")
    public void setupRegressionGroup() {
        calculator = new Calculator();
    }

    @AfterClass
    public void tearDown() {
        calculator = null;
    }

    @Test(groups = "regression")
    public void givenTwoNumbers_whenAdd_thenSum() {
        assertEquals(calculator.add(5, 7), 12, "5 + 7 == 12");
    }

    @Test
    public void givenTwoNumbers_whenMultiply_thenProduct() {
        assertEquals(calculator.multiply(5, 7), 35, "5 * 7 == 35");
    }

}
