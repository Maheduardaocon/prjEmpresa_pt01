package com.example.prjEmpresa.controllers;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prjEmpresa.entities.DepartamentoEntity.Departamento;
import com.example.prjEmpresa.services.DepartamentoService;


	@RestController
	@RequestMapping("/departamentos")
	public class DepartamentoController {
		private final DepartamentoService departamentoservice;

	
	    public DepartamentoController(DepartamentoService departamentoservice) {
	        this.departamentoservice = departamentoservice;
	    }

	    @PostMapping
	    public Departamento createDepartamento(@RequestBody Departamento departamento) {
	        return departamentoservice.saveDepartamento(departamento);
	    }

	    @GetMapping("/{depcodigo}")
	    public Departamento getDepartamento(@PathVariable Long depcodigo) {
	        return departamentoservice.getDepartamentoById(depcodigo);
	    }

	    @GetMapping
	    public List<Departamento> getAllDepartamento() {
	        return departamentoservice.getAllDepartamento();
	    }

	    @DeleteMapping("/{depcodigo}")
	    public void deleteDepartamento(@PathVariable Long depcodigo) {
	    	departamentoservice.deleteDepartamento(depcodigo);
	    }
	    
	    @PutMapping("/{depcodigo}")

		public Departamento updateDepartamentoControl(@PathVariable Long depcodigo, @RequestBody Departamento departamento) {

			return departamentoservice.updateDepartamento(depcodigo, departamento);

		}
	}
