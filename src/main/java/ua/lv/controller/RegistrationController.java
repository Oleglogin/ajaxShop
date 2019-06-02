package ua.lv.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(method = RequestMethod.POST, value = "/saveUserSpringForm")
    public String saveUser(@ModelAttribute ("emptyUser")  User user){

        userService.addUser(user);

        return "redirect:/login";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveUserAjax",produces = {"text/html; charset=UTF-8"})
    public @ResponseBody
    User saveAjaxUser(@RequestParam  User userObj){

        userService.addUser(userObj);

        return userObj;
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
