package com.trane.statTrack.service;

import com.trane.statTrack.data.FixtureDao;
import com.trane.statTrack.model.Fixture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FixtureServiceImpl implements FixtureService {
  @Autowired
  FixtureDao fixtureDao;

  @Override
  public List<Fixture> findAll() {
    return fixtureDao.findAll();
  }

  @Override
  public Fixture findById(Long id) {
    return fixtureDao.findById(id);
  }

  @Override
  public void save(Fixture fixture) {
    fixtureDao.save(fixture);

  }

  @Override
  public void delete(Fixture fixture) {
    fixtureDao.delete(fixture);
  }
}
