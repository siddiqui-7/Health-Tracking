/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

public class WorkoutEntryForm {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime startTime;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime endTime;

    private String exerciseType;
    private int durationMinutes;
    private int sets;
    private int reps;
    private String additionalNotes;

    // Getters
    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    // Setters (if needed)

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    // Other setter methods for other fields...
}
