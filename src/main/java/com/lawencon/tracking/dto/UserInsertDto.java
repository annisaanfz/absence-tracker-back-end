package com.lawencon.tracking.dto;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @author : Galih Dika Permana
 */
@Data
public class UserInsertDto {

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createdAt;
  private String createdBy;
  private String email;
  private String firstName;
  private String lastName;
  private String username;
  private String password;
  private String roleId;

}
