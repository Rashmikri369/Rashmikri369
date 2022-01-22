package dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Flights;
import model.Users;
import utl.HibernateUtil;

public class FlightsDao {

    /**
     * Get all Flights
     * @return
     */
    @SuppressWarnings("unchecked")
    public List < Flights > getAllFlights() {

        Transaction transaction = null;
        List < Flights > listOfFlights = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            listOfFlights = session.createQuery("from Flights").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfFlights;
    }

    /**
     * Get Available Flights
     * @return
     */
    @SuppressWarnings("unchecked")    
    public List < Flights > getFlights(String src, String des, Date dt) {

        Transaction transaction = null;
        List < Flights > listOfFlights = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            //listOfFlights = session.createQuery("from Flights where source=:source").getResultList();
            Query query = session.createQuery("from Flights where source=:source and destination=:destination and date(date)=:date");
            query.setCacheable(true);
            query.setParameter("source", src);
            query.setParameter("destination", des);
            query.setParameter("date", dt);
            listOfFlights = query.list();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfFlights;
    }
    
    /**
     * Get Available Flights
     * @return
     */
    @SuppressWarnings("unchecked")    
    public List < Flights > getSelectedFlight(int fid) {

        Transaction transaction = null;
        List < Flights > listOfFlights = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            //listOfFlights = session.createQuery("from Flights where source=:source").getResultList();
            Query query = session.createQuery("from Flights where id=:fid");
            query.setCacheable(true);
            query.setParameter("fid", fid);
            listOfFlights = query.list();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfFlights;
    }
    /**
     * Get Flight Fare By Flight ID
     * @param fid
     * @return
     */
    public Flights getFlgihtFare(int fid) {

        Transaction transaction = null;
        Flights flights = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            flights = session.get(Flights.class, fid);
            int ff = flights.getTicketprice();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return flights;
    }
    /**
     * Update User
     * @param user
     */
    public void updateFlight(Flights flight) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(flight);
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
     * Add New Flight
     * @param flight
     */
	public void addFlight(Flights flight) {
		Integer flightId = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.beginTransaction();
		// save methods adds new row into database table
		flightId = (Integer) session.save(flight);
		txn.commit();
	}
}
