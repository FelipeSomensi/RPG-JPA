package fichaRpg.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import fichaRpg.model.Compra;

public class CompraDao {

private EntityManager em;
	
	public CompraDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadrastar(Compra compra) {
		this.em.persist(compra);
	}
	
	public Compra buscarPorId(long id) {
		return em.find(Compra.class, id);
	}
	
	public BigDecimal valorTotalVendido() {
		String jpql = "SELECT SUM(p.valorTotal) FROM Compra p";
		return em.createQuery(jpql, BigDecimal.class)
				.getSingleResult();
	}
	
	public List<Object[]> relatorioDeVendas() {
		String jpql = "SELECT arma.nomeArma, "
				+"SUM(item.quantidade), "
				+"MAX(compra.data) "
				+"FROM Compra compra "
				+"JOIN compra.itens item " 
				+"JOIN item.arma arma "
				+"GROUP BY arma.nomeArma "
				+"ORDER BY item.quantidade DESC";
		return em.createQuery(jpql, Object[].class)
				.getResultList();
				
	}
	
}
