package ptf.aurea_etrgovina.Controllers;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ptf.aurea_etrgovina.Models.User;
import ptf.aurea_etrgovina.Services.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/Registracija")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "Registracija";
    }

    /*@GetMapping("/UserDashboard")
    public String ClientController() { return "User_dashboard";}*/

    @PostMapping("/users/new")
    public String saveUser(@ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "Registracija";
        }

        userService.saveUser(user);
        return "redirect:/Login";
    }

    @GetMapping("/Login")
    public String Login() {
        return "Login";
    }
}