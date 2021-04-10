package com.lawencon.tracking.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.lawencon.tracking.dao.UserDao;
import com.lawencon.tracking.dto.UserAbsentInsertDto;
import com.lawencon.tracking.dto.UserAbsentUpdateDto;
import com.lawencon.tracking.dto.UserInsertDto;
import com.lawencon.tracking.model.Absent;
import com.lawencon.tracking.model.Role;
import com.lawencon.tracking.model.Users;
import com.lawencon.tracking.service.AbsentService;
import com.lawencon.tracking.service.UserService;

/**
 * @author : Galih Dika Permana
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Autowired
  private AbsentService absentService;

  @Override
  public List<Users> getListAbsent() throws Exception {
    return userDao.getListAbsent();
  }

  @Override
  public void insertData(UserInsertDto data) throws Exception {
    data.setPassword(passwordEncoder.encode(data.getPassword()));
    Users user = new Users();
    user.setCreatedAt(data.getCreatedAt());
    user.setCreatedBy(data.getCreatedBy());
    user.setEmail(data.getEmail());
    user.setFirstName(data.getFirstName());
    user.setLastName(data.getLastName());
    user.setUsername(data.getUsername());
    user.setPassword(data.getPassword());
    Role role = new Role();
    role.setId(data.getRoleId());
    user.setRole(role);
    userDao.insertData(user);
  }

  @Override
  public Users getUserById(String id) throws Exception {
    return userDao.getUserById(id);
  }

  @Override
  public void deleteUserById(Long id) throws Exception {
    userDao.deleteUserById(id);
  }

  @Override
  public void updateData(Users user) throws Exception {
    userDao.updateData(user);
  }

  @Override
  public Users getUserByUsername(String username) throws Exception {
    return userDao.getUserByUsername(username);
  }

  @Override
  public void insertUserAbsent(UserAbsentInsertDto data) throws Exception {
    Absent absent = new Absent();
    absent.setCreatedAt(data.getCreatedAt());
    absent.setCreatedBy(data.getCreatedBy());
    absent.setTimeIn(data.getTimeIn());
    absent.setTrxDate(data.getTrxDate());
    List<Absent> listAbsent = absentService.getListAbsent();
    absent.setTrxNumber("TRX - " + (listAbsent.size() + 1));
    Users user = new Users();
    user.setId(data.getUserId());
    absent.setUser(user);
    absentService.insertData(absent);
  }

  @Override
  public void updateDataAbsent(UserAbsentUpdateDto data) throws Exception {
    Absent absent = absentService.getAbsentById(data.getId());
    absent.setTimeOut(data.getTimeOut());
    absent.setUpdatedAt(data.getUpdateAt());
    absent.setUpdatedBy(data.getUpdateBy());
    absentService.updateData(absent);
  }

}
