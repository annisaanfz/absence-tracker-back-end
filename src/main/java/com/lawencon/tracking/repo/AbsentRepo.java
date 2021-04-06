package com.lawencon.tracking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lawencon.tracking.model.Absent;

/**
 * @author : Galih Dika Permana
 */
@Repository
public interface AbsentRepo extends JpaRepository<Absent, Long> {

  public Absent findAbsentById(String id) throws Exception;
}
