
package com.example.mediatracker.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    @NotBlank(message = "Username is required.")
    @Size(max = 25, message = "Username must be at most 25 characters.")
    private String username;

    @NotBlank(message = "Password is required.")
    @Size(max = 25, message = "Password must be at most 25 characters.")
    private String password;

    private Day[][][] yearlySchedule;

    //private String username;
    //private String password;
    //private Day[][][] yearlySchedule;

    public User() {
        //initializeSchedule();
        // Needed for Spring form binding
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        //this.yearlySchedule = new Day[12][4][7];
        //initializeSchedule();
    }
    //private Day[][][] yearlySchedule;

    public void initializeSchedule() {
        if (yearlySchedule != null) return;
        yearlySchedule = new Day[12][4][7]; //  allocate memory FIRST
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 7; k++) {
                    yearlySchedule[i][j][k] = new Day();
                }
            }
        }
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public Day[][][] getYearlySchedule() { return yearlySchedule; }
}
