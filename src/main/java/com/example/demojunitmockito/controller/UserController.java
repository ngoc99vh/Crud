package com.example.demojunitmockito.controller;

import com.example.demojunitmockito.model.User;
import com.example.demojunitmockito.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model){
        List<User> list= userService.getAll();
        model.addAttribute("list", list);
        return "listUser";
    }

    @GetMapping("/add")
    public String addUser(Model model){
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("/save")
    public String save(User user){
        userService.saveUser(user);
        return "redirect:/";
    }
    @GetMapping(value = "/edit")
    public String editUser(@RequestParam("id") int userId, Model model) {
        Optional<User> userEdit = userService.findbyId(userId);
        userEdit.ifPresent(user -> model.addAttribute("user", user));
        return "edit";
    }
    @GetMapping(value = "/delete")
    public String deleteUser(@RequestParam("id") int userId){
        userService.deleteUser(userId);
        return "redirect:/";
    }


}
