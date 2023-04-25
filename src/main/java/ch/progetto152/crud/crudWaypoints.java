package ch.progetto152.crud;

import ch.progetto152.entity.Waypoints;
import ch.progetto152.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class crudWaypoints {

    private Session session;

    public crudWaypoints(Session session) {
        this.session = session;
    }

    public void create(Waypoints Waypoints) {
        Transaction tx = session.beginTransaction();
        session.save(Waypoints);
        tx.commit();
    }

    public Waypoints read(int index) {
        Session asd = HibernateUtils.getSessionFactory().openSession();
        Waypoints Waypoints = asd.get(Waypoints.class, index);
        return Waypoints;
    }

    public Waypoints readWaypointsByName(String name) {
        Session asd = HibernateUtils.getSessionFactory().openSession();
        Waypoints Waypoints = (Waypoints) asd.createQuery("from Waypoints where name = :name").setParameter("name", name).uniqueResult();
        return Waypoints;
    }

    public void update(int id, Waypoints waypoints) {
        Transaction tx = session.beginTransaction();
        Waypoints Waypoints = session.get(Waypoints.class, id);
        session.evict(Waypoints);
        Waypoints.setId(waypoints.getId());
        Waypoints.setName(waypoints.getName());
        Waypoints.setLat(waypoints.getLat());
        Waypoints.setLon(waypoints.getLon());
        Waypoints.setDescription(waypoints.getDescription());
        Waypoints.setImg(waypoints.getImg());
        session.update(Waypoints);
        tx.commit();
    }

    public void delete(int id) {
        Transaction tx = session.beginTransaction();
        Waypoints Waypoints = session.get(Waypoints.class, id);
        session.delete(Waypoints);
        tx.commit();
    }

    public List<Waypoints> readAll() {
        return session.createQuery("from Waypoints").list();
    }
}