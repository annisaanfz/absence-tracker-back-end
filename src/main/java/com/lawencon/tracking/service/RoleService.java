package com.lawencon.tracking.service;

import java.util.List;
import com.lawencon.tracking.model.Role;

/**
 * @author : Galih Dika Permana
 */

public interface RoleService {

  List<Role> getListAbsent() throws Exception;

  void insertData(Role role) throws Exception;

  public Role getRoleById(String id) throws Exception;

  void deleteRoleById(Long id) throws Exception;

  void updateData(Role role) throws Exception;
}
