package com.trane.statTrack.service;

import com.trane.statTrack.model.Fixture;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class FixtureServiceImpl implements FixtureService {
  @Override
  public List<Fixture> findAll() {
    List<Fixture> fixtures = Arrays.asList(
        Fixture.generateNorthLondonDerby());
    return fixtures;
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
