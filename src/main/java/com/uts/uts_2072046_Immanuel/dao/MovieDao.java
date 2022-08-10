package com.uts.uts_2072046_Immanuel.dao;

import com.uts.uts_2072046_Immanuel.entity.MovieEntity;
import com.uts.uts_2072046_Immanuel.util.HiberUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class MovieDao implements DaoInterface<MovieEntity> {

    public List<MovieEntity> filterMovie(String genre){

        List listMovie;

        SessionFactory sf = HiberUtil.getSession();
        Session s = sf.openSession();

        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(MovieEntity.class);
        Root<MovieEntity> root = query.from(MovieEntity.class);

        Predicate p1 = builder.equal(root.get("genre"),genre);
        query.where(p1);

        listMovie = s.createQuery(query).getResultList();

        s.close();
        return listMovie;

    }

    @Override
    public List<MovieEntity> getData() {

        List listMovie;

        SessionFactory sf = HiberUtil.getSession();
        Session s = sf.openSession();

        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(MovieEntity.class);
        query.from(MovieEntity.class);
        listMovie = s.createQuery(query).getResultList();

        s.close();
        return listMovie;

    }

    @Override
    public void addData(MovieEntity data) {

    }

    @Override
    public void delData(MovieEntity data) {
    }

    @Override
    public void upData(MovieEntity data) {

    }

}
