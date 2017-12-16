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

import com.estudosweb.model.model.ProfessorModel;
import com.estudosweb.model.service.ProfessorService;

@Path("/professores")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)

public class ProfessorFacade {

	@Inject //injeta a classe = new ProfessorDaoImplem
	private ProfessorService professorService;
	
	@GET
	public List<ProfessorModel> getProfessor(){
		
		return professorService.getProfessor();
	}
	
	@POST
	public ProfessorModel salvar(ProfessorModel professor){
		
		return professorService.salvar(professor);
	}
	
	@PUT
	public void alterarProfessor(ProfessorModel professor){
		
		professorService.alterar(professor);
	}
	
	@DELETE
	@Path("/{codigoProfessor}")
	public void excluir(@PathParam("codigoProfessor") Integer codigoProfessor){
		
		ProfessorModel professor = new ProfessorModel();
		professor.setCodigo(codigoProfessor);
		professorService.excluir(professor);
	}
	
	
}
