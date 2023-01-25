package fichaRpg.aplicacao;

import java.util.List;

import javax.persistence.EntityManager;

import fichaRpg.dao.PersonagemDao;
import fichaRpg.dao.TipoDePersonagemDao;
import fichaRpg.model.Personagem;
import fichaRpg.model.TipoDePersonagem;
import util.JPAUtil;

public class Main3 {

	public static void main(String[] args) {
		//cadastrarPersonagem();
		
		EntityManager em = new JPAUtil().getEntityManager();
		PersonagemDao personagemDao = new PersonagemDao(em);
		
		//Personagem p = personagemDao.buscarPorID(1);
		//System.out.println(p.toString());
		
		List<Personagem> listaPersonagens = personagemDao.buscarPorNome("Felipe");
		listaPersonagens.forEach(p2 -> System.out.println(p2.toString()));
		
	}
	
	static void cadastrarPersonagem() {
		// criando TipoDePersonagem
		TipoDePersonagem humano = new TipoDePersonagem("humano");
		TipoDePersonagem orc = new TipoDePersonagem("orc");
		TipoDePersonagem elfo = new TipoDePersonagem("elfo");
		
		
		Personagem p1 = new Personagem(null, "Adriano", 18, "Mago", elfo);
	    Personagem p2 = new Personagem(null, "Felipe", 21, "Paladino", humano);
	    Personagem p3 = new Personagem(null, "Faqui", 30, "Guerreiro", orc);
		// TipoDePersonagem.HUMANO);

		// EntityManagerFactory emf =
		// Persistence.createEntityManagerFactory("ficha-rpg");
		// EntityManager em = emf.createEntityManager();

		EntityManager em = new JPAUtil().getEntityManager();
		
		PersonagemDao personagemDao = new PersonagemDao(em);
		TipoDePersonagemDao tipoDePersonagemDao = new TipoDePersonagemDao(em);
		

		em.getTransaction().begin();
		tipoDePersonagemDao.cadastar(humano);
		tipoDePersonagemDao.cadastar(elfo);
		tipoDePersonagemDao.cadastar(orc);
		personagemDao.cadastar(p1);
		personagemDao.cadastar(p2);
		personagemDao.cadastar(p3);
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
