package com.estudosweb.model.dao;

import java.util.List;

import com.estudosweb.model.model.AlunoModel;

public interface AlunoDaoInterface {

	public List<AlunoModel> getAluno();
	
	public AlunoModel salvar(AlunoModel aluno);
	
	public void alterar(AlunoModel aluno);
	
	public void excluir(AlunoModel aluno);
}
