package com.trane.statTrack.service;

import com.trane.statTrack.model.Detail;

import java.util.List;

public interface DetailService {
  List<Detail> findAll();
  Detail findById(Long id);
  Long save(Detail detail);
  void delete(Long id);
  void update(Detail detail);
}
