package com.estudosweb.model.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.estudosweb.model.model.ProfessorModel;

public class ProfessorDaoImplem implements ProfessorDaoInterface{
	
	@PersistenceContext(unitName="ProjetoWeb")
	private EntityManager entityManager; //irá fazer tudo dentro da aplicação

	@Override
	public ProfessorModel salvar(ProfessorModel professor) {
		entityManager.persist(professor);
		return professor;
	}

	@Override
	public void alterar(ProfessorModel professor) {
		ProfessorModel professorAlterar = entityManager.merge(professor); //atualiza o professor model
		entityManager.persist(professorAlterar);
		
	}

	@Override
	public void excluir(ProfessorModel professor) {
		ProfessorModel professorExcluir = entityManager.merge(professor); 
		entityManager.remove(professorExcluir); //exclui o registro
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ProfessorModel> getProfessor() {
		Query query = entityManager.createQuery("from ProfessorModel");   //referencia a classe que possui a entidade
		return query.getResultList();  //retorna a lista de professores
	}

}
