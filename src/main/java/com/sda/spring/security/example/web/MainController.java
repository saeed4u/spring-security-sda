package com.sda.spring.security.example.web;

import com.sda.spring.security.example.entities.User;
import com.sda.spring.security.example.service.RoleService;
import com.sda.spring.security.example.service.UserService;
import com.sda.spring.security.example.web.dto.CreateUserDTO;
import com.sda.spring.security.example.web.dto.UserRegistrationDto;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @ModelAttribute("user")
    public CreateUserDTO createUserDTO() {
        return new CreateUserDTO();
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }

    @GetMapping
    public ModelAndView getAllUsers(){
        List<User> users = userService.getAllUsers();
        ModelAndView modelAndView = new ModelAndView("user/all");
        modelAndView.addObject("users",users);
        return modelAndView;
    }

    @GetMapping("users/create")
    public ModelAndView createUser() throws Exception {
        ModelAndView modelAndView = new ModelAndView("user/create");
        modelAndView.addObject("roles", roleService.getAllRoles());
        return modelAndView;
    }

    @PostMapping("users/create")
    public String createUser(@ModelAttribute("user")CreateUserDTO createUserDTO) throws Exception {
        userService.createUser(createUserDTO);
        return "redirect:/";
    }

    @GetMapping("users/{userId}/delete")
    public String deleteUser(@PathVariable("userId") Long userId) throws Exception {
        userService.deleteUser(userId);
        return "redirect:/";
    }
}
