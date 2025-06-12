package org.serratec.h2.grupo2.controller;

import org.serratec.h2.grupo2.security.tokenAcesso.JwtService;
import org.serratec.h2.grupo2.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class ContaController {
	
	@Autowired
	private ContaService service;
	
	@Autowired
	private JwtService jwt;

	@PostMapping
	public String login(@RequestParam String email, @RequestParam String senha) {
		return service.login(email, senha);
	}
	
	@GetMapping("/ehCliente")
	public boolean ehCliente(@RequestParam String token) {
		return jwt.ehCliente(token);
	}
	
}
