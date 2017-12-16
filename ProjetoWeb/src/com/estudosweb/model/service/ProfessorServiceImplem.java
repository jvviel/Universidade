package com.estudosweb.model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.estudosweb.model.dao.ProfessorDaoInterface;
import com.estudosweb.model.model.ProfessorModel;

public class ProfessorServiceImplem implements ProfessorService{
	
	@Inject
	private ProfessorDaoInterface professorDao;

	@Override
	@Transactional
	public ProfessorModel salvar(ProfessorModel professor) {
		
		return professorDao.salvar(professor);
	}

	@Override
	@Transactional
	public void alterar(ProfessorModel professor) {
		
		professorDao.alterar(professor);
		
	}

	@Override
	@Transactional
	public void excluir(ProfessorModel professor) {
	
		professorDao.excluir(professor);
	}

	@Override
	public List<ProfessorModel> getProfessor() {
		
		return professorDao.getProfessor();
	}

	
}
