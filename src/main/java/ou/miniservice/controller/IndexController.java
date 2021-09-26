package ou.miniservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ou.miniservice.services.OrganizationService;

@Controller
public class IndexController {

    @GetMapping("/lists")
    public String index(Model model) {
        OrganizationService organizationService = new OrganizationService();
        model.addAttribute("organizations", organizationService.findOrganization(1));
        return "lists";
    }
}
