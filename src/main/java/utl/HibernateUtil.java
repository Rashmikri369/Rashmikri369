package utl;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import model.Destinations;
import model.Flights;
import model.Passengers;
import model.Users;

/**
 * Java based configuration
 * @author Balanarenthiran
 *
 */
public class HibernateUtil {
 private static SessionFactory sessionFactory;

 public static SessionFactory getSessionFactory() {
  if (sessionFactory == null) {
   try {
    Configuration configuration = new Configuration();

    // Hibernate settings equivalent to hibernate.cfg.xml's properties
    Properties settings = new Properties();
    settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
    settings.put(Environment.URL, "jdbc:mysql://localhost:3306/demo?useSSL=false");
    settings.put(Environment.USER, "root");
    settings.put(Environment.PASS, "password");
    settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

    settings.put(Environment.SHOW_SQL, "true");

    settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

    //settings.put(Environment.HBM2DDL_AUTO, "create-drop");
    settings.put(Environment.HBM2DDL_AUTO, "update");

    configuration.setProperties(settings);
    configuration.addAnnotatedClass(Flights.class);
    configuration.addAnnotatedClass(Passengers.class);
    configuration.addAnnotatedClass(Users.class);
    configuration.addAnnotatedClass(Destinations.class);

    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
      .applySettings(configuration.getProperties()).build();
    System.out.println("Hibernate Java Config serviceRegistry created");
    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    return sessionFactory;

   } catch (Exception e) {
    e.printStackTrace();
   }
  }
  return sessionFactory;
 }
}