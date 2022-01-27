package course.javaqa;

import course.javaqa.calculator.CalculatorTest;
import course.javaqa.gcd.GcdTest;
import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("JUnit Platform Suite Demo")
@SelectPackages("course.javaqa")
@IncludeClassNamePatterns(".*Test")
public class ArithmeticUtilityTests {
}
