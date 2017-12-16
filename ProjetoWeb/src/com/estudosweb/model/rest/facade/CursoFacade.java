package com.estudosweb.model.rest.facade;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.estudosweb.model.model.CursoModel;
import com.estudosweb.model.service.CursoService;


@Path("/cursos")
@Produces({MediaType.APPLICATION_JSON,
		MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class CursoFacade {
	
	@Inject
	private CursoService cursoService;
	
	@GET
	public List<CursoModel> getCurso(){
		
		return cursoService.getCurso();
	}
	
	@POST
	public CursoModel salvar(CursoModel curso){
		
		
		return cursoService.salvar(curso);
	}
	
	@PUT
	public void alterar(CursoModel curso){
		
		cursoService.alterar(curso);
	}
	
	@DELETE
	@Path("/{codigoCurso}")
	public void excluir(@PathParam("codigoCurso") Integer codigoCurso){
		
		CursoModel curso = new CursoModel();
		curso.setCodigo(codigoCurso);
		cursoService.excluir(curso);
	}
	
}
