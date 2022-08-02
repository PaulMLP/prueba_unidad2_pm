package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.repository.modelo.PacienteSencillo;

@Repository
@Transactional
public class PacienteRepositoryImpl implements IPacienteRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void insertar(Paciente paciente) {
		this.entityManager.persist(paciente);
	}

	@Override
	public Paciente buscar(Integer id) {
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public void actualizar(Paciente paciente) {
		this.entityManager.merge(paciente);
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public List<PacienteSencillo> buscar(LocalDateTime fecha, String genero) {
		Query jpqlQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.PacienteSencillo (p.cedula, p.nombre, p.fechaNacimiento, p.genero)FROM Paciente p WHERE p.fechaNacimiento > :datoFecha AND p.genero = :datoGenero");
		jpqlQuery.setParameter("datoFecha", fecha);
		jpqlQuery.setParameter("datoGenero", genero);
		return jpqlQuery.getResultList();
	}

	@Override
	public Paciente buscarCedula(String cedula) {
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM Paciente p WHERE p.cedula = :datoCedula");
		jpqlQuery.setParameter("datoCedula", cedula);
		return (Paciente) jpqlQuery.getSingleResult();
	}

}
