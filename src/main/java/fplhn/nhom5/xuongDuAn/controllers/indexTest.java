package fplhn.nhom5.xuongDuAn.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexTest {

    @GetMapping("index")
    public String index(){
        return "index";
    }

}
