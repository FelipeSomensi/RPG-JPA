package fichaRpg.dao;

import javax.persistence.EntityManager;

import fichaRpg.model.Arma;

public class ArmaDao {

private EntityManager em;
	
	public ArmaDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadrastar(Arma arma) {
		this.em.persist(arma);
	}
	
	public Arma buscarPorId(long id) {
		return em.find(Arma.class, id);
	}
	
	
	
}
