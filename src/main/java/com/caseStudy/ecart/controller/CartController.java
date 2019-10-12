package com.caseStudy.ecart.controller;

import com.caseStudy.ecart.models.Cart;
import com.caseStudy.ecart.repository.cartRepository;
import com.caseStudy.ecart.service.cartService;
import com.caseStudy.ecart.service.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/cart")
public class CartController {
    private cartRepository c;
    @Autowired
    cartService p;
    @Autowired
    userservice u;
    @RequestMapping(value="/removeproduct/recieve/{productid}",method= RequestMethod.GET)
    @ResponseBody
    public Cart removeproduct(@PathVariable int productid, Principal principal)
    {
        return p.removeproduct(u.getUserId(principal),productid);
    }
    @RequestMapping(value="/addtocart/recieve/{productid}",method= RequestMethod.GET)
    @ResponseBody
    public Cart addproduct(@PathVariable int productid, Principal principal)
    {
        return p.addProduct(u.getUserId(principal),productid);
    }
    @RequestMapping(value="/showcart/recieve",method= RequestMethod.GET)
    @ResponseBody
    public List<Cart> showproduct(Principal principal)
    {
        return p.showCart(u.getUserId(principal));
    }
    @RequestMapping(value="/removefromcart/recieve/{productid}",method= RequestMethod.GET)
    @ResponseBody
    public String remove(@PathVariable int productid, Principal principal)
    {
        return p.clearCart(u.getUserId(principal));
    }
}
