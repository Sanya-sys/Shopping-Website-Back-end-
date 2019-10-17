package com.caseStudy.ecart.controller;

import com.caseStudy.ecart.models.Users;
import com.caseStudy.ecart.repository.userRepository;
import com.caseStudy.ecart.service.currentuserservice;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/profile")
public class MyProfileController {
    @Autowired
    currentuserservice x;
 @Autowired
 userRepository u;

    @GetMapping("/get")
    public Users getdata(Principal principal)
    {
        return x.getpro(principal);
    }
    @PutMapping("/update")
    public Users function(@Valid @RequestBody Users users)
    {
        users.setActive(1);
        u.save(users);
        return users;
    }
}
