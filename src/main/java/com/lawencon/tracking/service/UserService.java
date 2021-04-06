package com.lawencon.tracking.service;

import java.util.List;
import com.lawencon.tracking.dto.UserAbsentInsertDto;
import com.lawencon.tracking.dto.UserAbsentUpdateDto;
import com.lawencon.tracking.dto.UserInsertDto;
import com.lawencon.tracking.model.Users;

/**
 * @author : Galih Dika Permana
 */

public interface UserService {

  List<Users> getListAbsent() throws Exception;

  void insertData(UserInsertDto user) throws Exception;

  public Users getUserById(String id) throws Exception;

  void deleteUserById(Long id) throws Exception;

  void updateData(Users user) throws Exception;

  public Users getUserByUsername(String username) throws Exception;

  void insertUserAbsent(UserAbsentInsertDto data) throws Exception;

  void updateDataAbsent(UserAbsentUpdateDto data) throws Exception;
}
