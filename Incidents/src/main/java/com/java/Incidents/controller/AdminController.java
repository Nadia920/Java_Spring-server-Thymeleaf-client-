package com.java.Incidents.controller;

import com.java.Incidents.model.User;
import com.java.Incidents.service.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/")
public class AdminController {
    protected AdminController(UserServiceImpl service) {

    }

    /*@Override
        public ResponseEntity<AdminEntity> save(AdminEntity entity) {
            return null;
        }*/
    @GetMapping("/Client")
    public String Client() {
        return "Client";
    }

    public ResponseEntity<User> save(User entity) {
        return null;
    }


    @PostMapping("/menuAdmin")
    public String MenuAdmin(String number) {
        switch (number){
            case "1": { return "redirect:/Incidents"; }
            case "2": { return "redirect:/FixedDetachments"; }
            case "3": { return "redirect:/Detachment"; }
            case "4": { return "redirect:/"; }
            case "5": { return "redirect:/Incidents"; }
        }
        return "Client";
    }

}
