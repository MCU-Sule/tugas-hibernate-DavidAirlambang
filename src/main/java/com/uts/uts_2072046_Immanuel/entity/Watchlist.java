package com.uts.uts_2072046_Immanuel.entity;

public class Watchlist {

    private int idWatchList;
    private int lastWatch;
    private int favorite;
    private Movie movie;
    private User user;

    @Override
    public String toString() {
        String balikin;
        if (favorite == 0){
            balikin = "false";
        } else {
            balikin = "true";
        }
        return balikin;
    }

    public Watchlist(int idWatchList, int lastWatch, int favorite, Movie movie, User user) {
        this.idWatchList = idWatchList;
        this.lastWatch = lastWatch;
        this.favorite = favorite;
        this.movie = movie;
        this.user = user;
    }

    public int getIdWatchList() {
        return idWatchList;
    }

    public void setIdWatchList(int idWatchList) {
        this.idWatchList = idWatchList;
    }

    public int getLastWatch() {
        return lastWatch;
    }

    public void setLastWatch(int lastWatch) {
        this.lastWatch = lastWatch;
    }

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
