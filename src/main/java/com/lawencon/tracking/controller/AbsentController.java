package com.lawencon.tracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lawencon.tracking.service.AbsentService;

/**
 * @author : Galih Dika Permana
 */
@RestController
public class AbsentController {

  @Autowired
  private AbsentService absentService;

  @GetMapping("/absent/user/manager")
  public ResponseEntity<?> getListAbsentForManager() throws Exception {
    return new ResponseEntity<>(absentService.getListAbsent(), HttpStatus.CREATED);
  }

  @GetMapping("/absent/user/employee")
  public ResponseEntity<?> getListAbsentForEmployee() throws Exception {
    return new ResponseEntity<>(absentService.getListAbsent(), HttpStatus.CREATED);
  }
}
