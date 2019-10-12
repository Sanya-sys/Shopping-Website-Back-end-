package com.caseStudy.ecart.repository;

import com.caseStudy.ecart.controller.SignupController;
import com.caseStudy.ecart.models.SignupModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignupRepository extends JpaRepository<SignupModel,Long> {
}
