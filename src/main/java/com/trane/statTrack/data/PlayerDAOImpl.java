package com.trane.statTrack.data;

import com.trane.statTrack.model.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class PlayerDAOImpl implements PlayerDAO {
  SessionFactory sessionFactory;

  public Player findPlayerById(Long id) {
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

  public Long savePlayer(Player player) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    Long id = (Long)session.save(player);
    session.getTransaction().commit();
    session.close();
    return id;

  }

  public void deletePlayerById(Long id) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.delete(findPlayerById(id));
    session.getTransaction().commit();
    session.close();

  }

  public List<Player> fetchAllPlayers() {
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
