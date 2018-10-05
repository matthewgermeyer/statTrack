package com.trane.statTrack.data;

import com.trane.statTrack.model.Detail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

@Repository
public class DetailDAOImpl implements DetailDAO {
  @Autowired
  private SessionFactory sessionFactory;

  public Detail findById(Long id) {
    Session session = sessionFactory.openSession();
    Detail detail = session.get(Detail.class, id);
    session.close();
    return detail;
  }

  public void update(Detail detail) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.update(detail);
    session.getTransaction().commit();
    session.close();
  }

  public Long save(Detail detail) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    Long id = (Long) session.save(detail);
    session.getTransaction().commit();
    session.close();
    return id;

  }

  public void delete(Long id) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.delete(findById(id));
    session.getTransaction().commit();
    session.close();

  }

  public List<Detail> findAll() {
    // Open a session
    Session session = sessionFactory.openSession();

    // UPDATED: Create CriteriaBuilder
    CriteriaBuilder builder = session.getCriteriaBuilder();

    // UPDATED: Create CriteriaQuery
    CriteriaQuery<Detail> criteria = builder.createQuery(Detail.class);

    // UPDATED: Specify criteria root
    criteria.from(Detail.class);

    // UPDATED: Execute query
    List<Detail> details = session.createQuery(criteria).getResultList();

    // Close the session
    session.close();

    return details;
  }
}
