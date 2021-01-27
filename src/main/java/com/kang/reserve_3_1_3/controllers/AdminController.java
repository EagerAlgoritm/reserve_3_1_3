package com.kang.reserve_3_1_3.controllers;

import com.kang.reserve_3_1_3.models.User;
import com.kang.reserve_3_1_3.service.RoleService;
import com.kang.reserve_3_1_3.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("user/admin")
public class AdminController {

    private final UserService userService;

    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String index(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) auth.getPrincipal();
        List<GrantedAuthority> list = (List<GrantedAuthority>) auth.getAuthorities();

        StringBuilder stringBuilder = new StringBuilder();
        for(GrantedAuthority el : list) {
            stringBuilder.append(el.getAuthority()).append(" ");
        }

        model.addAttribute("authorityString", stringBuilder.toString());
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("allRoles", roleService.getAllRoles());
        model.addAttribute("users", userService.index());
        model.addAttribute("newUser", new User());
        return "user/admin/index";
    }

    @GetMapping("/new")
    public String index(@ModelAttribute("user") User user, Model model){
        model.addAttribute("rolesAll", roleService.getAllRoles());
        return "user/admin/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/user/admin/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userService.show(id));
        return "user/admin/edit";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userService.show(id));
        return "user/admin/show";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute("user") User user){
        userService.update(id, user);
        return "redirect:/user/admin/";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/user/admin/";
    }

}
