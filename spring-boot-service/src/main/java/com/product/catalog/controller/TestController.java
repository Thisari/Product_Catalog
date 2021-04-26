package com.product.catalog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RolesAllowed("user-role")
@RequestMapping("/api/test")
public class TestController {

	@GetMapping
	public String getString() {

		return "Tested";
	}

}
