package com.lawencon.tracking.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.lawencon.tracking.dao.UserDao;
import com.lawencon.tracking.model.Users;
import com.lawencon.tracking.repo.UserRepo;
/**
 * @author : Galih Dika Permana
 */
@Repository
public class UserDaoImpl implements UserDao {

  @Autowired
  private UserRepo userRepo;
  @Override
  public List<Users> getListAbsent() throws Exception {
    return userRepo.findAll();
  }

  @Override
  public void insertData(Users user) throws Exception {
    userRepo.save(user);
  }

  @Override
  public Users getUserById(String id) throws Exception {
    return userRepo.findUserById(id);
  }

  @Override
  public void deleteUserById(Long id) throws Exception {
    userRepo.deleteById(id);

  }

  @Override
  public void updateData(Users user) throws Exception {
    userRepo.save(user);
  }

  @Override
  public Users getUserByUsername(String username) throws Exception {
    return userRepo.findByUsername(username);
  }

}
