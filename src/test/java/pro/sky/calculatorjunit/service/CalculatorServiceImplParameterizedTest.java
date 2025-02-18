package pro.sky.calculatorjunit.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.calculatorjunit.CalculatorService;
import pro.sky.calculatorjunit.CalculatorServiceImpl;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pro.sky.calculatorjunit.constants.CalculatorServiceImplTestConstants.*;

public class CalculatorServiceImplParameterizedTest {
    private CalculatorService out;

    @BeforeEach
    public void setUp() {
        out = new CalculatorServiceImpl();
    }

    @ParameterizedTest
    @MethodSource("provideParamsForPlusTests")
    public void testCalculatePlus(Double num1, Double num2, String expectedResult) {
        String result = out.calculatePlus(num1, num2);
        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForMinusTests")
    public void testCalculateMinus(Double num1, Double num2, String expectedResult) {
        String result = out.calculateMinus(num1, num2);
        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForMultiplyTests")
    public void testCalculateMultiply(Double num1, Double num2, String expectedResult) {
        String result = out.calculateMultiply(num1, num2);
        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForDivideTests")
    public void testCalculateDivide(Double num1, Double num2, String expectedResult) {
        String result = out.calculateDivide(num1, num2);
        assertEquals(expectedResult, result);
    }

    public static Stream<Arguments> provideParamsForPlusTests() {
        return Stream.of(
                Arguments.of(NUM1, NUM2, EXPECTEDPLUSRESULT1),
                Arguments.of(NUM3, NUM4, EXPECTEDPLUSRESULT2)
        );
    }

    public static Stream<Arguments> provideParamsForMinusTests() {
        return Stream.of(
                Arguments.of(NUM1, NUM2, EXPECTEDMINUSRESULT1),
                Arguments.of(NUM3, NUM4, EXPECTEDMINUSRESULT2)
        );
    }

    public static Stream<Arguments> provideParamsForMultiplyTests() {
        return Stream.of(
                Arguments.of(NUM1, NUM2, EXPECTEDMULTIPLYRESULT1),
                Arguments.of(NUM3, NUM4, EXPECTEDMULTIPLYRESULT2));
    }

    public static Stream<Arguments> provideParamsForDivideTests() {
        return Stream.of(
                Arguments.of(NUM1, NUM2, EXPECTEDDIVIDERESULT1),
                Arguments.of(NUM3, NUM4, EXPECTEDDIVIDERESULT2));
    }
}
