package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.ICitaMedicaRepository;
import com.uce.edu.demo.repository.modelo.CitaMedica;
import com.uce.edu.demo.repository.modelo.Doctor;
import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.service.ICitaMedicaGestor;
import com.uce.edu.demo.service.IDoctorService;
import com.uce.edu.demo.service.IPacienteService;

@SpringBootApplication
public class PruebaUnidad2PmApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(PruebaUnidad2PmApplication.class);

	@Autowired
	private IDoctorService doctorService;

	@Autowired
	private IPacienteService pacienteService;
	
	@Autowired
	private ICitaMedicaGestor citaMedicaGestor;

	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad2PmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Doctor d1 = new Doctor();
		d1.setNombre("Paul");
		d1.setApellido("Merizalde");
		d1.setCedula("12");
		d1.setCodigoSenescyt("1");
		d1.setFechaNacimiento(LocalDateTime.now());
		d1.setNumeroConsultorio("10");
		d1.setGenero("M");
		
		Doctor d2 = new Doctor();
		d2.setNombre("Pablo");
		d2.setApellido("Suarez");
		d2.setCedula("13");
		d2.setCodigoSenescyt("11");
		d2.setFechaNacimiento(LocalDateTime.now());
		d2.setNumeroConsultorio("14");
		d2.setGenero("M");
		
		this.doctorService.insertar(d1);
		this.doctorService.insertar(d2);
		
		Paciente p1 =new Paciente();
		p1.setNombre("Juanito");
		p1.setApellido("Alimania");
		p1.setCedula("14");
		p1.setCodigoSeguro("21");
		p1.setEstatura(1.70);
		p1.setPeso(85.5);
		p1.setFechaNacimiento(LocalDateTime.now());
		p1.setGenero("M");
		
		Paciente p2 =new Paciente();
		p2.setNombre("Daniela");
		p2.setApellido("Teran");
		p2.setCedula("15");
		p2.setCodigoSeguro("19");
		p2.setEstatura(1.60);
		p2.setPeso(50.5);
		p2.setFechaNacimiento(LocalDateTime.now());
		p2.setGenero("F");
		
		this.pacienteService.insertar(p1);
		this.pacienteService.insertar(p2);
		
		
		
		this.citaMedicaGestor.agendamientoCitaMedica("1", LocalDateTime.now(), new BigDecimal(40), "Inca", "12", "14");
		
		//this.citaMedicaGestor.actualizacionCitaMedica("1", "covid", "paracetamol", LocalDateTime.now());
	}

}
