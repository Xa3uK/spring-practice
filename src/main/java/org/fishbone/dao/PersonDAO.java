package org.fishbone.dao;

import java.util.List;
import java.util.Optional;
import javax.persistence.Query;
import org.fishbone.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PersonDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Person> index() {
        return sessionFactory.getCurrentSession().createQuery("select p from Person p", Person.class).getResultList();
    }

    @Transactional(readOnly = true)
    public Person show(int id) {
        return sessionFactory.getCurrentSession().get(Person.class, id);
    }

    @Transactional(readOnly = true)
    public Person show(String email) {
//        Query query = sessionFactory.getCurrentSession().createQuery("from Person p where p.email= :email");
//       query.setParameter("email", email);
//       List persons = query.getResultList();
//       return (Person) persons.get(0);
    }

    @Transactional
    public void save(Person person) {
        sessionFactory.getCurrentSession().save(person);
    }

    @Transactional
    public void update(int id, Person personUpdated) {
        sessionFactory.getCurrentSession().update(personUpdated);
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(Person.class, id));
    }
}
