package com.lawencon.tracking.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lawencon.tracking.dao.RoleDao;
import com.lawencon.tracking.model.Role;
import com.lawencon.tracking.service.RoleService;

/**
 * @author : Galih Dika Permana
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

  @Autowired
  private RoleDao roleDao;

  @Override
  public List<Role> getListAbsent() throws Exception {
    return roleDao.getListAbsent();
  }

  @Override
  public void insertData(Role role) throws Exception {
    roleDao.insertData(role);
  }

  @Override
  public Role getRoleById(String id) throws Exception {
    return roleDao.getRoleById(id);
  }

  @Override
  public void deleteRoleById(Long id) throws Exception {
    roleDao.deleteRoleById(id);
  }

  @Override
  public void updateData(Role role) throws Exception {
    roleDao.updateData(role);
  }
}
