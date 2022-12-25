package com.notetaker.helper;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.notetaker.entitites.Users;

public class UserDao {

	public boolean saveUser(Users user) {

		boolean save = false;

		Transaction transaction = null;

		try {

			Session s = FactoryProvider.getFactory().openSession();
			transaction = s.beginTransaction();
			s.save(user);
			transaction.commit();

			save = true;

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return save;

	}

	public Users validate(String email, String password) {
        Session s=FactoryProvider.getFactory().openSession();
        Transaction tx = null;
        Users user = null;
        try {
            tx = s.getTransaction();
            tx.begin();
            Query query = s.createQuery("FROM users U WHERE U.email = :email and U.password =:password", Users.class);
            query.setParameter("email", email);
            query.setParameter("password", password);
            user = (Users) ((org.hibernate.query.Query<Users>) query).uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            s.close();
        }
        return user;
    }


		

}
