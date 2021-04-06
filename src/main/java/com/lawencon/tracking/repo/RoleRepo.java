package com.lawencon.tracking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lawencon.tracking.model.Role;

/**
 * @author : Galih Dika Permana
 */
@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

  public Role findRoleById(String id) throws Exception;

}
