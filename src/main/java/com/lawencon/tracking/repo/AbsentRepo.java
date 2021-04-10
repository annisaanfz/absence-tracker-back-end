package com.lawencon.tracking.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.lawencon.tracking.model.Absent;

/**
 * @author : Galih Dika Permana
 */
@Repository
public interface AbsentRepo extends JpaRepository<Absent, Long> {

  public Absent findAbsentById(String id) throws Exception;

  @Query(value = "select * from Absent where user = :user order by a.trxDate desc",
      nativeQuery = true)
  public List<Absent> findAllByUserOrderByTrxDateDesc(@Param("user") String user) throws Exception;

  @Query(value = "select * from Absent where user = :user and trxDate = now()", nativeQuery = true)
  public List<Absent> findByUserExist(@Param("user") String user) throws Exception;
}
