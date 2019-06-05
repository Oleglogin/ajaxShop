package ua.lv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.lv.entity.Product;
import ua.lv.entity.User;
import ua.lv.service.ProductService;

/**
 * Created by User on 18.05.2019.
 */
@Controller
public class AdminController {

    @Autowired
    ProductService productService;




    @GetMapping("/admin")
    public String toAdmin(Model model){
        model.addAttribute("emptyProduct", new Product());
        return "admin";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveProduct",produces = {"text/html; charset=UTF-8"})
    public @ResponseBody
    String saveProduct(@ModelAttribute Product product){
        productService.saveProduct(product);
        return "success";
    }
}
