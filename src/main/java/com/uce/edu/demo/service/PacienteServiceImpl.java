package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPacienteRepository;
import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.repository.modelo.PacienteSencillo;

@Service
public class PacienteServiceImpl implements IPacienteService{

	@Autowired
	private IPacienteRepository pacienteRepository;
	
	@Override
	public void insertar(Paciente paciente) {
		this.pacienteRepository.insertar(paciente);
	}

	@Override
	public Paciente buscar(Integer id) {
		return this.pacienteRepository.buscar(id);
	}

	@Override
	public void actualizar(Paciente paciente) {
		this.pacienteRepository.actualizar(paciente);
	}

	@Override
	public void eliminar(Integer id) {
		this.pacienteRepository.eliminar(id);
	}

	@Override
	public List<PacienteSencillo> buscar(LocalDateTime fecha, String genero) {
		return this.pacienteRepository.buscar(fecha, genero);
	}

}
