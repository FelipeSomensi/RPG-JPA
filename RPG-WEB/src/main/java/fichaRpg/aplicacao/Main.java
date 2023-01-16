package fichaRpg.aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fichaRpg.model.Personagem;
import fichaRpg.model.TipoDePersonagem;

public class Main {

	public static void main(String[] args) {
		
		//criando TipoDePersonagem
		TipoDePersonagem humano = new TipoDePersonagem("humano");
		
		Personagem p1 = new Personagem(null,"Felipe", 18, "Paladino", humano);
		//Personagem p2 = new Personagem(null,"Adriano", 18, "Mago", TipoDePersonagem.HUMANO);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ficha-rpg");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(p1);
		//em.persist(p2);
		em.getTransaction().commit();
		
		
		//Buscar alguem no banco
		//Personagem p = em.find(Personagem.class, 3);
		//System.out.println(p);
		
		//deletar alguem do banco
		//em.getTransaction().begin();
		//em.remove(p);
		//em.getTransaction().commit();
		
		System.out.println("finalizou");
		em.close();
		emf.close();
	}

}
