package fichaRpg.dao;

import javax.persistence.EntityManager;

import fichaRpg.model.TipoDaArma;

public class TipoDaArmaDao {

	private EntityManager em;
	
	public TipoDaArmaDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(TipoDaArma tipoDaArma) {
		this.em.persist(tipoDaArma);
	}
	
}
