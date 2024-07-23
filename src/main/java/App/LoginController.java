/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController  {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Assuming you have a Thymeleaf template named "login"
    }

    @PostMapping("/login")
    public String loginUser(Model model) {
        // You can customize this method based on your authentication needs.
        // For simplicity, we're just redirecting to the dashboard page if login is successful.
        return "redirect:/dashboard";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied"; // Assuming you have a Thymeleaf template named "access-denied"
    }
}

