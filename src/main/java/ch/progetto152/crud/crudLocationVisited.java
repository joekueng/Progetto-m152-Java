package ch.progetto152.crud;

import ch.progetto152.entity.LocationVisited;
import ch.progetto152.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class crudLocationVisited {

    private Session session;

    public crudLocationVisited(Session session) {
        this.session = session;
    }

    public void create(LocationVisited LocationVisited) {
        Transaction tx = session.beginTransaction();
        session.save(LocationVisited);
        tx.commit();
    }

    public LocationVisited read(int index) {
        Session asd = HibernateUtils.getSessionFactory().openSession();
        LocationVisited LocationVisited = asd.get(LocationVisited.class, index);
        return LocationVisited;
    }

    public LocationVisited readLocationVisitedByName(String name) {
        Session asd = HibernateUtils.getSessionFactory().openSession();
        LocationVisited LocationVisited = (LocationVisited) asd.createQuery("from LocationVisited where name = :name").setParameter("name", name).uniqueResult();
        return LocationVisited;
    }

    public void update(int id, LocationVisited locationVisited) {
        Transaction tx = session.beginTransaction();
        LocationVisited LocationVisited = session.get(LocationVisited.class, id);
        session.evict(LocationVisited);
        LocationVisited.setId(locationVisited.getId());
        LocationVisited.setLocationid(locationVisited.getLocationid());
        LocationVisited.setUserId(locationVisited.getUserId());
        session.update(LocationVisited);
        tx.commit();
    }

    public void delete(int id) {
        Transaction tx = session.beginTransaction();
        LocationVisited LocationVisited = session.get(LocationVisited.class, id);
        session.delete(LocationVisited);
        tx.commit();
    }

    public List<LocationVisited> readAll() {
        return session.createQuery("from LocationVisited").list();
    }
}