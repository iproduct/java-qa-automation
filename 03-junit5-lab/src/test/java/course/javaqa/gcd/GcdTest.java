package course.javaqa.gcd;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GcdTest {
//    @Parameters(name = "{index}: GCD({0},{1})={2}")
//    public static Iterable<Object[]> data1() {
//        return Arrays.asList(new Object[][] {
//                {48, 72, 24},
//                {17, 351, 1},
//                {81, 63, 9},
//                {42, 28, 14},
//                {55, 17, 1},
//                {42, 7, 7},
//                {7, 42, 7}
//        });
//    }

    private int numberA;
    private int numberB;
    private int expected;

    //pass parameters using test constructor
//    public GcdTest(
//            int numberA, int numberB, int expected) {
//        this.numberA = numberA;
//        this.numberB = numberB;
//        this.expected = expected;
//    }

    private Gcd gcd = new Gcd();

    @Test
//    @Disabled
    public void givenXandY_whenGcd_thenGcdXandY() {
        assertEquals(14, gcd.gcd(42, 28), "Regular X and Y numbers");
        assertEquals(1, gcd.gcd(55, 17), "Regular X and Y prime number");
        assertEquals(7, gcd.gcd(42, 7), "Regular X and Y divides X");
        assertEquals(7, gcd.gcd(7, 42), "Regular Y and X divides Y");
    }

//    @Test
//    @Disabled
//    public void givenXandY_whenGcd_thenGcdXandY() {
//        int result = gcd.gcd(numberA, numberB);
//        assertEquals(expected, result);
//    }


}
