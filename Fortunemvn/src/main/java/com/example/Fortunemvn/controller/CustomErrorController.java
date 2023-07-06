package com.example.Fortunemvn.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CustomErrorController implements ErrorController {
	@RequestMapping("/error")
	  @ResponseBody
	  String error(HttpServletRequest request) {
	    return "Something went wrong!!";
	  }

	  public String getErrorPath() {
	    return "/error";
	  }
}
