package com.estudosweb.model.dao;

import java.util.List;

import com.estudosweb.model.model.ProfessorModel;

public interface ProfessorDaoInterface {

	public ProfessorModel salvar(ProfessorModel professor);
	
	public void alterar(ProfessorModel professor);
	
	public void excluir(ProfessorModel professor);
	
	public List<ProfessorModel> getProfessor();
}
