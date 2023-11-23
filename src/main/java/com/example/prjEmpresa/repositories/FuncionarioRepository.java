package com.example.prjEmpresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prjEmpresa.entities.FuncionarioEntity.Funcionario;

public interface FuncionarioRepository extends JpaRepository <Funcionario, Long> { 

}
