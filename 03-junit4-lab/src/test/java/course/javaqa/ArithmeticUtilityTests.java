package course.javaqa;

import course.javaqa.calculator.CalculatorTest;
import course.javaqa.gcd.GcdTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CalculatorTest.class, GcdTest.class})
public class ArithmeticUtilityTests {
}
