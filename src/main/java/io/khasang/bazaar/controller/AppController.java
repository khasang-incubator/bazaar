package io.khasang.bazaar.controller;

import io.khasang.bazaar.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/")
public class AppController {
    @Autowired
    @Value("Barsik")
    private Message message;

    // http://localhost:8080/
    @RequestMapping("/")
    public String javaPageHello(Model model) {
        model.addAttribute("name", message.getName());
        // hello.jsp
        return "hello";
    }

}
