package com.uts.uts_2072046_Immanuel.controller;

import com.uts.uts_2072046_Immanuel.dao.UserDao;
import com.uts.uts_2072046_Immanuel.entity.User;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Hal2Controller {
    public TextField txtUserName;
    public PasswordField txtPassword;

    public void initialize(){

    }
    public void submit(ActionEvent actionEvent) {

        UserDao userDao = new UserDao();
        int hasil = userDao.addData(new User(0,txtUserName.getText(),txtPassword.getText()));
        if (hasil > 0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Berhasil menambahkan");
            alert.showAndWait();
            txtPassword.getScene().getWindow().hide();
        }
        txtUserName.setText("");
        txtPassword.setText("");
    }

}
