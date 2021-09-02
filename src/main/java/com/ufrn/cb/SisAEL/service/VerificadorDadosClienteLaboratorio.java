package com.ufrn.cb.SisAEL.service;

import org.springframework.stereotype.Service;

import com.ufrn.cb.SisAEL.entity.Cliente;
import com.ufrn.cb.SisAEL.entity.Pesquisador;
import com.ufrn.cb.SisAEL.exception.DadosInvalidosException;

@Service
public class VerificadorDadosClienteLaboratorio extends VerificadorDadosCliente {

	@Override
	public boolean verificar(Cliente cliente) {
		
		Pesquisador pesquisador = (Pesquisador) cliente;
		
		if(pesquisador.getNome() == null || pesquisador.getNome().length() < 3) {
			throw new DadosInvalidosException("Nome de usuario muito curto");
		}
		
		if(pesquisador.getEmail() == null || pesquisador.getEmail().length() < 5) {
			throw new DadosInvalidosException("Telefone inválido");
		}
		
		return true;
	}

}
