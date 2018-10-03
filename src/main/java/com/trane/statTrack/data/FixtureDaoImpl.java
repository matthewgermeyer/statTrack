//package com.trane.statTrack.data;
//
//import com.trane.statTrack.model.Fixture;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//
//@Repository
//public class FixtureDaoImpl implements FixtureDao {
//  @Autowired
//  SessionFactory sessionFactory;
//
//  @Override
//  public List<Fixture> findAll() {
//    Session session = sessionFactory.openSession();
//
//    // DEPRECATED as of Hibernate 5.2.0
//    // List<Gif> gifs = session.createCriteria(Gif.class).list();
//
//    // Create CriteriaBuilder
//    CriteriaBuilder builder = session.getCriteriaBuilder();
//
//    // Create CriteriaQuery
//    CriteriaQuery<Fixture> criteria = builder.createQuery(Fixture.class);
//
//    // Specify criteria root
//    criteria.from(Fixture.class);
//
//    // Execute query
//    List<Fixture> fixtures = session.createQuery(criteria).getResultList();
//
//    session.close();
//    return fixtures;
//  }
//
//  @Override
//  public Fixture findById(Long id) {
//    Session session = sessionFactory.openSession();
//    session.getTransaction();
//    Fixture fix = session.get(Fixture.class, id);
//    session.close();
//    return fix;
//  }
//
//  @Override
//  public void save(Fixture fixture) {
//    Session session = sessionFactory.openSession();
//    session.getTransaction();
//    session.saveOrUpdate(fixture);
//    session.getTransaction().commit();
//    session.close();
//
//  }
//
//  @Override
//  public void delete(Fixture fixture) {
//    Session session = sessionFactory.openSession();
//    session.getTransaction();
//    session.delete(fixture);
//    session.getTransaction().commit();
//    session.close();
//
//  }
//}
