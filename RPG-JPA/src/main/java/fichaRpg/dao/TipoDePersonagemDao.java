package fichaRpg.dao;

import javax.persistence.EntityManager;

import fichaRpg.model.Compra;
import fichaRpg.model.TipoDePersonagem;

public class TipoDePersonagemDao {

private EntityManager em;
	
	public TipoDePersonagemDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastar(TipoDePersonagem tipoDePersonagem) {
		this.em.persist(tipoDePersonagem);
	}
	
	public TipoDePersonagem buscarPorId(long id) {
		return em.find(TipoDePersonagem.class, id);
	}
}
