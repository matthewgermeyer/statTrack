package com.trane.statTrack.controller;

import com.trane.statTrack.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DetailController {
  @Autowired
  DetailService detailService;

}
