package com.ufrn.cb.SisAEL.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.dados.FachadaDados;
import com.ufrn.cb.SisAEL.entity.Sala;

@Service
public class SalaService {
	
	@Autowired
	FachadaDados fachada;
	
	public Sala cadastrar(Sala sala) {
		
		return fachada.salvarSala(sala);
		
	}

}
