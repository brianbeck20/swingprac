package com.yoo;

public class Login {

    public static boolean authenticate(String username, String password) {
        // hardcoded username and password
        if (username.equals("yoo") && password.equals("sun")) {
            return true;
        }
        return false;
    }
}

