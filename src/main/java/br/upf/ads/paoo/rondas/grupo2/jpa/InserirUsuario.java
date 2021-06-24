package br.upf.ads.paoo.rondas.grupo2.jpa;

import javax.persistence.EntityManager;

import br.upf.ads.paoo.rondas.grupo2.model.Usuario;

public class InserirUsuario {
	
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		em.getTransaction().begin();
		 em.merge(new Usuario(1L, "133057@upf.br", "super", "4321"));
		  em.getTransaction().commit(); 
		 
	}

}
