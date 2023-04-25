package ch.progetto152.crud;

import ch.progetto152.entity.Location;
import ch.progetto152.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class crudLocation {

    private Session session;

    public crudLocation(Session session) {
        this.session = session;
    }

    public void create(Location Location) {
        Transaction tx = session.beginTransaction();
        session.save(Location);
        tx.commit();
    }

    public Location read(int index) {
        Session asd = HibernateUtils.getSessionFactory().openSession();
        Location Location = asd.get(Location.class, index);
        return Location;
    }

    public Location readLocationByName(String name) {
        Session asd = HibernateUtils.getSessionFactory().openSession();
        Location Location = (Location) asd.createQuery("from Location where name = :name").setParameter("name", name).uniqueResult();
        return Location;
    }

    public void update(int id, Location location) {
        Transaction tx = session.beginTransaction();
        Location Location = session.get(Location.class, id);
        session.evict(Location);
        Location.setId(location.getId());
        Location.setLocation(location.getLocation());
        Location.setRegion(location.getRegion());
        Location.setLat(location.getLat());
        Location.setLon(location.getLon());
        session.update(Location);
        tx.commit();
    }

    public void delete(int id) {
        Transaction tx = session.beginTransaction();
        Location Location = session.get(Location.class, id);
        session.delete(Location);
        tx.commit();
    }

    public List<Location> readAll() {
        return session.createQuery("from Location").list();
    }
}