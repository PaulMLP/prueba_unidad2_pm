package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.repository.modelo.PacienteSencillo;

public interface IPacienteRepository {

	public void insertar(Paciente paciente);

	public Paciente buscar(Integer id);

	public void actualizar(Paciente paciente);

	public void eliminar(Integer id);
	
	public List<PacienteSencillo> buscar();
	
	public Paciente buscarCedula(String cedula);
}
