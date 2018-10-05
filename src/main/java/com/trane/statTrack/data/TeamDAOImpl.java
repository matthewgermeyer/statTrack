package com.trane.statTrack.data;

import com.trane.statTrack.model.Team;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

@Repository
public class TeamDAOImpl implements TeamDAO{
  @Autowired
  private SessionFactory sessionFactory;

  public Team findById(Long id) {
    Session session = sessionFactory.openSession();
    Team team = session.get(Team.class, id);
    session.close();
    return team;
  }

  public void update(Team team) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.update(team);
    session.getTransaction().commit();
    session.close();
  }

  public Long save(Team team) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    Long id = (Long)session.save(team);
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

  public List<Team> findAll() {
    // Open a session
    Session session = sessionFactory.openSession();

    // UPDATED: Create CriteriaBuilder
    CriteriaBuilder builder = session.getCriteriaBuilder();

    // UPDATED: Create CriteriaQuery
    CriteriaQuery<Team> criteria = builder.createQuery(Team.class);

    // UPDATED: Specify criteria root
    criteria.from(Team.class);

    // UPDATED: Execute query
    List<Team> teams = session.createQuery(criteria).getResultList();

    // Close the session
    session.close();

    return teams;
  }
}
