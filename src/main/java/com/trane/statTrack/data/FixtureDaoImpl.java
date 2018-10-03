package com.trane.statTrack.data;

import com.trane.statTrack.model.Fixture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FixtureDaoImpl extends FixtureDao {
  @Autowired
  SessionFactory sessionFactory;

  @Override
  public List<Fixture> findAll() {
    return null;
  }

  @Override
  public Fixture findById(Long id) {
    return null;
  }

  @Override
  public void save(Fixture fixture) {

  }

  @Override
  public void delete(Fixture fixture) {

  }
}
