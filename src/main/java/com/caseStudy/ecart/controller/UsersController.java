package com.caseStudy.ecart.controller;

import com.caseStudy.ecart.models.Users;
import com.caseStudy.ecart.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders= "*")
public class UsersController {
    @Autowired
    userRepository z;

    @PostMapping("/addUsers")
    public Users addusers(@Valid @RequestBody Users users)
    {
        return z.save(users);
    }
    @GetMapping("/getUsers")
    public List<Users> getUsers()
    {
        return z.findAll();
    }
    @GetMapping("/validuser")
    public String valuser()
    {
        return "\" user successfully authenticated\"";
    }

}
