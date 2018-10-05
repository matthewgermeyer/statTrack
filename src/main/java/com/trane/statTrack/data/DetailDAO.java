package com.trane.statTrack.data;

import com.trane.statTrack.model.Detail;

import java.util.List;

public interface DetailDAO {
  List<Detail> findAll();
  Detail findById(Long id);
  Long save(Detail detail);
  void update(Detail detail);
  void delete(Long id);
}
