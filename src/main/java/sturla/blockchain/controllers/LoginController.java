package sturla.blockchain.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sturla.blockchain.model.User;
import sturla.blockchain.repositories.UserRepository;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginForm(User user){
        return "login";
    }

    @PostMapping("/createUser")
    public String addUser(User user, BindingResult result, Model model){
        userRepository.save(user);
        return "menu";
    }

}
