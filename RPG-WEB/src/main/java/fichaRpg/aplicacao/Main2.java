package fichaRpg.aplicacao;

import javax.persistence.EntityManager;

import fichaRpg.dao.PersonagemDao;
import fichaRpg.dao.TipoDePersonagemDao;
import fichaRpg.model.Personagem;
import fichaRpg.model.TipoDePersonagem;
import util.JPAUtil;

public class Main2 {

	public static void main(String[] args) {

		// criando TipoDePersonagem
		TipoDePersonagem humano = new TipoDePersonagem("humano");

		Personagem p1 = new Personagem(null, "Adriano", 18, "Paladino", humano);
		// Personagem p2 = new Personagem(null,"Adriano", 18, "Mago",
		// TipoDePersonagem.HUMANO);

		// EntityManagerFactory emf =
		// Persistence.createEntityManagerFactory("ficha-rpg");
		// EntityManager em = emf.createEntityManager();

		EntityManager em = new JPAUtil().getEntityManager();

		TipoDePersonagemDao tipoDePersonagemDao = new TipoDePersonagemDao(em);
		PersonagemDao personagemDao = new PersonagemDao(em);

		em.getTransaction().begin();
		tipoDePersonagemDao.cadastar(humano);
		personagemDao.cadastar(p1);
		// em.persist(p2);
		em.getTransaction().commit();
		
		// Buscar alguem no banco
		// Personagem p = em.find(Personagem.class, 3);
		// System.out.println(p);

		// deletar alguem do banco
		// em.getTransaction().begin();
		// em.remove(p);
		// em.getTransaction().commit();

		System.out.println("finalizou");
		em.close();
		// emf.close();
	}

}
