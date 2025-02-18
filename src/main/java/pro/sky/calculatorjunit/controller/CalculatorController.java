package pro.sky.calculatorjunit.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.calculatorjunit.exception.DivisionByZeroException;
import pro.sky.calculatorjunit.CalculatorService;

@RestController
@RequestMapping(path = "/calculator")
public class CalculatorController {
    CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String welcomeMessage() {
        return calculatorService.calculatorGreeting();
    }

    @GetMapping(path = "/plus")
    public String calculatePlus(@RequestParam("num1") Double num1,
                                @RequestParam("num2") Double num2) {
        return calculatorService.calculatePlus(num1, num2);
    }

    @GetMapping(path = "/minus")
    public String calculateMinus(@RequestParam("num1") Double num1,
                                @RequestParam("num2") Double num2) {
        return calculatorService.calculateMinus(num1, num2);
    }

    @GetMapping(path = "/multiply")
    public String calculateMultiply(@RequestParam("num1") Double num1,
                                @RequestParam("num2") Double num2) {
        return calculatorService.calculateMultiply(num1, num2);
    }

    @GetMapping(path = "/divide")
    public String calculateDivide(@RequestParam("num1") Double num1,
                                @RequestParam("num2") Double num2) {
        return calculatorService.calculateDivide(num1, num2);
    }

    @ExceptionHandler(DivisionByZeroException.class)
    public String handleDivisionByZero(DivisionByZeroException e) {
        return e.getMessage();
    }

}
