package com.uts.uts_2072046_Immanuel.entity;

public class User {

    private int idUser;
    private String userName;
    private String userPassword;

    @Override
    public String toString() {
        return userName;
    }

    public User(int idUser, String userName, String userPassword) {
        this.idUser = idUser;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
