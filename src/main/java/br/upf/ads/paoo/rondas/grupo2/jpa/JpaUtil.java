package br.upf.ads.paoo.rondas.grupo2.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	private static EntityManagerFactory emf = null; 
	
	public static EntityManager getEntityManager() {
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory("RondasGrupo2");
		}
		return emf.createEntityManager();
	}
}
