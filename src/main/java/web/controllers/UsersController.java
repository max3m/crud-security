package web.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/user")
public class UsersController {

    /*@GetMapping
    public ModelAndView showCurrentUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user");
        modelAndView.addObject("user", user);
        return modelAndView;
    }*/
    @GetMapping
    public String showUser(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "user";
    }
}