package com.trane.statTrack.data;

import com.trane.statTrack.model.Fixture;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;


public class FixtureDaoImpl implements FixtureDAO {
  SessionFactory sessionFactory;

  public Fixture findFixtureById(Long id) {
    Session session = sessionFactory.openSession();
    Fixture fixture = session.get(Fixture.class, id);
    session.close();
    return fixture;
  }

  public void update(Fixture fixture) {
   Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.update(fixture);
    session.getTransaction().commit();
    session.close();
  }

  public Long saveFixture(Fixture fixture) {
   Session  session = sessionFactory.openSession();
    session.beginTransaction();
    Long id = (Long)session.save(fixture);
    session.getTransaction().commit();
    session.close();
    return id;

  }

  public void deleteFixtureById(Long id) {
   Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.delete(findFixtureById(id));
    session.getTransaction().commit();
    session.close();

  }

  public List<Fixture> fetchAllFixtures() {

    Session session = sessionFactory.openSession();
    CriteriaBuilder builder = session.getCriteriaBuilder();
    CriteriaQuery<Fixture> criteria = builder.createQuery(Fixture.class);
    criteria.from(Fixture.class);
    List<Fixture> fixtures = session.createQuery(criteria).getResultList();
    session.close();

    return fixtures;
  }
}
