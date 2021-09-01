package com.ufrn.cb.SisAEL.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.cb.SisAEL.entity.Horario;
import com.ufrn.cb.SisAEL.entity.HorarioHotel;
import com.ufrn.cb.SisAEL.service.FachadaService;

@RestController
@RequestMapping("/horarios")
public class HorarioController {
	
	@Autowired
	private FachadaService fachada;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Horario> cadastrar(@RequestBody HorarioHotel horario) {
		
		Horario horarioDaReserva= fachada.cadastrarHorario(horario);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(horarioDaReserva);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Horario>> listar(){
		
		List<Horario> lista = fachada.listarHorarios();
		
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
	
	@DeleteMapping("deletar/{id}")
	public ResponseEntity<Horario> deletar(@PathVariable long id){
		
		fachada.deletarHorario(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
		
	}

}
