package ch.progetto152.crud;

import ch.progetto152.entity.User;
import ch.progetto152.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class crudUser {

    private Session session;

    public crudUser(Session session) {
        this.session = session;
    }

    public void create(User User) {
        Transaction tx = session.beginTransaction();
        session.save(User);
        tx.commit();
    }

    public User read(int index) {
        Session asd = HibernateUtils.getSessionFactory().openSession();
        User User = asd.get(User.class, index);
        return User;
    }

    public User readUserByName(String name) {
        Session asd = HibernateUtils.getSessionFactory().openSession();
        User User = (User) asd.createQuery("from User where name = :name").setParameter("name", name).uniqueResult();
        return User;
    }

    public void update(int id, User user) {
        Transaction tx = session.beginTransaction();
        User User = session.get(User.class, id);
        session.evict(User);
        User.setId(user.getId());
        User.setName(user.getName());
        User.setUsername(user.getUsername());
        User.setPassword(user.getPassword());
        session.update(User);
        tx.commit();
    }

    public void delete(int id) {
        Transaction tx = session.beginTransaction();
        User User = session.get(User.class, id);
        session.delete(User);
        tx.commit();
    }

    public List<User> readAll() {
        return session.createQuery("from User").list();
    }
}