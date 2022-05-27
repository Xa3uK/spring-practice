package org.fishbone.dao;

import java.util.List;
import java.util.Optional;
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
        Session session = sessionFactory.getCurrentSession();

        List<Person> people = session.createQuery("select p from Person p", Person.class).getResultList();
        return people;
    }

    @Transactional
    public Person show(int id) {
        return sessionFactory.getCurrentSession().get(Person.class, id);
    }

    public Optional<Person> show(String email) {
        return null;
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
        Person person = sessionFactory.getCurrentSession().get(Person.class, id);
        sessionFactory.getCurrentSession().delete(person);
    }
}
