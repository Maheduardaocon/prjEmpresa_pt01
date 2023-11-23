package com.example.prjEmpresa.services;

import java.util.List;
import java.util.Optional;

import com.example.prjEmpresa.entities.DepartamentoEntity.Departamento;
import com.example.prjEmpresa.repositories.DepartamentoRepository;

import org.springframework.stereotype.Service;


@Service
public class DepartamentoService {
		private final DepartamentoRepository DepartamentoRepository;

	
		public DepartamentoService(DepartamentoRepository DepartamentoRepository) {
			this.DepartamentoRepository = DepartamentoRepository;

		}

		public Departamento saveDepartamento(Departamento Departamento) {
			return DepartamentoRepository.save(Departamento);
		}

		public Departamento getDepartamentoById(Long Depcodigo) {
			return DepartamentoRepository.findById(Depcodigo).orElse(null);
		}

		public List<Departamento> getAllDepartamento() {
			return DepartamentoRepository.findAll();
		}

		public void deleteDepartamento(Long Depcodigo) {
			DepartamentoRepository.deleteById(Depcodigo);
		}
		
		public Departamento updateDepartamento(Long depcodigo, Departamento novoDepartamento) {

	        Optional<Departamento> departamentoOptional = DepartamentoRepository.findById(depcodigo);

	        if (departamentoOptional.isPresent()) {

	        	Departamento departamentoExistente = departamentoOptional.get();

	        	departamentoExistente.setDepnome(novoDepartamento.getDepnome());        

	            return DepartamentoRepository.save(departamentoExistente); 

	        } else {

	            return null; 

	        }

		}
	
}
			
