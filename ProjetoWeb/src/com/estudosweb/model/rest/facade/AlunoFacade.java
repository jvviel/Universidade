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

import com.estudosweb.model.model.AlunoModel;
import com.estudosweb.model.service.AlunoService;

@Path("/alunos")
@Produces({MediaType.APPLICATION_JSON,
		MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class AlunoFacade {

	@Inject
	private AlunoService alunoService;
	
	@GET
	public List<AlunoModel> getAluno(){
		
		return alunoService.getAluno();
	}
	
	@POST
	public AlunoModel salvar(AlunoModel aluno){
		
		return alunoService.salvar(aluno);
	}
	
	@PUT
	public void alterar(AlunoModel aluno){
		
		alunoService.alterar(aluno);
	}
	
	@DELETE
	@Path("/{codigoAluno}")
	public void excluir(@PathParam("codigoAluno") Integer codigoAluno){
		
		AlunoModel aluno = new AlunoModel();
		aluno.setCodigo(codigoAluno);
		alunoService.excluir(aluno);
	}
}
