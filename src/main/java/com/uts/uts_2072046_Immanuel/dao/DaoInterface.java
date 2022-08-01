package com.uts.uts_2072046_Immanuel.dao;

import javafx.collections.ObservableList;

public interface DaoInterface<T> {

    public ObservableList<T> getData();
    int addData(T data);
    int delData(T data);
    int upData(T data);


}
