package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Destinations;
import utl.HibernateUtil;

public class DestinationsDao {

    /**
     * Get all Users
     * @return
     */
    @SuppressWarnings("unchecked")
    public List < Destinations > getAllDestintions() {

        Transaction transaction = null;
        List < Destinations > listOfDestinations = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            listOfDestinations = session.createQuery("from Destinations").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfDestinations;
    }
    /**
     * Get Destination By Destination ID
     * @param did
     * @return
     */
    public Destinations getDestination(int did) {

        Transaction transaction = null;
        Destinations destinations = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            destinations = session.get(Destinations.class, did);
            
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return destinations;
    }
    /**
     * Update Destination
     * @param did
     */
	public void updateDestination(int did, String ud) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		
			Transaction txn = session.beginTransaction();
			// 1. fetch the object of specific employeeId - select query to be executed
			Destinations destination = session.get(Destinations.class, did);
			destination.setDestination(ud);
			// 3. send the object back
			session.update(destination);
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
     * Add New Destination
     * @param destination
     */
	public void addDestination(Destinations destination) {
		Integer destinationId = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.beginTransaction();
		// save methods adds new row into database table
		destinationId = (Integer) session.save(destination);
		txn.commit();
	}
}
