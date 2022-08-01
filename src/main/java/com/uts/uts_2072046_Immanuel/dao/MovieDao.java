package com.uts.uts_2072046_Immanuel.dao;

import com.uts.uts_2072046_Immanuel.entity.Movie;
import com.uts.uts_2072046_Immanuel.util.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieDao implements DaoInterface<Movie> {

    public ObservableList<Movie> filterMovie(String genreFilter){

        ObservableList<Movie> listMovie = FXCollections.observableArrayList();
        Connection conn = MyConnection.getConnection();
        String query = "SELECT * FROM movie where Genre like '%" + genreFilter + "%'";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int id = result.getInt("idMovie");
                String title = result.getString("Title");
                String genre = result.getString("Genre");
                int durasi = result.getInt("Durasi");

                Movie movies = new Movie(id,title,genre,durasi);
                listMovie.add(movies);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listMovie;

    }

    @Override
    public ObservableList<Movie> getData() {

        ObservableList<Movie> listMovie = FXCollections.observableArrayList();
        Connection conn = MyConnection.getConnection();
        String query = "SELECT * FROM movie";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int id = result.getInt("idMovie");
                String title = result.getString("Title");
                String genre = result.getString("Genre");
                int durasi = result.getInt("Durasi");

                Movie movies = new Movie(id,title,genre,durasi);
                listMovie.add(movies);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listMovie;

    }

    @Override
    public int addData(Movie data) {

        int result = 0;
        Connection conn = MyConnection.getConnection();
        String query = "insert into movie values (?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1,data.getIdMovie());
            ps.setString(2,data.getTitle());
            ps.setString(3,data.getGenre());
            ps.setInt(4,data.getDurasi());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;

    }

    @Override
    public int delData(Movie data) {

        int result = 0;
        Connection conn = MyConnection.getConnection();
        String query = "delete from movie where idMovie = ?";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1,data.getIdMovie());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;

    }

    @Override
    public int upData(Movie data) {

        int result = 0;
        Connection conn = MyConnection.getConnection();
        String query = "update movie set Title=?, Genre=?, Durasi=? where idMovie=?";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1,data.getTitle());
            ps.setString(2,data.getGenre());
            ps.setInt(3,data.getDurasi());
            ps.setInt(4,data.getIdMovie());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;

    }
}
