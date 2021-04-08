package web.controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.RoleDAO;
import web.model.Role;
import web.model.User;
import web.service.UserService;

import java.util.HashSet;
import java.util.Set;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleDAO roleDAO;
    private final PasswordEncoder bCryptPasswordEncoder;

    public AdminController(UserService userService, RoleDAO roleDAO, PasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.roleDAO = roleDAO;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping
    public String allUsers(Model model) {
        model.addAttribute("allUsersList", userService.allUsers());
        return "admin";
    }

    @GetMapping(value = "/new")
    public String newUserPage(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping(value = "")
    public String newUserPost(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "user";
    }

    @GetMapping("/{id}/edit")
    public String editPage(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        model.addAttribute("rolesList", roleDAO.getRoleSet());
        return "edit";
    }

    @PatchMapping(value = "/{id}")
    public String editUserPatch(
            @ModelAttribute("id") Long id,
            @ModelAttribute("username") String username,
            @ModelAttribute("name") String name,
            @ModelAttribute("password") String password,
            @ModelAttribute("email") String email,
            @ModelAttribute("age") byte age,
            @RequestParam("roles") String[] roles
    ) {
        User user = userService.getById(id);
        user.setName(username);
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        if (!password.isEmpty()) {
            user.setPassword(password);
        }
        System.out.println(user);
        System.out.println(roles);
        Set<Role> rolesSet = new HashSet<>();
        for (String st : roles) {
            if (st.equals("ADMIN")) {
                Role role_admin = roleDAO.createRoleIfNotFound("ADMIN", 1L);
                rolesSet.add(role_admin);
            }
            if (st.equals("USER")) {
                Role role_user = roleDAO.createRoleIfNotFound("USER", 2L);
                rolesSet.add(role_user);
            }
        }
        user.setRoles(rolesSet);
        userService.update(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.delete(userService.getById(id));
        return "redirect:/admin";
    }
}