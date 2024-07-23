/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class NutritionController {

    private final NutritionService nutritionService;
    private final UserService userService;

    public NutritionController(NutritionService nutritionService, UserService userService) {
        this.nutritionService = nutritionService;
        this.userService = userService;
    }

    @GetMapping("/nutrition")
    public String showNutritionForm(Model model) {
        model.addAttribute("nutritionEntry", new NutritionEntryForm());
        return "nutrition"; // Assuming you have a Thymeleaf template named "nutrition"
    }

    @PostMapping("/nutrition")
    public String logNutrition(
            @ModelAttribute NutritionEntryForm nutritionEntry,
            Model model
    ) {
        // Retrieve the currently logged-in user's details
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // Log the nutrition entry for the user
        Nutrition logNutrition = nutritionService.logNutrition(
                userService.findByUsername(username),
                nutritionEntry.getDate(),
                nutritionEntry.getMeal(),
                nutritionEntry.getSnack(),
                nutritionEntry.getWaterIntake()
        );

        // Redirect to the dashboard or a confirmation page
        return "redirect:/dashboard";
    }

    // Assuming you have a form backing object for the nutrition entry
    private static class NutritionEntryForm {

        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        private LocalDate date;

        private String meal;
        private String snack;
        private int waterIntake;

        // Getters and setters
        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public String getMeal() {
            return meal;
        }

        public void setMeal(String meal) {
            this.meal = meal;
        }

        public String getSnack() {
            return snack;
        }

        public void setSnack(String snack) {
            this.snack = snack;
        }

        public int getWaterIntake() {
            return waterIntake;
        }

        public void setWaterIntake(int waterIntake) {
            this.waterIntake = waterIntake;
        }
    }
}
