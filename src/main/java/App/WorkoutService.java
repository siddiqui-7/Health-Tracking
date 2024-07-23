/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import com.centurylink.mdw.model.user.User;
import java.time.LocalDateTime;
import java.util.List;

public interface WorkoutService {

    /**
     * Get workout data for a specific user.
     *
     * @param user The user for whom to retrieve workout data.
     * @return List of workout entries for the user.
     */
    List<Workout> getUserWorkouts(User user);

    /**
     * Log a new workout entry for a user.
     *
     * @param user            The user for whom to log the workout entry.
     * @param startTime       The start time of the workout.
     * @param endTime         The end time of the workout.
     * @param exerciseType    The type of exercise performed during the workout.
     * @param durationMinutes The duration of the workout in minutes.
     * @param sets            The number of sets performed during the workout.
     * @param reps            The number of repetitions performed during the workout.
     * @param additionalNotes Any additional notes or comments about the workout.
     * @return The logged workout entry.
     */
    Workout logWorkout(User user, LocalDateTime startTime, LocalDateTime endTime,
                       String exerciseType, int durationMinutes, int sets, int reps,
                       String additionalNotes);

    //List<Workout> getUserWorkouts(User user);
}

