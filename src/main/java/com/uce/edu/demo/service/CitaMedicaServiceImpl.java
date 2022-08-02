package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICitaMedicaRepository;
import com.uce.edu.demo.repository.modelo.CitaMedica;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService {

	@Autowired
	private ICitaMedicaRepository citaMedicaRepository;

	@Override
	public void insertar(CitaMedica citaMedica) {
		this.citaMedicaRepository.insertar(citaMedica);
	}

	@Override
	public void actualizar(CitaMedica citaMedica) {
		this.citaMedicaRepository.actualizar(citaMedica);
	}

	@Override
	public CitaMedica buscar(String numeroCita) {
		return this.citaMedicaRepository.buscar(numeroCita);
	}

	
}
