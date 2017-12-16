package br.com.fema.biblioteca.util;

import br.com.fema.biblioteca.dao.LivroDao;
import br.com.fema.biblioteca.dao.StatusLivroDao;
import br.com.fema.biblioteca.model.Livro;
import br.com.fema.biblioteca.model.StatusLivro;

public class PopulaBanco {

	public static void main(String[] args) {
		
		Livro livro = new Livro();
		LivroDao livroDao = new LivroDao();
		
		livro = livroDao.buscaPorId(2);
		
		StatusLivro status = new StatusLivro();
		StatusLivroDao statusDao = new StatusLivroDao();
		status = statusDao.buscaPorId(1);
		
		livro.setStatus(status);
		
		livroDao.alterar(livro);
		
		System.out.println(livro.getLivro() + status.getStatus());
		}

		
		
	
}
