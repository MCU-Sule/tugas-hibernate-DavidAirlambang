package com.uts.uts_2072046_Immanuel.dao;

import com.uts.uts_2072046_Immanuel.entity.MovieEntity;

import java.util.List;

public interface DaoInterface<T> {

    public List<T> getData();
    void addData(T data);
    void delData(T data);
    void upData(T data);


}
