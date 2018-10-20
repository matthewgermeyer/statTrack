package com.trane.statTrack.service;

import com.trane.statTrack.data.FixtureDAO;
import com.trane.statTrack.model.Fixture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FixtureServiceImpl implements FixtureService {
  @Autowired
  FixtureDAO fixtureDAO;
  @Override

  public List<Fixture> findAll() {
    return fixtureDAO.findAll();
  }

  @Override
  public void update(Fixture fixture) {
   fixtureDAO.update(fixture);
  }

  @Override
  public Fixture findById(Long id) {
  return fixtureDAO.findById(id);
  }

  @Override
  public void save(Fixture fixture) {
  fixtureDAO.save(fixture);

  }

  @Override
  public void delete(Long id) {
  fixtureDAO.delete(id);

  }

}
