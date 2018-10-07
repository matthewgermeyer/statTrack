package com.trane.statTrack.service;

import com.trane.statTrack.data.DetailDAO;
import com.trane.statTrack.model.Detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailServiceImpl implements DetailService{
  @Autowired
  DetailDAO detailDAO;

  @Override
  public List<Detail> findAll() {
    return detailDAO.findAll();
  }

  @Override
  public Detail findById(Long id) {
    return detailDAO.findById(id);
  }

  @Override
  public Long save(Detail detail) {
     return detailDAO.save(detail);
  }

  @Override
  public void update(Detail detail) {
    detailDAO.update(detail);

  }

  @Override
  public void delete(Long id) {
    detailDAO.delete(id);

  }
}
