package com.estudosweb.model.service;

import java.util.List;

import com.estudosweb.model.model.CursoModel;

public interface CursoService {

	public List<CursoModel> getCurso();
	
	public CursoModel salvar(CursoModel curso);
	
	public void alterar(CursoModel curso);
	
	public void excluir(CursoModel curso);
}
