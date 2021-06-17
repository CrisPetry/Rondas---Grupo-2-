package br.upf.ads.paoo.rondas.grupo2.jpa;

import javax.persistence.EntityManager;

import br.upf.ads.paoo.rondas.grupo2.model.Usuario;

public class InserirUsuario {
	
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		em.getTransaction().begin();
		 em.merge(new Usuario(1L, "Administrador", "admin", "1234"));
		  em.getTransaction().commit(); 
		 
	}

}
