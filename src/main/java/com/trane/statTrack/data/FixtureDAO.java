package com.trane.statTrack.data;

import com.trane.statTrack.model.Fixture;

import java.util.List;

public interface FixtureDAO {

  Fixture findFixtureById(Long id);

  void update(Fixture fixture);

  Long saveFixture(Fixture fixture);

  void deleteFixtureById(Long id);

  List<Fixture> fetchAllFixtures();

}
