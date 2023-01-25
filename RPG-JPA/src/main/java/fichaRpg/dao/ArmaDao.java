package fichaRpg.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
	
	/*public List<Arma> buscarPorParametors(String nome,
			LocalDate dataCadastro) {
		String jpql = "SELECT p FROM Arma p WHERE 1=1";
		if (nome != null && !nome.trim().isEmpty()) {
			jpql = " AND p.nomeArma = :nomeArma ";
		if (dataCadastro != null) {
			jpql = " AND p.dataCadastro = :dataCadastro";
		}
		TypedQuery<Arma> query = em.createQuery(jpql, Arma.class);
		} SEI LA  */
	}
	

