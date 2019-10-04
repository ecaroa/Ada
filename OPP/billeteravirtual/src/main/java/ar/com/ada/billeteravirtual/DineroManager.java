package ar.com.ada.billeteravirtual;

import java.util.*;
import java.util.logging.Level;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * DineroManager
 */
public class DineroManager {

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

    protected void create(Dinero dinero) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(dinero);
  
        session.getTransaction().commit();
        session.close();
    }

    public Dinero read(int dineroId) {
        Session session = sessionFactory.openSession();

        Dinero dinero = session.get(Dinero.class, dineroId);

        session.close();

        return dinero;
    }

    protected void update(Dinero dinero) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(dinero);

        session.getTransaction().commit();
        session.close();
    }

    protected void delete(Dinero dinero) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(dinero);

        session.getTransaction().commit();
        session.close();
    }

    /**
     * Este metodo en la vida real no debe existir ya qeu puede haber miles de usuarios
     * @return
     */
    public List<Dinero> buscarTodos() {

        Session session = sessionFactory.openSession();

        ///NUNCA HARCODEAR SQLs nativos en la aplicacion.
        //ESTO es solo para nivel educativo
        Query query = session.createNativeQuery("SELECT * FROM dinero", Dinero.class);

        List<Dinero> todos = query.getResultList();

        return todos;

    }
}