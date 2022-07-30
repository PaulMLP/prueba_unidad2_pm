package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.CitaMedica;
import com.uce.edu.demo.repository.modelo.Paciente;

@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements ICitaMedicaRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void insertar(CitaMedica citaMedica) {
		this.entityManager.persist(citaMedica);
	}

	@Override
	public void actualizar(CitaMedica citaMedica) {
		Query myQuery = this.entityManager.createQuery(
				"UPDATE CitaMedica c SET c.diagnostico = :datoDiagnostico, c.receta = :datoReceta, c.proximaCita = :datoFecha WHERE c.numeroCita = :datoNumero");
		myQuery.setParameter("datoDiagnostico", citaMedica.getDiagnostico());
		myQuery.setParameter("datoReceta", citaMedica.getReceta());
		myQuery.setParameter("datoFecha", citaMedica.getFechaCita());
		myQuery.setParameter("datoNumero", citaMedica.getNumeroCita());
		myQuery.executeUpdate();
	}

	@Override
	public CitaMedica buscar(String numeroCita) {
		Query jpqlQuery = this.entityManager.createQuery("SELECT c FROM CitaMedica c WHERE c.numeroCita = :datoNumero");
		jpqlQuery.setParameter("datoNumero", numeroCita);
		return (CitaMedica) jpqlQuery.getSingleResult();

	}


}
