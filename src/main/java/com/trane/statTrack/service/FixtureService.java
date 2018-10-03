package com.trane.statTrack.service;

import com.trane.statTrack.model.Fixture;

import java.util.List;


public interface FixtureService {
  List<Fixture> findAll();
  Fixture findById(Long id);
  void save(Fixture fixture);
  void delete(Fixture fixture);

}
