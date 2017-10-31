package com.in28min.restful.springbootrestful.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping(path = "/hello")
	public String displayHello() {
		return "Hello";
	}
}
