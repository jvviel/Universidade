package com.estudosweb.model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.estudosweb.model.dao.CursoDaoInterface;
import com.estudosweb.model.model.CursoModel;

public class CursoServiceImplem implements CursoService{

	@Inject
	private CursoDaoInterface cursoDao;
	
	@Override
	public List<CursoModel> getCurso() {
		
		return cursoDao.getCurso();
	}

	@Override
	@Transactional
	public CursoModel salvar(CursoModel curso) {
		
		return cursoDao.salvar(curso);
	}

	@Override
	@Transactional
	public void alterar(CursoModel curso) {
		
		cursoDao.alterar(curso);
		
	}

	@Override
	@Transactional
	public void excluir(CursoModel curso) {
		
		cursoDao.excluir(curso);
		
	}

	
}
