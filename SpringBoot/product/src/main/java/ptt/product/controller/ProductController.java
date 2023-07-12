package ptt.product.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ptt.product.model.Product;

import java.util.ArrayList;
import java.util.List;

@Controller
@SpringBootApplication
@RequestMapping("/products")
public class ProductController {
    private List<Product> theProducts;
    @PostConstruct
    private void loadData(){
        Product pro1 = new Product(1,"ip13","black",43.5,"35");
        theProducts = new ArrayList<>();
        theProducts.add(pro1);
    }
    @GetMapping("/list")
    public String listProducts(Model theModel){
        theModel.addAttribute("products",theProducts);
        return "list_products";
    }
}
