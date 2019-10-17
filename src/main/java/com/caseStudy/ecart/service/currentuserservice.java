package com.caseStudy.ecart.service;

import com.caseStudy.ecart.models.Users;
import com.caseStudy.ecart.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;
@Service
public class currentuserservice {
    @Autowired
    userRepository u;
    public Users getpro(Principal principal)
    {
        Optional<Users> op = u.findByUsername(principal.getName());
        return op.get();
    }

}
