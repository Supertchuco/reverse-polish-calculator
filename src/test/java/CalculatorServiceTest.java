import org.junit.Before;
import org.junit.Test;
import service.CalculatorService;

import static org.junit.Assert.assertEquals;

public class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @Before
    public void setup() {
        calculatorService = new CalculatorService();
    }

    @Test
    public void calcShouldBeAbleToCalculateSingleDigitNumbers() {
        assertEquals(java.util.Optional.of(3.0).get(), calculatorService.calculate("1 2 +"));
    }

    @Test
    public void calcShouldBeAbleToCalculateMultiDigitNumbers() {
        assertEquals(java.util.Optional.of(4.0).get(), calculatorService.calculate("12 3 /"));
    }

    @Test
    public void calcShouldBeAbleToHandleNegativeNumbers() {
        assertEquals(java.util.Optional.of(-4.0).get(), calculatorService.calculate("-12 3 /"));
    }

    @Test
    public void calShouldBeAbleToHandleDecimalNumbers() {
        assertEquals(java.util.Optional.of(-4.3).get(), calculatorService.calculate("-12.9 3 /"));
    }

    @Test
    public void calShouldBeAbleToHandleMoreComplexNotations() {
        assertEquals(java.util.Optional.of(14.0).get(), calculatorService.calculate("1 2 + 4 * 5 + 3 -"));
    }

}
