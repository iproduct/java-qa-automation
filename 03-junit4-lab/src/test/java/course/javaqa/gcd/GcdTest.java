package course.javaqa.gcd;

import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class GcdTest {
    private Gcd gcd = new Gcd();

    @Parameters(name = "{index}: GCD({0}+{1})={2}")
    public static Iterable<Object[]> data1() {
        return Arrays.asList(new Object[][] {
                {48, 72, 24},
                {17, 351, 1},
                {81, 63, 9}
        });
    }


    @Test
    public void givenXandY_whenGcd_thenGcdXandY() {
        assertEquals("Regular X and Y numbers", 14, gcd.gcd(42, 28));
        assertEquals("Regular X and Y prime number", 1, gcd.gcd(55, 17));
        assertEquals("Regular X and Y divides X", 7, gcd.gcd(42, 7));
        assertEquals("Regular Y and X divides Y", 7, gcd.gcd(7, 42));
    }
}
