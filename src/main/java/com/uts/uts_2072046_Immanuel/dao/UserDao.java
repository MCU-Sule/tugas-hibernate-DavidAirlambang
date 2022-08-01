package com.uts.uts_2072046_Immanuel.dao;

import com.uts.uts_2072046_Immanuel.entity.User;
import com.uts.uts_2072046_Immanuel.entity.User;
import com.uts.uts_2072046_Immanuel.util.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao implements DaoInterface<User> {
    @Override
    public ObservableList<User> getData() {

        ObservableList<User> listUser = FXCollections.observableArrayList();
        Connection conn = MyConnection.getConnection();
        String query = "SELECT * FROM user";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int id = result.getInt("idUser");
                String username = result.getString("UserName");
                String password = result.getString("UserPassword");
                User users = new User(id,username,password);
                listUser.add(users);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listUser;

    }

    @Override
    public int addData(User data) {

        int result = 0;
        Connection conn = MyConnection.getConnection();
        String query = "insert into user values (?,?,?)";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1,data.getIdUser());
            ps.setString(2,data.getUserName());
            ps.setString(3,data.getUserPassword());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;

    }

    @Override
    public int delData(User data) {

        int result = 0;
        Connection conn = MyConnection.getConnection();
        String query = "delete from user where idUser=?";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1,data.getIdUser());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;

    }

    @Override
    public int upData(User data) {

        int result = 0;
        Connection conn = MyConnection.getConnection();
        String query = "update user UserName=?, UserPassword=? where idUser=?";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1,data.getUserName());
            ps.setString(2,data.getUserPassword());
            ps.setInt(3,data.getIdUser());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;

    }
}
