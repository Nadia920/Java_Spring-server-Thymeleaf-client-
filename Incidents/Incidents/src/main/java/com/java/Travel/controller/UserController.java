package com.java.Travel.controller;


import com.java.Travel.controller.dto.ApiError;
import com.java.Travel.controller.dto.UserDTO;
import com.java.Travel.exception.UserNotFoundException;
import com.java.Travel.model.RoleEntity;
import com.java.Travel.model.UserEntity;
import com.java.Travel.service.RoleService;
import com.java.Travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    public UserController() {
    }

    public UserController(UserService userService,
                          RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'WORKER')")
    @GetMapping()
    public String getAllUsersByRole(@RequestParam(value = "role", required = false) String role, Model model) {
        role = role == null ? "ROLE_CLIENT" : role;
        List<UserDTO> users = roleService.getUsersByRole(role);
        model.addAttribute("role", role);
        model.addAttribute("users", users.size() == 0 ? null : users);
        return "user/showUsers";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'WORKER')")
    @GetMapping(path = "/delete")
    public String deleteEmployeeById(Model model,
                                     @RequestParam("id") Long id,
                                     @RequestParam(value = "role") String role) throws UserNotFoundException {
        userService.deleteUserById(id);
        String redirect = "redirect:/users?&role=" + role;
        return redirect;
    }




}
