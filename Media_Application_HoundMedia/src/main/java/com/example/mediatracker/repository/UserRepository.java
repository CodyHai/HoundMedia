package com.example.mediatracker.repository;

import com.example.mediatracker.model.User;

import java.io.*;
import java.util.HashMap;

public class UserRepository {

    private static HashMap<String, User> userMap = new HashMap<>();
    private static final String FILE_NAME = "users.db";

    static {
        loadUsersFromFile();
    }

    public static void save(User user) {
        userMap.put(user.getUsername(), user);
        saveUsersToFile();
    }

    public static boolean exists(String username) {
        return userMap.containsKey(username);
    }

    public static User findByUsername(String username) {
        return userMap.get(username);
    }

    public static void saveUsersToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(userMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static void loadUsersFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            userMap = new HashMap<>();
            return;
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            userMap = (HashMap<String, User>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            userMap = new HashMap<>();
        }
    }

    public static HashMap<String, User> getAllUsers() {
        return userMap;
    }
}


/*
package com.example.mediatracker.repository;

import com.example.mediatracker.model.User;
import java.util.HashMap;

public class UserRepository {
    private static final HashMap<String, User> users = new HashMap<>();

    public static void save(User user) {
        users.put(user.getUsername(), user);
    }

    public static User findByUsername(String username) {
        return users.get(username);
    }

    public static boolean exists(String username) {
        return users.containsKey(username);
    }
}
*/


/*
package com.example.mediatracker.repository;

import com.example.mediatracker.model.User;
import java.util.HashMap;

public class UserRepository {
    private static final HashMap<String, User> users = new HashMap<>();

    public static void save(User user) {
        users.put(user.getUsername(), user);
    }

    public static User findByUsername(String username) {
        return users.get(username);
    }

    public static boolean exists(String username) {
        return users.containsKey(username);
    }
}
*/