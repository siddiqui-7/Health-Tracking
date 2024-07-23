/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import com.centurylink.mdw.model.user.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import static org.apache.poi.hssf.usermodel.HeaderFooter.date;

@Service
public class NutritionServiceImpl implements NutritionService {

    private final NutritionRepository nutritionRepository;
    private final UserService userService;
    private LocalDate date;
    private String meal;
    private String snack;
    private int waterIntake;

    public NutritionServiceImpl(NutritionRepository nutritionRepository, UserService userService) {
        this.nutritionRepository = nutritionRepository;
        this.userService = userService;
    }

    public List<Nutrition> getUserNutrition(User user) {
        return nutritionRepository.findByUser(user);
    }

    public Nutrition logNutrition(User user, LocalDate date, String meal, String snack, int waterIntake) {
        Nutrition nutrition = new Nutrition();
        nutrition.setUser(user);
        nutrition.setDate(date);
        nutrition.setMeal(meal);
        nutrition.setSnack(snack);
        nutrition.setWaterIntake(waterIntake);

        return nutritionRepository.save(nutrition);
    }
}
