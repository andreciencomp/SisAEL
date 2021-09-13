package com.ufrn.cb.SisAEL.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.cb.SisAEL.entity.Cliente;
import com.ufrn.cb.SisAEL.entity.Produto;
import com.ufrn.cb.SisAEL.entity.impl.Quarto;
import com.ufrn.cb.SisAEL.service.FachadaService;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public abstract class ProdutoController{
	
	@Autowired
	protected FachadaService fachada;
	
	@GetMapping
	public ResponseEntity<List<Produto>> listar(){
		
		return ResponseEntity.ok(fachada.listarProdutos());
	}
	
	@GetMapping("/{idEstoque}")
	public ResponseEntity<List<Produto>> listar(@PathVariable(name="idEstoque") long idEstoque){
		
		List<Produto> itens = fachada.listarProdutos(idEstoque);
		return ResponseEntity.ok(itens);
		
	}
	
	@DeleteMapping("remover/{id}")
	public ResponseEntity<Produto> deletar(@PathVariable(value="id") long id){
		fachada.deletarProduto(id);
		return ResponseEntity.ok(null);
		
	}
	

}
