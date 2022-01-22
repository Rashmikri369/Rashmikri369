package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Passengers;
import utl.HibernateUtil;

/**
 * CRUD database operations
 * @author Bala
 *
 */
public class PassengerDao {

    /**
     * Save Passengers
     * @param passengers
     */
    public void saveUser(Passengers passengers) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(passengers);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Get Available Flights
     * @return
     */
    @SuppressWarnings("unchecked")    
    public List < Passengers > getPassengerDetails(String pnr) {

        Transaction transaction = null;
        List < Passengers > listOfPassengers = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            //listOfFlights = session.createQuery("from Flights where source=:source").getResultList();
            Query query = session.createQuery("from Passengers where pnr=:pnr");
            query.setCacheable(true);
            query.setParameter("pnr", pnr);
            listOfPassengers = query.list();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfPassengers;
    }

}