package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	// @RequestMapping(method=RequestMethod.GET, path="/")
	@GetMapping("/")
	public String hello() {
		return "Hello World!!!";
	}
}
