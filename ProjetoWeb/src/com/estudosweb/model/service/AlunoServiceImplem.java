package com.estudosweb.model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.estudosweb.model.dao.AlunoDaoInterface;
import com.estudosweb.model.model.AlunoModel;

public class AlunoServiceImplem implements AlunoService{
	
	@Inject
	private AlunoDaoInterface alunoDao;
	

	@Override
	public List<AlunoModel> getAluno() {
		
		return alunoDao.getAluno();
	}

	@Override
	@Transactional
	public AlunoModel salvar(AlunoModel aluno) {
		
		return alunoDao.salvar(aluno);
	}

	@Override
	@Transactional
	public void alterar(AlunoModel aluno) {
		
		alunoDao.alterar(aluno);
		
	}

	@Override
	@Transactional
	public void excluir(AlunoModel aluno) {
		
		alunoDao.excluir(aluno);
		
	}

	
}
