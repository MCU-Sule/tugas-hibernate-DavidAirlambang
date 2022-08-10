package com.uts.uts_2072046_Immanuel.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HiberUtil {

    public  static SessionFactory getSession(){
     SessionFactory sf = new Configuration().configure().buildSessionFactory();
     return sf;
    }

}
