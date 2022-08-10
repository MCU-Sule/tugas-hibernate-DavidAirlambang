package com.uts.uts_2072046_Immanuel.dao;

import com.uts.uts_2072046_Immanuel.entity.*;
import com.uts.uts_2072046_Immanuel.util.HiberUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class WatchListDao implements DaoInterface<WatchlistEntity> {

    public List<WatchlistEntity> filterUser(UserEntity user){

        List listWatchlist;

        SessionFactory sf = HiberUtil.getSession();
        Session s = sf.openSession();

        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(WatchlistEntity.class);
        Root<UserEntity> root = query.from(WatchlistEntity.class);

        Predicate p1 = builder.equal(root.get("userByUserIdUser"),user);
        query.where(p1);

        listWatchlist = s.createQuery(query).getResultList();

        s.close();
        return listWatchlist;

    }

    @Override
    public List<WatchlistEntity> getData() {

        List listWatchlist;

        SessionFactory sf = HiberUtil.getSession();
        Session s = sf.openSession();

        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(WatchlistEntity.class);
        query.from(WatchlistEntity.class);
        listWatchlist = s.createQuery(query).getResultList();

        s.close();
        return listWatchlist;

    }

    @Override
    public void addData(WatchlistEntity data) {

    }

    @Override
    public void delData(WatchlistEntity data) {

    }

    @Override
    public void upData(WatchlistEntity data) {

    }

//    public ObservableList<Watchlist> filterUser(int filterId){
//
//        ObservableList<Watchlist> listWatchlist = FXCollections.observableArrayList();
//        Connection conn = MyConnection.getConnection();
//        String query = "select * from watchlist \n" +
//                "inner join movie on Movie_idMovie = idMovie\n" +
//                "inner join user on User_idUser = idUser\n" +
//                "where idUser =" + filterId;
//        PreparedStatement ps;
//        try {
//            ps = conn.prepareStatement(query);
//            ResultSet result = ps.executeQuery();
//            while (result.next()) {
//                int idWatchList = result.getInt("idWatchList");
//                int lastwatch = result.getInt("LastWatch");
//                int favorite = result.getInt("Favorite");
//
//                int idMovie = result.getInt("Movie_idMovie");
//                String title = result.getString("Title");
//                String genre = result.getString("Genre");
//                int durasi = result.getInt("Durasi");
//                Movie movies = new Movie(idMovie,title,genre,durasi);
//
//                int idUser = result.getInt("User_idUser");
//                String username = result.getString("UserName");
//                String password = result.getString("UserPassword");
//                User users = new User(idUser,username,password);
//
//                Watchlist watchlists = new Watchlist(idWatchList,lastwatch,favorite,movies,users);
//                listWatchlist.add(watchlists);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return listWatchlist;
//    }
//
//    @Override
//    public List<MovieEntity> getData() {
//
//        ObservableList<Watchlist> listWatchlist = FXCollections.observableArrayList();
//        Connection conn = MyConnection.getConnection();
//        String query = "select * from watchlist \n" +
//                "inner join movie on Movie_idMovie = idMovie\n" +
//                "inner join user on User_idUser = idUser";
//        PreparedStatement ps;
//        try {
//            ps = conn.prepareStatement(query);
//            ResultSet result = ps.executeQuery();
//            while (result.next()) {
//                int idWatchList = result.getInt("idWatchList");
//                int lastwatch = result.getInt("LastWatch");
//                int favorite = result.getInt("Favorite");
//
//                int idMovie = result.getInt("Movie_idMovie");
//                String title = result.getString("Title");
//                String genre = result.getString("Genre");
//                int durasi = result.getInt("Durasi");
//                Movie movies = new Movie(idMovie,title,genre,durasi);
//
//                int idUser = result.getInt("User_idUser");
//                String username = result.getString("UserName");
//                String password = result.getString("UserPassword");
//                User users = new User(idUser,username,password);
//
//                Watchlist watchlists = new Watchlist(idWatchList,lastwatch,favorite,movies,users);
//                listWatchlist.add(watchlists);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return listWatchlist;
//    }
//
//    @Override
//    public int addData(Watchlist data) {
//
//        int result = 0;
//        Connection conn = MyConnection.getConnection();
//        String query = "insert into watchlist values (?,?,?,?,?)";
//        PreparedStatement ps;
//        try {
//            ps = conn.prepareStatement(query);
//            ps.setInt(1,data.getIdWatchList());
//            ps.setInt(2,data.getLastWatch());
//            ps.setInt(3,data.getFavorite());
//            ps.setInt(4,data.getMovie().getIdMovie());
//            ps.setInt(5,data.getUser().getIdUser());
//            result = ps.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return result;
//
//    }
//
//    @Override
//    public int delData(Watchlist data) {
//
//        int result = 0;
//        Connection conn = MyConnection.getConnection();
//        String query = "delete from watchlist where idWatchList = ?";
//        PreparedStatement ps;
//        try {
//            ps = conn.prepareStatement(query);
//            ps.setInt(1,data.getIdWatchList());
//            result = ps.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return result;
//
//    }
//
//    @Override
//    public int upData(Watchlist data) {
//
//        int result = 0;
//        Connection conn = MyConnection.getConnection();
//        String query = "update watchlist set LastWatch=?, Favorite=?, Movie_idMovie=?," +
//                "User_idUser=? where idWatchList = ?";
//        PreparedStatement ps;
//        try {
//            ps = conn.prepareStatement(query);
//            ps.setInt(1,data.getLastWatch());
//            ps.setInt(2,data.getFavorite());
//            ps.setInt(3,data.getMovie().getIdMovie());
//            ps.setInt(4,data.getUser().getIdUser());
//            ps.setInt(5,data.getIdWatchList());
//            result = ps.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return result;
//
//    }
}
