package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Users;
import utl.HibernateUtil;

public class UserDao {

    
    /**
     * Get Available Flights
     * @return
     */
    //@SuppressWarnings("unchecked")    
    public boolean getSelectedUser(String un, String up) {

        Transaction transaction = null;
        Users user=null;
        boolean result=false;
        System.out.println("I'm in user dao");
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            Query query=session.createQuery("from Users where name=:username and password=:password");
            query.setParameter("username", un);
            query.setParameter("password", up);
            user=(Users)query.uniqueResult();
    	    if(user!=null) {
    		       System.out.println("username and password are valid");
    		       result=true;
    		    }else {
    		       System.out.println("username and password are not valid");
    		       result = false;
    		    }            
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * Get all Users
     * @return
     */
    @SuppressWarnings("unchecked")
    public List < Users > getAllUser() {

        Transaction transaction = null;
        List < Users > listOfUser = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            listOfUser = session.createQuery("from Users").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfUser;
    }

    /**
     * Get User By ID
     * @param id
     * @return
     */
    public Users getUser(int id) {

        Transaction transaction = null;
        Users user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            user = session.get(Users.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }

    /**
     * Update User
     * @param user
     */
	public void updateUser(int id, String up) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		
			Transaction txn = session.beginTransaction();
			// 1. fetch the object of specific employeeId - select query to be executed
			Users user = session.get(Users.class, id);
			System.out.println(user);
			System.out.println("inside update method");
			System.out.println(up);
			// 2. Modify employee exp - using setter method
			user.setPassword(up);
			System.out.println(user);
			// 3. send the object back
			session.update(user);
			txn.commit();
			//session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

	}	

	/**
     * Add New User
     * @param user
     */
	public void addUser(Users user) {
		Integer userId = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.beginTransaction();
		// save methods adds new row into database table
		userId = (Integer) session.save(user);
		txn.commit();
	}
	
}
