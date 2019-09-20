package ar.com.ada.billeteravirtual;
import java.util.List;
import java.util.logging.Level;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * BilleteraManager
 */
public class BilleteraManager {

    protected SessionFactory sessionFactory;

    protected void setup() {

        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // configures settings
                                                                                                  // from
                                                                                                  // hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw ex;
        }

    }

    protected void exit() {
        sessionFactory.close();
    }

    protected void create(Billetera billetera) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(billetera);

        session.getTransaction().commit();
        session.close();
    }

    public Billetera read(int billeteraId) {
        Session session = sessionFactory.openSession();

        Billetera billetera = session.get(Billetera.class, billeteraId);

        session.close();

        return billetera;
    }

    protected void update(Billetera billetera) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(billetera);

        session.getTransaction().commit();
        session.close();
    }

    protected void delete(Billetera billetera) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(billetera);

        session.getTransaction().commit();
        session.close();
    }
}