package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cita_medica")
public class CitaMedica {

	@Id
	@Column(name = "cita_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cita_seq_id")
	@SequenceGenerator(name = "cita_seq_id", sequenceName = "cita_seq_id", allocationSize = 1)
	private Integer id;

	@Column(name = "cita_numero_cita")
	private String numeroCita;

	@Column(name = "cita_fecha_cita")
	private LocalDateTime fechaCita;

	@Column(name = "cita_valor_cita")
	private BigDecimal valorCita;

	@Column(name = "cita_lugar_cita")
	private String lugarCita;

	@Column(name = "cita_diagnostico")
	private String diagnostico;

	@Column(name = "cita_receta")
	private String receta;

	@Column(name = "cita_proxima_cita")
	private LocalDateTime proximaCita;

	@ManyToOne
	@JoinColumn(name = "cita_paci_id")
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "cita_doct_id")
	private Doctor doctor;

	public Integer getId() {
		return id;
	}

	// SET y GET
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroCita() {
		return numeroCita;
	}

	public void setNumeroCita(String numeroCita) {
		this.numeroCita = numeroCita;
	}

	public LocalDateTime getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}

	public BigDecimal getValorCita() {
		return valorCita;
	}

	public void setValorCita(BigDecimal valorCita) {
		this.valorCita = valorCita;
	}

	public String getLugarCita() {
		return lugarCita;
	}

	public void setLugarCita(String lugarCita) {
		this.lugarCita = lugarCita;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getReceta() {
		return receta;
	}

	public void setReceta(String receta) {
		this.receta = receta;
	}

	public LocalDateTime getProximaCita() {
		return proximaCita;
	}

	public void setProximaCita(LocalDateTime proximaCita) {
		this.proximaCita = proximaCita;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

}
