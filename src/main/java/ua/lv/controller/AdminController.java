package ua.lv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.lv.entity.Product;
import ua.lv.service.ProductService;

/**
 * Created by User on 18.05.2019.
 */
@Controller
public class AdminController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/admin")
    public String toAdmin(Model model, @ModelAttribute("emptyProduct")Product product){

        model.addAttribute("productList",productService.findAll());
        return "admin";
    }

    @RequestMapping(value = "/ajaxSaveProduct", method = RequestMethod.POST)
    public String saveProduct(@RequestParam("productModel") String productModel,
                              @RequestParam("productBrand") String productBrand,
                              @RequestParam("productImg") String productImg,
                              @RequestParam("category") String category,
                              @RequestParam("subCategory") String subCategory,
                              @RequestParam("available") boolean available,
                              @RequestParam("price") int price,
                              @RequestParam("description")String description){

        productService.saveProduct(new Product(productBrand,productModel,productImg,category,subCategory,price,available,description));
        return "admin";
    }
}
