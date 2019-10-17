package com.caseStudy.ecart.repository;

import com.caseStudy.ecart.models.OrderHistory;
import com.caseStudy.ecart.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface orderHistoryRepositroy extends JpaRepository<OrderHistory,Long> {

    List<OrderHistory> findAllByUsers(Users users);
}
