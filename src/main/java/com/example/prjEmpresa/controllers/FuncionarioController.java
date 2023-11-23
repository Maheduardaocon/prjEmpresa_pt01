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

import com.example.prjEmpresa.entities.FuncionarioEntity.Funcionario;
import com.example.prjEmpresa.services.FuncionarioService;


	@RestController
	@RequestMapping("/funcionarios")
	public class FuncionarioController {
		private final FuncionarioService funcionarioservice;

	
	    public FuncionarioController(FuncionarioService funcionarioservice) {
	        this.funcionarioservice = funcionarioservice;
	    }

	    @PostMapping
	    public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
	        return funcionarioservice.saveFuncionario(funcionario);
	    }

	    @GetMapping("/{funcodigo}")
	    public Funcionario getFuncionario(@PathVariable Long funcodigo) {
	        return funcionarioservice.getFuncionarioById(funcodigo);
	    }

	    @GetMapping
	    public List<Funcionario> getAllFuncionario() {
	        return funcionarioservice.getAllFuncionario();
	    }

	    @DeleteMapping("/{funcodigo}")
	    public void deleteFuncionario(@PathVariable Long funcodigo) {
	    	funcionarioservice.deleteFuncionario(funcodigo);
	    }
	    
	    @PutMapping("/{funcodigo}")

		public Funcionario updateFuncionarioControl(@PathVariable Long funcodigo, @RequestBody Funcionario funcionario) {

			return funcionarioservice.updateFuncionario(funcodigo, funcionario);

		}
	}

