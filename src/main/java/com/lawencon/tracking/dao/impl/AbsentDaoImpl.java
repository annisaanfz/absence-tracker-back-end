package com.lawencon.tracking.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.lawencon.tracking.dao.AbsentDao;
import com.lawencon.tracking.model.Absent;
import com.lawencon.tracking.repo.AbsentRepo;

/**
 * @author : Galih Dika Permana
 */
@Repository
public class AbsentDaoImpl implements AbsentDao {

  @Autowired
  private AbsentRepo absentRepo;
  @Override
  public List<Absent> getListAbsent() throws Exception {
    return absentRepo.findAll();
  }

  @Override
  public void insertData(Absent absent) throws Exception {
    absentRepo.save(absent);
  }

  @Override
  public Absent getAbsentById(String id) throws Exception {
    return absentRepo.findAbsentById(id);
  }

  @Override
  public void deleteAbsentById(Long id) throws Exception {
    absentRepo.deleteById(id);
  }

  @Override
  public void updateData(Absent absent) throws Exception {
    absentRepo.save(absent);
  }

}
