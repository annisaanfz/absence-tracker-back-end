package com.lawencon.tracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lawencon.tracking.dto.UserAbsentInsertDto;
import com.lawencon.tracking.dto.UserAbsentUpdateDto;
import com.lawencon.tracking.dto.UserInsertDto;
import com.lawencon.tracking.service.UserService;

/**
 * @author : Galih Dika Permana
 */
@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/user")
  public ResponseEntity<?> insertUser(@RequestBody UserInsertDto data) throws Exception {
    userService.insertData(data);
    return new ResponseEntity<>("Create User Success", HttpStatus.CREATED);
  }

  @PostMapping("/user/absent")
  public ResponseEntity<?> insertTimeAbsent(@RequestBody UserAbsentInsertDto data)
      throws Exception {
    userService.insertUserAbsent(data);
    return new ResponseEntity<>("Create Absent Success", HttpStatus.CREATED);
  }

  @PutMapping("/user/absent")
  public ResponseEntity<?> updateTimeAbsent(@RequestBody UserAbsentUpdateDto data)
      throws Exception {
    userService.updateDataAbsent(data);
    return new ResponseEntity<>("Update data Success", HttpStatus.OK);
  }
}
