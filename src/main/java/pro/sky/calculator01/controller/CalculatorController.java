package pro.sky.calculator01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.calculator01.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String hello() {
        return "Hello world!";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "Не верно переданные параметры";
        } else {
            return num1 + " + " + num2 + " = " + calculatorService.plus(num1, num2);
        }
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "Не верно переданные параметры";
        } else {
            return num1 + " - " + num2 + " = " + calculatorService.minus(num1, num2);
        }
    }

    @GetMapping("/multiplication")
    public String multiplication(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "Не верно переданные параметры";
        } else {
            return num1 + " * " + num2 + " = " + calculatorService.multiplication(num1, num2);
        }
    }

    @GetMapping("/division")
    public String division(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "Не верно переданные параметры";
        } else if (num2 == 0) {
            return "На ноль делить нельзя";
        } else {
            return num1 + " / " + num2 + " = " + calculatorService.division(num1, num2);
        }
    }
}
