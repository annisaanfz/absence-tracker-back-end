package com.lawencon.tracking.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;

/**
 * @author : Galih Dika Permana
 */
@Data
@Entity
@Table(name = "tb_r_absents")
public class Absent {
  // public static final long serialVersionUID = 1L;
  @Id
  @Column(name = "id", columnDefinition = "varchar DEFAULT uuid_generate_v4()")
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
  private String id;

  @Column(name = "created_by")
  private String createdBy;

  @Column(name = "created_at")
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column(name = "updated_by")
  private String updatedBy;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @Column(name = "trx_number")
  private String trxNumber;

  @Column(name = "trx_date")
  private LocalDate trxDate;

  @Column(name = "time_in")
  private LocalDateTime timeIn;

  @Column(name = "time_out")
  private LocalDateTime timeOut;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_user", nullable = false, foreignKey = @ForeignKey(name = "fk_user"))
  private Users user;

}
