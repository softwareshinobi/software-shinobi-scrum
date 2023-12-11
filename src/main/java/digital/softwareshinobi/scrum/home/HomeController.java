package digital.softwareshinobi.scrum.home;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import digital.softwareshinobi.scrum.account.AccountRepository;

@Controller
@Slf4j
public class HomeController {

    @Autowired
    AccountRepository userRepository;
    

    @Autowired
    public HomeController(AccountRepository userRepository) {
       
        System.out.println("HomeController HomeController HomeController");
       
       this.userRepository = userRepository;
              
    }

    @GetMapping("/")
    public String goToIndex(Model model) {
        model.addAttribute("info", "Great");
        return "index";

    }

}
