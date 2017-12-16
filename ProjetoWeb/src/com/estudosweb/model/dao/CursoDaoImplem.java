package com.estudosweb.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.estudosweb.model.model.CursoModel;

public class CursoDaoImplem implements CursoDaoInterface{
	
	@PersistenceContext(unitName = "ProjetoWeb")
	private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	public List<CursoModel> getCurso() {
		
		Query query = entityManager.createQuery("from CursoModel");
		return query.getResultList();
	}

	@Override
	public CursoModel salvar(CursoModel curso) {
		
		entityManager.persist(curso);
		return curso;
	}

	@Override
	public void alterar(CursoModel curso) {
		
		CursoModel cursoAlterar = entityManager.merge(curso);
		entityManager.persist(cursoAlterar);
	}

	@Override
	public void excluir(CursoModel curso) {
		
		CursoModel cursoExcluir = entityManager.merge(curso);
		entityManager.remove(cursoExcluir);
		
	}

}
