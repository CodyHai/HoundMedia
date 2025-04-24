
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