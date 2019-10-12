package com.caseStudy.ecart.service;



import com.caseStudy.ecart.models.Cart;
//import com.caseStudy.ecart.models.FixedCart;
import com.caseStudy.ecart.models.Products;
import com.caseStudy.ecart.models.Users;
import com.caseStudy.ecart.repository.*;
import com.caseStudy.ecart.repository.ProductsRepository;
import com.caseStudy.ecart.repository.cartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class cartService {
    @Autowired
    private ProductsRepository productRepoistory;
    @Autowired
    private cartRepository cartRepository;
    //@Autowired
   // private FixedCartRepository fixedCartRepository;
  @Autowired
    private userRepository userRepository;
    //private OrderHistoryRepository orderHistoryRepository;

    public Cart addProduct(int  userid, int productid) {
        Products products = productRepoistory.findByProductid(productid);
        Users users = userRepository.findByUserid((userid));



        if (cartRepository.findByUserAndItems(users, products).isPresent()) {
            Cart cartt =(Cart) cartRepository.findByUserAndItems(users, products).get();
            //    FixedCart fixedCart = fixedCartRepository.findByRefId(cartt.getId().intValue());
            cartt.setQuantity(cartt.getQuantity() + 1);
            //  fixedCart.setQuantity(fixedCart.getQuantity() + 1);
            cartRepository.save(cartt);
            // fixedCartRepository.save(fixedCart);
        } else {
            Cart c = new Cart(products, users, 1);
         //   FixedCart fc = new FixedCart(products, users, 1);
            cartRepository.save(c);
            //   fixedCartRepository.save(fc);
        }
        return (Cart)cartRepository.findByUserAndItems(users,products).get();
    }
    public Cart removeproduct(int userid,int productid) {
        Products products = productRepoistory.findByProductid(productid);
        Users users = userRepository.findByUserid(userid);

        if(cartRepository.findByUserAndItems(users,products).get().getQuantity() == 1) {
            Cart cart = (Cart)cartRepository.findByUserAndItems(users,products).get();
            cart.setQuantity(0);
            cartRepository.save(cart);
        }
        else if(cartRepository.findByUserAndItems(users,products).get().getQuantity() > 1) {
            Cart cart =(Cart) cartRepository.findByUserAndItems(users,products).get();

            cart.setQuantity(cart.getQuantity() - 1);
            cartRepository.save(cart);
        }
        return (Cart)cartRepository.findByUserAndItems(users,products).get();
    }

    public List<Cart> showCart(int  user_id) {
        Users user = userRepository.findByUserid(user_id);
        return cartRepository.findByUserAndItems_Active(user, 1);
    }

    public String clearCart(int userId) {

        Users user = userRepository.findByUserid(userId);
        List<Cart> cartList=cartRepository.findAllByUser(user);
        for (Cart cart : cartList) {
            cartRepository.deleteById(cart.getCartid());
        }
        return "cart cleared!";
    }
}


