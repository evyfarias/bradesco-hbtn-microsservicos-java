package com.example.demo.controller;

import com.example.demo.exception.CPFException;
import com.example.demo.exception.UserIdException;
import com.example.demo.exception.UserNameException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping("/user-id/{id}")
    public String findUserById(@PathVariable int id) {

        if (id > 0 && id < 100) {
            return "You have entered valid ID";
        } else {
            throw new UserIdException(String.valueOf(id));
        }
    }

    @GetMapping("/user-name/{username}")
    public String findUserByName(@PathVariable String username) {

        if (username.length() > 3 && username.length() < 15) {
            return "You have entered valid USERNAME";
        } else {
            throw new UserNameException(username);
        }
    }

    @GetMapping("/user-cpf/{cpf}")
    public String findUserByCPF(@PathVariable String cpf) {

        boolean isValid = isCPF(cpf);

        if (isValid) {
            return "You have entered valid CPF";
        } else {
            throw new CPFException(cpf);
        }
    }

    public boolean isCPF(String cpf) {
        return cpf != null && cpf.length() > 3 && cpf.length() < 15;
    }
}
