package com.example.calculator.controller;

import com.example.calculator.model.Calculator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/calculator")
public class CalculatorController {

    Calculator calc = new Calculator();

    @GetMapping("/welcome")
    public String messageWelcome() {
        return "Bem vindo à CALCULATOR API REST.";
    }

    @GetMapping("/addNumbers")
    public String addNumbers(@RequestParam(name = "number1") Double n1,
                             @RequestParam(name = "number2") Double n2) {
        return calc.sum(n1, n2).toString();
    }

    @GetMapping("/subNumbers")
    public String subNumbers(@RequestParam(name = "number1") Double n1,
                             @RequestParam(name = "number2") Double n2) {
        return calc.sub(n1, n2).toString();
    }

    @GetMapping("/divideNumbers")
    public String divideNumbers(@RequestParam(name = "number1") Double n1,
                                @RequestParam(name = "number2") Double n2) {
        return calc.divide(n1, n2).toString();
    }

    @GetMapping("/factorial")
    public String factorial(@RequestParam(name = "factorial") Integer factorial) {
        return calc.factorial(factorial).toString();
    }

    @GetMapping("/calculeDayBetweenDate")
    public String calculeDayBetweenDate(
            @RequestParam("localDate1")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate localDate1,

            @RequestParam("localDate2")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate localDate2) {

        return String.valueOf(calc.calculeDayBetweenDate(localDate1, localDate2));
    }

    @GetMapping("/integerToBinary")
    public String integerToBinary(@RequestParam(name = "number1") Integer n1) {
        return calc.integerToBinary(n1).toString();
    }

    @GetMapping("/integerToHexadecimal")
