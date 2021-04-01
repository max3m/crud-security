package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloController {

    @GetMapping(value = "/")
    public String startPage() {
        return "hello/startPage";
    }

    @GetMapping(value = "/hello")
    public String printWelcome() {
        return "hello/hello";
    }

}