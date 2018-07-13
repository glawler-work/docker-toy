package com.glawler.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  @Autowired
  public ValueOperations valueOperations;

  @RequestMapping("/")
  public Long getCount() {
    return valueOperations.increment("visits", 1);
  }
}
