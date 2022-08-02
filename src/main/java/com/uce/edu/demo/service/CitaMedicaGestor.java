package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IDoctorRepository;
import com.uce.edu.demo.repository.IPacienteRepository;
import com.uce.edu.demo.repository.modelo.CitaMedica;
import com.uce.edu.demo.repository.modelo.Doctor;
import com.uce.edu.demo.repository.modelo.Paciente;

@Service
public class CitaMedicaGestor implements ICitaMedicaGestor {

	@Autowired
	private ICitaMedicaService citaMedicaService;

	@Autowired
	private IDoctorRepository doctorRepository;
	
	@Autowired
	private IPacienteRepository pacienteRepository;


	@Override
	public void agendamientoCitaMedica(String numeroCita, LocalDateTime fechaCita, BigDecimal valorCita,
			String lugarCita, String cedulaDoc, String cedulaPac) {
		CitaMedica cita = new CitaMedica();

		cita.setNumeroCita(numeroCita);
		cita.setFechaCita(fechaCita);
		cita.setValor(valorCita);
		cita.setLugar(lugarCita);

		Doctor doc = this.doctorRepository.buscarCedula(cedulaDoc);
		
		Paciente pac = this.pacienteRepository.buscarCedula(cedulaPac);

		cita.setDoctor(doc);
		cita.setPaciente(pac);
		
		this.citaMedicaService.insertar(cita);
	}

	@Override
	public void actualizacionCitaMedica(String numeroCita, String diagnostico, String receta, LocalDateTime fechaProxima) {
		
		CitaMedica cita = this.citaMedicaService.buscar(numeroCita);
		cita.setDiagnostico(diagnostico);
		cita.setReceta(receta);
		cita.setFechaProximaCita(fechaProxima);
		
		this.citaMedicaService.actualizar(cita);
		
	}

}
