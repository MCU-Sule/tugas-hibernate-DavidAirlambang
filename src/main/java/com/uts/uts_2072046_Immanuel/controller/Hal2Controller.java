package com.uts.uts_2072046_Immanuel.controller;

import com.uts.uts_2072046_Immanuel.dao.UserDao;
import com.uts.uts_2072046_Immanuel.entity.UserEntity;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Hal2Controller {
    public TextField txtUserName;
    public PasswordField txtPassword;

    public void initialize(){

    }
    public void submit(ActionEvent actionEvent) {

        UserDao userDao = new UserDao();
        UserEntity userEntity = new UserEntity();
        userEntity.setIdUser(0);
        userEntity.setUserName(txtUserName.getText());
        userEntity.setUserPassword(txtPassword.getText());
        userDao.addData(userEntity);

        txtUserName.getScene().getWindow().hide();
        txtUserName.setText("");
        txtPassword.setText("");

    }

}
