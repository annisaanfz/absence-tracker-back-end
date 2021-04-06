package com.lawencon.tracking.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @author : Galih Dika Permana
 */
@Data
public class UserAbsentInsertDto {

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createdAt;
  private String createdBy;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime timeIn;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate trxDate;
  private String trxNumber;
  private String userId;
}
