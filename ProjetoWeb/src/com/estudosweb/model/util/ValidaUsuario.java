package br.com.fema.biblioteca.util;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.fema.biblioteca.model.Usuario;

public class ValidaUsuario {

public boolean existe(Usuario usuario) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		TypedQuery<Usuario> query = em.createQuery(
				  " select u from Usuario u "
				+ " where u.cpf = :pcpf and u.senha = :psenha", Usuario.class);
		
		query.setParameter("pcpf", usuario.getCpf());
		query.setParameter("psenha", usuario.getSenha());
		try {
			Usuario resultado =  query.getSingleResult();
		} catch (NoResultException ex) {
			return false;
		}
		
		em.close();
		
		return true;
	}
}
