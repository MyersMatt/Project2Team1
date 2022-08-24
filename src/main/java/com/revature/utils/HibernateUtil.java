package com.revature.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HibernateUtil {
    private static HibernateUtil hibernateUtil = null;
    private SessionFactory sessionFactory = null;

    private Session session = null;
    private HibernateUtil(){
        try {
            Class.forName("org.postgresql.Driver");
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static HibernateUtil getInstance(){
        if(hibernateUtil == null) hibernateUtil = new HibernateUtil();
        return hibernateUtil;
    }
    public Session openSession(){
        if(session == null) session = sessionFactory.openSession();
        return session;
    }

    public void closeSession(){
        if(session == null) return;
        session.close();
        session = null;
    }
}
