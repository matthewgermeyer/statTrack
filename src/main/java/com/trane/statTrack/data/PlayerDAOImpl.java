package com.trane.statTrack.data;

import com.trane.statTrack.model.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

@Repository
public class PlayerDAOImpl implements PlayerDAO {
  @Autowired
  private SessionFactory sessionFactory;

  public Player findById(Long id) {
    Session session = sessionFactory.openSession();
    Player player = session.get(Player.class, id);
    session.close();
    return player;
  }

  public void update(Player player) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.update(player);
    session.getTransaction().commit();
    session.close();
  }

  public void save(Player player) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.saveOrUpdate(player);
    session.getTransaction().commit();
    session.close();

  }

  public void delete(Long id) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.delete(findById(id));
    session.getTransaction().commit();
    session.close();

  }

  public List<Player> findAll() {
    // Open a session
    Session session = sessionFactory.openSession();

    // UPDATED: Create CriteriaBuilder
    CriteriaBuilder builder = session.getCriteriaBuilder();

    // UPDATED: Create CriteriaQuery
    CriteriaQuery<Player> criteria = builder.createQuery(Player.class);

    // UPDATED: Specify criteria root
    criteria.from(Player.class);

    // UPDATED: Execute query
    List<Player> players = session.createQuery(criteria).getResultList();

    // Close the session
    session.close();

    return players;
  }
}
