package com.estudosweb.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.estudosweb.model.model.AlunoModel;

public class AlunoDaoImplem implements AlunoDaoInterface{
	
	@PersistenceContext(unitName="ProjetoWeb")
	private EntityManager entityManager;
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<AlunoModel> getAluno() {
		
		Query query = entityManager.createQuery("from AlunoModel");
		return query.getResultList();
	
	}

	@Override
	public AlunoModel salvar(AlunoModel aluno) {
		
		entityManager.persist(aluno);
		return aluno;
	}

	@Override
	public void alterar(AlunoModel aluno) {
		
		AlunoModel alunoAlterar = entityManager.merge(aluno);
		entityManager.persist(alunoAlterar);
		
	}

	@Override
	public void excluir(AlunoModel aluno) {
		
		AlunoModel alunoExcluir = entityManager.merge(aluno);
		entityManager.remove(alunoExcluir);
		
	}

}
