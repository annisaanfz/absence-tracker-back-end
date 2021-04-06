package com.lawencon.tracking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lawencon.tracking.model.Users;

/**
 * @author : Galih Dika Permana
 */
@Repository
public interface UserRepo extends JpaRepository<Users, Long> {

  Users findUserById(String id) throws Exception;

  Users findByUsername(String username) throws Exception;

}
