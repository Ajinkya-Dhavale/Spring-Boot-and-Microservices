package com.login.dao;

import com.login.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    // 🔹 SAVE USER
    @Transactional
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    // 🔹 FIND USER BY USERNAME
    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query<User> query = session
                .createQuery(
                    "FROM User WHERE username = :uname",
                    User.class)
                .setParameter("uname", username);

            return query.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
