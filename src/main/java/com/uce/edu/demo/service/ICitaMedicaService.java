package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.CitaMedica;

public interface ICitaMedicaService {

	public void insertar(CitaMedica citaMedica);
	
	public void actualizar(CitaMedica citaMedica);
	
	public CitaMedica buscar(String numeroCita);
}
