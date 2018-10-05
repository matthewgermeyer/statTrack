package com.trane.statTrack.data;

import com.trane.statTrack.model.Fixture;

import java.util.List;

public interface FixtureDAO {

  Fixture findById(Long id);

  void update(Fixture fixture);

  Long save(Fixture fixture);

  void delete(Long id);

  List<Fixture> findAll();

}
