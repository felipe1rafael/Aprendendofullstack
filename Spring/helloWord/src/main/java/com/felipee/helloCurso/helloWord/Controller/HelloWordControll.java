package com.felipee.helloCurso.helloWord.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordControll {
    @RequestMapping("/helloWord")
    public String showText() {
        return "Hello World!";
    }

}
