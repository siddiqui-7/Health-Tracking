/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import com.centurylink.mdw.model.user.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WorkoutServiceImpl implements WorkoutService {

    private final WorkoutRepository workoutRepository;
    private final UserService userService;

    public WorkoutServiceImpl(WorkoutRepository workoutRepository, UserService userService) {
        this.workoutRepository = workoutRepository;
        this.userService = userService;
    }

    public List<Workout> getUserWorkouts(User user) {
        return workoutRepository.findByUser(user);
    }

    public Workout logWorkout(User user, LocalDateTime startTime, LocalDateTime endTime,
                              String exerciseType, int durationMinutes, int sets, int reps,
                              String additionalNotes) {
        Workout workout = new Workout();
        workout.setUser(user);
        workout.setStartTime(startTime);
        workout.setEndTime(endTime);
        workout.setExerciseType(exerciseType);
        workout.setDurationMinutes(durationMinutes);
        workout.setSets(sets);
        workout.setReps(reps);
        workout.setAdditionalNotes(additionalNotes);

        return workoutRepository.save(workout);
    }
}
