package course.javaqa.calculator;

import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class ParameterizedTests {
    private Calculator calculator;

    @DataProvider(name = "numbers")
    public static Object[][] calculatorData() {
        return new Object[][]{{12, 5, 60}, {-3, 7, -21}, {0, 17, 0}};
    }

    @BeforeClass
    public void setup() {
        calculator = new Calculator();
    }

    @AfterClass
    public void tearDown() {
        calculator = null;
    }

    @Test //(enabled = false)
    @Parameters({"x", "y", "result"})
    public void givenTwoNumbers_whenMultiply_thenProduct(int x, int y, int result) {
        assertEquals(calculator.multiply(x, y), result, x +" * " + y + " == " + result);
    }

    @Test(dataProvider = "numbers")
    public void givenTwoNumberParams_whenMultiply_thenProductResult(int x, int y, int result) {
        assertEquals(calculator.multiply(x, y), result, x +" * " + y + " == " + result);
    }

}
