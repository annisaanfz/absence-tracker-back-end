package com.lawencon.tracking.model;

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
@Table(name = "tb_m_users")
public class Users {
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

  @Column(name = "first_name", nullable = false, length = 50)
  private String firstName;

  @Column(name = "last_name", length = 50)
  private String lastName;

  @Column(nullable = false, length = 100)
  private String username;

  @Column(name = "user_password", nullable = false)
  private String password;

  @Column(nullable = false, length = 100)
  private String email;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_role", nullable = false, foreignKey = @ForeignKey(name = "fk_role"))
  private Role role;
}
