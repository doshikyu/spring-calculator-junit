package pro.sky.calculatorjunit.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.calculatorjunit.CalculatorService;
import pro.sky.calculatorjunit.CalculatorServiceImpl;
import pro.sky.calculatorjunit.exception.DivisionByZeroException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculatorServiceImplTest {
    private String greetingsMessage = "Добро пожаловать в калькулятор";

    private Double num1 = -5.5;
    private Double num2 = 8.1;

    private Double numInt1 = 17.0;
    private Double numInt2 = 10.0;

    // error case variables
    private Double nullNum = null;
    private Double zeroNum2 = 0.0;


    private CalculatorService out;

    @BeforeEach
    public void setUp() {
        out = new CalculatorServiceImpl();
    }

    @Test
    public void testCalculatorGreetings () {
        assertEquals(greetingsMessage, out.calculatorGreeting());
    }

    @Test
    public void testCalculatePlus() {
        assertEquals("-5.50 + 8.10 = 2.60", out.calculatePlus(num1, num2));
        assertEquals("17.00 + 10.00 = 27.00", out.calculatePlus(numInt1, numInt2));
    }

    @Test
    public void testCalculateMinus() {
        assertEquals("-5.50 - 8.10 = -13.60", out.calculateMinus(num1, num2));
        assertEquals("17.00 - 10.00 = 7.00", out.calculateMinus(numInt1, numInt2));
    }

    @Test
    public void testCalculateMultiply() {
        assertEquals("-5.50 * 8.10 = -44.55", out.calculateMultiply(num1, num2));
        assertEquals("17.00 * 10.00 = 170.00", out.calculateMultiply(numInt1, numInt2));
    }

    @Test
    public void testCalculateDivide() {
        assertEquals("-5.50 / 8.10 = -0.68", out.calculateDivide(num1, num2));
        assertEquals("17.00 / 10.00 = 1.70", out.calculateDivide(numInt1, numInt2));
    }

    @Test
    public void testCalculateDivideByZero() {
        Exception e = assertThrows(DivisionByZeroException.class,
                () -> out.calculateDivide(num1, zeroNum2));
        assertEquals("Cannot divide by 0.", e.getMessage());
    }

    @Test
    public void testCalculateNulls() {
        assertThrows(IllegalArgumentException.class,
                () -> out.calculatePlus(nullNum, num2));

        assertThrows(IllegalArgumentException.class,
                () -> out.calculateMinus(nullNum, num2));

        assertThrows(IllegalArgumentException.class,
                () -> out.calculateMultiply(nullNum, num2));

        assertThrows(IllegalArgumentException.class,
                () -> out.calculateDivide(nullNum, num2));
    }
}
