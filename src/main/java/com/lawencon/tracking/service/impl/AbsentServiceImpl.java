package com.lawencon.tracking.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lawencon.tracking.dao.AbsentDao;
import com.lawencon.tracking.model.Absent;
import com.lawencon.tracking.service.AbsentService;

/**
 * @author : Galih Dika Permana
 */
@Service
@Transactional
public class AbsentServiceImpl implements AbsentService {

  @Autowired
  private AbsentDao absentDao;

  @Override
  public List<Absent> getListAbsent() throws Exception {
    return absentDao.getListAbsent();
  }

  @Override
  public void insertData(Absent absent) throws Exception {
    absentDao.insertData(absent);
  }

  @Override
  public Absent getAbsentById(String id) throws Exception {
    return absentDao.getAbsentById(id);
  }

  @Override
  public void deleteAbsentById(Long id) throws Exception {
    absentDao.deleteAbsentById(id);
  }

  @Override
  public void updateData(Absent absent) throws Exception {
    absentDao.updateData(absent);
  }

}
