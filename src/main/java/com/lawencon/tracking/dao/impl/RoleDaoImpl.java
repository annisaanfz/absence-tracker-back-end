package com.lawencon.tracking.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.lawencon.tracking.dao.RoleDao;
import com.lawencon.tracking.model.Role;
import com.lawencon.tracking.repo.RoleRepo;

/**
 * @author : Galih Dika Permana
 */
@Repository
public class RoleDaoImpl implements RoleDao {

  @Autowired
  private RoleRepo roleRepo;
  @Override
  public List<Role> getListAbsent() throws Exception {
    return roleRepo.findAll();
  }

  @Override
  public void insertData(Role role) throws Exception {
    roleRepo.save(role);
  }

  @Override
  public Role getRoleById(String id) throws Exception {
    return roleRepo.findRoleById(id);
  }

  @Override
  public void deleteRoleById(Long id) throws Exception {
    roleRepo.deleteById(id);
  }

  @Override
  public void updateData(Role role) throws Exception {
    roleRepo.save(role);
  }

}
