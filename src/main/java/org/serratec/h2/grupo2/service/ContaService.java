package org.serratec.h2.grupo2.service;

import org.serratec.h2.grupo2.repository.ContaRepository;
import org.serratec.h2.grupo2.security.tokenAcesso.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class ContaService  {

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtService jwtService;
    
    @Autowired
    private ContaRepository repository;

    public String login(String email, String senha) {
    	Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, senha));
    	UserDetails userDetails = (UserDetails) authentication.getPrincipal();
    	String token = jwtService.gerarToken(userDetails);
    	return token;
    }
    
    //VERIFICAR SE O TOKEN É VÁLIDO
    public boolean tokenValido(String token) {
        try {
            final String email = jwtService.extrairEmail(token);
            return repository.existsByEmail(email) && !jwtService.tokenExpirado(token);
        } catch (Exception e) {
            return false;
        }
    }
}