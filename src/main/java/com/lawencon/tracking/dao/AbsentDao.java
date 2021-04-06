package com.lawencon.tracking.dao;

import java.util.List;
import com.lawencon.tracking.model.Absent;

/**
 * @author : Galih Dika Permana
 */

public interface AbsentDao {

  List<Absent> getListAbsent() throws Exception;

  void insertData(Absent absent) throws Exception;

  public Absent getAbsentById(String id) throws Exception;

  void deleteAbsentById(Long id) throws Exception;

  void updateData(Absent absent) throws Exception;
}
