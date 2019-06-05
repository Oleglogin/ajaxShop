package ua.lv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.lv.entity.User;
import ua.lv.service.ProductService;
import ua.lv.service.UserService;
import javax.validation.Valid;


/**
 * Created by User on 09.03.2019.
 */
@Controller
public class RegistrationController {
    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @GetMapping("/registration")
    public String toRegistration(Model model){

        model.addAttribute("emptyUser", new User());
        return "registration";
    }



    @RequestMapping(method = RequestMethod.POST, value = "/saveUserAjax2",produces = {"text/html; charset=UTF-8"})
    public @ResponseBody
    String saveUser2(@ModelAttribute User user){
        userService.addUser(user);
        return "success";
    }



    @RequestMapping(value = "/checkStrength", method = RequestMethod.GET,produces = {"text/html; charset=UTF-8"})
    public @ResponseBody
    String checkStrength(@RequestParam String password){
        if (password.length() >= 1 && password.length() < 4){
            return "easy";
        }
        if (password.length() >= 4 && password.length() < 6){
            return "middle";
        }
        if (password.length() >=6 ){
            return "hard";
        }
        return "";
    }


}
