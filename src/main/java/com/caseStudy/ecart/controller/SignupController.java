package com.caseStudy.ecart.controller;

import com.caseStudy.ecart.models.SignupModel;
import com.caseStudy.ecart.repository.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping( value= "/users1", method= {RequestMethod.GET, RequestMethod.POST})
public class SignupController {
    @Autowired
    SignupRepository s;
   @PostMapping("/post1")
    public SignupModel create(@Valid @RequestBody SignupModel user1 )
   {
       return s.save(user1);
   }
}
