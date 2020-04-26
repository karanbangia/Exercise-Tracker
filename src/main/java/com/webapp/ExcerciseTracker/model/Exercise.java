package com.webapp.ExcerciseTracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "exercise")
@JsonPropertyOrder({"exerciseId","user", "duration", "description", "localDate"})
@JsonIgnoreProperties({"exerciseId"})
public class Exercise {
    @Id
    @JsonProperty("exerciseId")
    @Column(name = "exercise_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int exerciseId;


    @Column(name = "duration")
    @JsonProperty("duration")
    private Integer duration;

    @Column(name = "description")
    @JsonProperty("description")
    private String description;

    @Column(name = "local_date")
    @JsonProperty("localDate")
    private LocalDate localDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonProperty("user")
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }


}
