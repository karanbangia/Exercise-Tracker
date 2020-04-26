package com.webapp.ExcerciseTracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
@JsonPropertyOrder({"userId", "userName"})
public class User {


    @Id
//    @GeneratedValue(strategy = GenerationType.)
    @JsonProperty("userId")
    @Column(name = "user_id")
    String userId;

    @JsonProperty("userName")
    @Column(name = "user_name")
    @NotNull
    @Size(min = 2, message = "username must be at least 2 characters")
    String userName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
