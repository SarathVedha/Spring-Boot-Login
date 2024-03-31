package com.vedha.login.controller;

import com.vedha.login.dto.UserDTO;
import com.vedha.login.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping({"/", "/spring"})
@AllArgsConstructor
public class AuthController {

    private UserService userService;

    // http://localhost:8080/spring/home
    @GetMapping(value = {"/", "/home"})
    public String handleHome() {

        return "home";
    }

    // http://localhost:8080/spring/register
    @GetMapping("/register")
    public String handleRegister(Model model) {

        UserDTO userDTO = new UserDTO();
        model.addAttribute("user", userDTO);

        return "register";
    }

    // http://localhost:8080/spring/register/save
    @PostMapping("/register/save")
    public String handleSaveUser(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("user", userDTO);
            return "register";
        }

        UserDTO userDTO1 = userService.saveUsers(userDTO);

        return "redirect:/spring/register?success";
    }

    @GetMapping("/users")
    public String handleUsers(Model model) {

        List<UserDTO> allUsers = userService.getAllUsers();

        model.addAttribute("users", allUsers);

        return "users";
    }

    @GetMapping("/login")
    public String handleLogin() {

        return "login";
    }
}
