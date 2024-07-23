/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import com.centurylink.mdw.model.user.User;
import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final UserService userService;
    private final WorkoutService workoutService;
    private final NutritionService nutritionService;

    public DashboardController(UserService userService, WorkoutService workoutService, NutritionService nutritionService) {
        this.userService = userService;
        this.workoutService = workoutService;
        this.nutritionService = nutritionService;
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        // Retrieve the currently logged-in user's details
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userService.findByUsername(username);

        // Fetch user's workout and nutrition data
        List<Workout> workouts = workoutService.getUserWorkouts(user);
        List<Nutrition> nutritionData = nutritionService.getUserNutrition(user);

        // Add user details, workouts, and nutrition data to the model
        model.addAttribute("user", user);
        model.addAttribute("workouts", workouts);
        model.addAttribute("nutritionData", nutritionData);

        return "dashboard"; // Assuming you have a Thymeleaf template named "dashboard"
    }
}

