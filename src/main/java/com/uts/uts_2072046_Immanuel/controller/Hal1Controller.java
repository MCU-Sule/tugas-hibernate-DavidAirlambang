package com.uts.uts_2072046_Immanuel.controller;

import com.uts.uts_2072046_Immanuel.HelloApplication;
import com.uts.uts_2072046_Immanuel.dao.MovieDao;
import com.uts.uts_2072046_Immanuel.dao.UserDao;
import com.uts.uts_2072046_Immanuel.dao.WatchListDao;
import com.uts.uts_2072046_Immanuel.entity.*;
import com.uts.uts_2072046_Immanuel.util.MyConnection;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class Hal1Controller {
    public ComboBox cmbGenre;
    public ListView<UserEntity> lvUser;
    public TableView<MovieEntity> table1;
    public TableView<WatchlistEntity> table2;
    public TableColumn movieTitle;
    public TableColumn movieGenre;
    public TableColumn movieDurasi;
    public TableColumn watchlistTitle;
    public TableColumn<WatchlistEntity, String> watchlistLastWatch;
    public TableColumn<WatchlistEntity, String> watchlistFavorite;

    private ObservableList<MovieEntity> movies;
    private ObservableList<UserEntity> users;
    private ObservableList<WatchlistEntity> watchlists;

    public void refresh(){

        UserDao userDao = new UserDao();
        users = FXCollections.observableArrayList(userDao.getData());
        lvUser.setItems(users);

    }

    public void initialize() {

//      user
        refresh();

//      movie
        ObservableList<String> genreFilter = FXCollections.observableArrayList("All","Action",
                "Musical","Comedy","Animated","Fantasy","Drama","Mystery","Thriller","Horror");
        MovieDao movieDao = new MovieDao();
        movies = FXCollections.observableArrayList(movieDao.getData());
        cmbGenre.setItems(genreFilter);
        cmbGenre.setValue("All");
        table1.setItems(movies);
        movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        movieGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        movieDurasi.setCellValueFactory(new PropertyValueFactory<>("durasi"));

//      watchlist
        WatchListDao watchListDao = new WatchListDao();
        watchlists = FXCollections.observableArrayList(watchListDao.getData());

        table2.setItems(watchlists);
        watchlistTitle.setCellValueFactory(new PropertyValueFactory<>("movieByMovieIdMovie"));
        watchlistLastWatch.setCellValueFactory(data -> new SimpleStringProperty(
                String.valueOf(data.getValue().getLastWatch()) + " / " +
                        data.getValue().getMovieByMovieIdMovie().getDurasi())
        );
        watchlistFavorite.setCellValueFactory(data -> new SimpleStringProperty(
                data.getValue().getFavorite()));
    }

    public void AddUserAction(ActionEvent actionEvent) throws IOException {

        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(cmbGenre.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("UTSSecondPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("modal");
        stage.setScene(scene);
        stage.showAndWait();
        refresh();

    }

    public void changeCombo(ActionEvent actionEvent) {

        movies.clear();
        MovieDao movieDao = new MovieDao();
        if (cmbGenre.getValue() == "All"){
            movies = FXCollections.observableArrayList(movieDao.getData());
        } else {
            String filterMovie = String.valueOf(cmbGenre.getValue());
            movies.addAll(movieDao.filterMovie(filterMovie));
        }
            table1.setItems(movies);

    }

    public void DelUserAction(ActionEvent actionEvent) {

        UserEntity selected = lvUser.getSelectionModel().getSelectedItem();
        System.out.println(selected);
        UserDao userDao = new UserDao();
        userDao.delData(selected);
        refresh();
        WatchListDao watchListDao = new WatchListDao();
        watchlists = FXCollections.observableArrayList(watchListDao.getData());
        table2.setItems(watchlists);

    }

    public void printReport(ActionEvent actionEvent) {

        JasperPrint jp;
        Connection conn = MyConnection.getConnection();
        Map param = new HashMap();
        try {
            jp = JasperFillManager.fillReport("reports/ListMovie.jasper",param,conn);
            JasperViewer viewer = new JasperViewer(jp,false);
            viewer.setTitle("List Movie");
            viewer.setVisible(true);
        } catch (JRException e) {
            throw new RuntimeException(e);
        }

    }

    public void selectedUser(MouseEvent mouseEvent) {

        watchlists.clear();
        WatchListDao watchListDao = new WatchListDao();
        UserEntity user = lvUser.getSelectionModel().getSelectedItem();
        watchlists.addAll(watchListDao.filterUser(user));
        table2.setItems(watchlists);

    }
}
