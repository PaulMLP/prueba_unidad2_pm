package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface ICitaMedicaGestor {

	public void agendamientoCitaMedica(String numeroCita, LocalDateTime fechaCita, BigDecimal valorCita,
			String lugarCita, String cedulaDoc, String cedulaPac);

	public void actualizacionCitaMedica(String numeroCita, String diagnostico, String receta, LocalDateTime fechaProxima);
	
}
