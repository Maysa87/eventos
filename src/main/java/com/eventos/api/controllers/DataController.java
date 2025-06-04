package com.eventos.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class DataController {

	// injetar service

	@GetMapping("/date")
	public String getCurrentDate() {
		// CHAMAR SERVICE DataService
		return null;
	}
}
