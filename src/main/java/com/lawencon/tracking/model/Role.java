package com.lawencon.tracking.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;

/**
 * @author : Galih Dika Permana
 */
@Data
@Entity
@Table(name = "tb_m_roles")
public class Role {
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

  @Column(nullable = false, length = 50)
  private String code;

  @Column(name = "role_name", nullable = false, length = 50)
  private String name;
}
