/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import com.centurylink.mdw.model.user.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class WorkoutController {

    private final WorkoutService workoutService;
    private final UserService userService;

    public WorkoutController(WorkoutService workoutService, UserService userService) {
        this.workoutService = workoutService;
        this.userService = userService;
    }

    @GetMapping("/workout")
    public String showWorkoutForm(Model model) {
        model.addAttribute("workoutEntry", new WorkoutEntryForm());
        return "workout"; // Assuming you have a Thymeleaf template named "workout"
    }

    @PostMapping("/workout")
    public String logWorkout(
            @ModelAttribute WorkoutEntryForm workoutEntry,
            Model model
    ) {
        // Retrieve the currently logged-in user's details
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // Log the workout entry for the user
        User user = userService.findByUsername(username);

        workoutService.logWorkout(
                user,
                workoutEntry.getStartTime(),
                workoutEntry.getEndTime(),
                workoutEntry.getExerciseType(),
                workoutEntry.getDurationMinutes(),
                workoutEntry.getSets(),
                workoutEntry.getReps(),
                workoutEntry.getAdditionalNotes()
        );

        // Redirect to the dashboard or a confirmation page
        return "redirect:/dashboard";
    }

    // Assuming you have a form backing object for the workout entry
    public static class WorkoutEntryForm {

        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        private LocalDateTime startTime;

        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        private LocalDateTime endTime;

        private String exerciseType;
        private int durationMinutes;
        private int sets;
        private int reps;
        private String additionalNotes;

        // Getters and setters
        public LocalDateTime getStartTime() {
            return startTime;
        }

        public void setStartTime(LocalDateTime startTime) {
            this.startTime = startTime;
        }

        public LocalDateTime getEndTime() {
            return endTime;
        }

        public void setEndTime(LocalDateTime endTime) {
            this.endTime = endTime;
        }

        public String getExerciseType() {
            return exerciseType;
        }

        public void setExerciseType(String exerciseType) {
            this.exerciseType = exerciseType;
        }

        public int getDurationMinutes() {
            return durationMinutes;
        }

        public void setDurationMinutes(int durationMinutes) {
            this.durationMinutes = durationMinutes;
        }

        public int getSets() {
            return sets;
        }

        public void setSets(int sets) {
            this.sets = sets;
        }

        public int getReps() {
            return reps;
        }

        public void setReps(int reps) {
            this.reps = reps;
        }

        public String getAdditionalNotes() {
            return additionalNotes;
        }

        public void setAdditionalNotes(String additionalNotes) {
            this.additionalNotes = additionalNotes;
        }
    }
}
