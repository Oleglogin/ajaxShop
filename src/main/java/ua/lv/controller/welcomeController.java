package ua.lv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by User on 18.05.2019.
 */
@Controller
public class welcomeController {

    @GetMapping(value ="/")
    public String toMain(){
        return "welcome";
    }

}
