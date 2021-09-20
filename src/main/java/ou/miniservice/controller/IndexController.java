package ou.miniservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/lists")
    public String index() {
        return "lists";
    }
}
