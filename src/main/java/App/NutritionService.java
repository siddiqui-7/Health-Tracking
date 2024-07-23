/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import com.centurylink.mdw.model.user.User;
import java.time.LocalDate;
import java.util.List;

public interface NutritionService {

    /**
     * Get nutrition data for a specific user.
     *
     * @param user The user for whom to retrieve nutrition data.
     * @return List of nutrition entries for the user.
     */
    List<Nutrition> getUserNutrition(User user);

    /**
     * Log a new nutrition entry for a user.
     *
     * @param user         The user for whom to log the nutrition entry.
     * @param date         The date of the nutrition entry.
     * @param meal         Details about the user's meal.
     * @param snack        Details about the user's snack.
     * @param waterIntake  The amount of water intake.
     * @return The logged nutrition entry.
     */
    Nutrition logNutrition(User user, LocalDate date, String meal, String snack, int waterIntake);

    //public List<Nutrition> getUserNutrition(User user);
}

