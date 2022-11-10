package ch.iso.m120.model;

import java.util.Arrays;

public class User {

    private int id;
    private String name;
    private String username;
    private char[] password;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = new char[password.length()];
        for(int i = 0; i< password.length();i++){
            this.password[i] = password.charAt(i);
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "'" + name + '\'' +
                "'" + username + '\'' +
                "'" + Arrays.toString(password) + '\''+
                "'" + email + '\'';
    }
}
