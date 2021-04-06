package com.lawencon.tracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.lawencon.tracking.service.RoleService;

/**
 * @author : Galih Dika Permana
 */
@RestController
public class RoleController {

  @Autowired
  private RoleService roleService;
}
