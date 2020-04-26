package com.webapp.ExcerciseTracker;


import com.webapp.ExcerciseTracker.model.Exercise;
import com.webapp.ExcerciseTracker.model.User;
import com.webapp.ExcerciseTracker.repository.ExerciseRepository;
import com.webapp.ExcerciseTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/exercise")
public class MainController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ExerciseRepository exerciseRepository;

    @GetMapping(value = "/users", produces = "application/json")
    public List<User> displayUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }
    @GetMapping(value = "/status",produces = "application/json")
    public List<Exercise> status()
    {
        return exerciseRepository.findAll();
    }

    @PostMapping(path = "/new-user", produces = "application/json", consumes = "application/json")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        String userName = user.getUserName().trim();
        User x = userRepository.findByuserName(userName);
//        System.out.println("ans");
        if (x != null) {
            throw new RuntimeException("UserName already taken");
        } else {
            user.setUserName(userName);
            user.setUserId(randomStringGenerator());
            userRepository.save(user);
            return new ResponseEntity<User>(user, HttpStatus.CREATED);
        }

    }

    @PostMapping(path = "/add", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Exercise> addExercise(@RequestBody Exercise exercise) {
        User user = userRepository.findByuserId(exercise.getUser().getUserId());
        Integer duration = exercise.getDuration();
        String description = exercise.getDescription();
        LocalDate localDate = exercise.getLocalDate();
        if (user == null) {
            throw new RuntimeException("UserId not present");
        }
        if (duration == null) {
            throw new RuntimeException("duration not set");
        }
        if (duration < 0) {
            throw new RuntimeException("duration is less than 0");
        }
        if (description == null) {
            throw new RuntimeException("Please enter duration");
        }
        if (localDate == null) {
            exercise.setLocalDate(LocalDate.now());
        }
        if(exercise.getUser().getUserName()==null)
        {
        }
        exercise.setUser(user);
        exerciseRepository.save(exercise);

        return new ResponseEntity<Exercise>(exercise, HttpStatus.CREATED);
    }

    private String randomStringGenerator() {
        String alphabets = "abcdefghijklmnopqrtstuvwzyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890-_";
        String ans = "";
        for (int i = 0; i < 10; i++) {
            ans += alphabets.charAt((int) Math.floor(Math.random() * alphabets.length()));
        }
        return ans;
    }
}
