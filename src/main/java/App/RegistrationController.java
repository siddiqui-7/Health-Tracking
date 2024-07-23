/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import com.centurylink.mdw.model.user.User;
import org.apache.fulcrum.security.util.PasswordMismatchException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String showRegistrationForm() {
        return "registration"; // Assuming you have a Thymeleaf template named "registration"
    }

    @PostMapping("/registration")
    public String registerUser(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String confirmPassword,
            Model model
    ) {
        try {
            // Check if the passwords match
            if (!password.equals(confirmPassword)) {
                throw new PasswordMismatchException("Passwords do not match");
            }

            // Register the user
            User registeredUser = userService.registerUser(username, password);

            // Redirect to the login page after successful registration
            return "redirect:/login";
        } catch (PasswordMismatchException e) {
            model.addAttribute("error", "Passwords do not match");
        } catch (Exception e) {
            model.addAttribute("error", "Registration failed");
        }

        // If registration fails, return to the registration form with an error message
        return "registration";
    }
}
