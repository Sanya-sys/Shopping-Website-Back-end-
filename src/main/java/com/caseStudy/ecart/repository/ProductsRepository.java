package com.caseStudy.ecart.repository;

import com.caseStudy.ecart.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products,Long> {
    List<Products> findByCategory(String category);
 //   List<Products> findById(int productid);
   List<Products> findAllByProductPriceBetween(int price1, int price2);

    Products findByProductid(int productid);
}

