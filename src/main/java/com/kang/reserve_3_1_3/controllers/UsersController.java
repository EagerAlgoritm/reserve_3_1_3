package com.kang.reserve_3_1_3.controllers;

import com.kang.reserve_3_1_3.models.User;
import com.kang.reserve_3_1_3.service.RoleService;
import com.kang.reserve_3_1_3.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("user")
public class UsersController {

    private final UserService userService;

    private final RoleService roleService;

    public UsersController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String show(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) auth.getPrincipal();
        List<GrantedAuthority> list = (List<GrantedAuthority>) auth.getAuthorities();

        StringBuilder stringBuilder = new StringBuilder();
        for(GrantedAuthority el : list) {
            stringBuilder.append(el.getAuthority().toString()).append(" ");
        }

        model.addAttribute("authorityString", stringBuilder.toString());
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("allRoles", roleService.getAllRoles());
        model.addAttribute("users", userService.index());
        model.addAttribute("newUser", new User());
        return "user/index";
    }

}
