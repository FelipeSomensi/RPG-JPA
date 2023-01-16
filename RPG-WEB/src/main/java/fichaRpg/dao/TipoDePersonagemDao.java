package fichaRpg.dao;

import javax.persistence.EntityManager;

import fichaRpg.model.TipoDePersonagem;

public class TipoDePersonagemDao {

private EntityManager em;
	
	public TipoDePersonagemDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastar(TipoDePersonagem tipoDePersonagem) {
		this.em.persist(tipoDePersonagem);
	}
	
	
}
