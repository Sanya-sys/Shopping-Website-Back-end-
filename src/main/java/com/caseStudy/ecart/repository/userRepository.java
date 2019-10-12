package com.caseStudy.ecart.repository;

import com.caseStudy.ecart.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface userRepository extends JpaRepository<Users,Long> {
    Users findByUserid(int userid);
    Optional<Users> findByUsername(String username);

}
