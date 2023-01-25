package fichaRpg.dao;

import java.util.List;

import javax.persistence.EntityManager;

import fichaRpg.model.Personagem;

public class PersonagemDao {

	private EntityManager em;
	
	public PersonagemDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastar(Personagem personagem) {
		this.em.persist(personagem);
	}
	
	//usando um metodo da JPA da para pesquisar na tabela pela ID
	public Personagem buscarPorID(Integer id) {
		return em.find(Personagem.class, id); //Nome da classa + .class / variavel id
	}
	
	public List<Personagem> buscarTodos() {
		String jpql = "SELECT p FROM Personagem p";
		return em.createQuery(jpql).getResultList();
	}
	
	public List<Personagem> buscarPorNome(String nome) {
		String jpql = "SELECT p FROM Personagem p WHERE p.nome = :nome";
		return em.createQuery(jpql)
				.setParameter("nome", nome)
				.getResultList();
			
		
		
	}
	
	
	
}
