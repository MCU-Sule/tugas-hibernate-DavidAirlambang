package com.uts.uts_2072046_Immanuel.dao;

import com.uts.uts_2072046_Immanuel.entity.UserEntity;
import com.uts.uts_2072046_Immanuel.util.HiberUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class UserDao implements DaoInterface<UserEntity> {
    @Override
    public List<UserEntity> getData() {

        List listUser;

        SessionFactory sf = HiberUtil.getSession();
        Session s = sf.openSession();

        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(UserEntity.class);
        query.from(UserEntity.class);
        listUser = s.createQuery(query).getResultList();

        s.close();
        return listUser;

    }

    @Override
    public void addData(UserEntity data) {

        SessionFactory sf = HiberUtil.getSession();
        Session s = sf.openSession();
        s.save(data);
        s.close();

    }

    @Override
    public void delData(UserEntity data) {

        SessionFactory sf = HiberUtil.getSession();
        Session s = sf.openSession();
        Transaction transaction = s.beginTransaction();
        try {
            s.delete(data);
            transaction.commit();
        } catch(Exception e) {
            System.out.println(e);
            transaction.rollback();
        }
        s.close();

    }

    @Override
    public void upData(UserEntity data) {

    }

}
