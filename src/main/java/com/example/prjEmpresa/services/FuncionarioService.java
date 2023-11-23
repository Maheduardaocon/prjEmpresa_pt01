package com.example.prjEmpresa.services;

import java.util.List;
import java.util.Optional;

import com.example.prjEmpresa.entities.FuncionarioEntity.Funcionario;
import com.example.prjEmpresa.repositories.FuncionarioRepository;

import org.springframework.stereotype.Service;


@Service

public class FuncionarioService {

		private final FuncionarioRepository funcionarioRepository;

	
		public FuncionarioService(FuncionarioRepository funcionarioRepository) {
			this.funcionarioRepository = funcionarioRepository;

		}

		public Funcionario saveFuncionario(Funcionario funcionario) {
			return funcionarioRepository.save(funcionario);
		}
		

		public Funcionario getFuncionarioById(Long funcodigo) {
			return funcionarioRepository.findById(funcodigo).orElse(null);
		}

		public List<Funcionario> getAllFuncionario() {
			return funcionarioRepository.findAll();
		}

		public void deleteFuncionario(Long funcodigo) {
			funcionarioRepository.deleteById(funcodigo);
		}
		
		public Funcionario updateFuncionario(Long funcodigo, Funcionario novoFuncionario) {

	        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(funcodigo);

	        if (funcionarioOptional.isPresent()) {

	        	Funcionario funcionarioExistente = funcionarioOptional.get();

	        	funcionarioExistente.setFunnome(novoFuncionario.getFunnome());

	        	funcionarioExistente.setFunnascimento(novoFuncionario.getFunnascimento());    
	        	
	        	funcionarioExistente.setFunsalario(novoFuncionario.getFunsalario());
	        	

	            return funcionarioRepository.save(funcionarioExistente); 

	        } else {

	            return null; 

	        }

		}
	
}
