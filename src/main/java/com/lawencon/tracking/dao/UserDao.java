package com.lawencon.tracking.dao;

import java.util.List;
import com.lawencon.tracking.model.Users;

/**
 * @author : Galih Dika Permana
 */

public interface UserDao {

  List<Users> getListAbsent() throws Exception;

  void insertData(Users user) throws Exception;

  public Users getUserById(String id) throws Exception;

  void deleteUserById(Long id) throws Exception;

  void updateData(Users user) throws Exception;

  public Users getUserByUsername(String username) throws Exception;
}
