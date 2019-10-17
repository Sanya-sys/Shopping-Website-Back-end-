package com.caseStudy.ecart.controller;

import com.caseStudy.ecart.models.Products;
import com.caseStudy.ecart.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/product")
public class ProductsController {
    @Autowired
    ProductsRepository p;
    @GetMapping("/productdetails")
    public List<Products> getAllNotes()

    {
        return p.findAll();
    }
    @GetMapping("/products/category/{category}")
    public List<Products> getNode(@PathVariable(value="category")String category)
    {
        return p.findByCategory(category);
    }
    @GetMapping("productss/id/{id}")
    public Products getNode1(@PathVariable(value="id")int id)
    {
        return p.findByProductid(id);
    }
    @GetMapping("/getbyprice/{p1}/{p2}")
public List<Products> getnodByprice(@PathVariable(value="p1")int price1,@PathVariable(value="p2")int price2)
  {
        return p.findAllByProductPriceBetween(price1,price2);
  }
  @PostMapping("/addproducts")
  public Products create(@Valid @RequestBody Products p1)
  {
      return p.save(p1);
  }
}