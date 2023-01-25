package fichaRpg.aplicacao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import fichaRpg.dao.ArmaDao;
import fichaRpg.dao.CompraDao;
import fichaRpg.dao.PersonagemDao;
import fichaRpg.dao.TipoDaArmaDao;
import fichaRpg.dao.TipoDePersonagemDao;
import fichaRpg.model.Arma;
import fichaRpg.model.Compra;
import fichaRpg.model.ItemCompra;
import fichaRpg.model.Personagem;
import fichaRpg.model.TipoDaArma;
import fichaRpg.model.TipoDePersonagem;
import util.JPAUtil;

public class Main4 {

	public static void main(String[] args) {

		
		EntityManager em = new JPAUtil().getEntityManager();
		cadastrarPersonagem();
		cadastrarArmas();
		
		ArmaDao armaDao = new ArmaDao(em);
		Arma arma = armaDao.buscarPorId(1);
		TipoDePersonagemDao tipoDePersonagemDao = new TipoDePersonagemDao(em);
		PersonagemDao personagemDao = new PersonagemDao(em);
		
		
		TipoDePersonagem tipoDePersonagem = tipoDePersonagemDao.buscarPorId(1);
		Personagem personagem = personagemDao.buscarPorID(1);
		
		em.getTransaction().begin();
		
		
		Compra compra = new Compra(personagem);
		compra.adicionarArma(new ItemCompra(10,compra,arma));
		
		CompraDao compraDao = new CompraDao(em);
		compraDao.cadrastar(compra);
		
		em.getTransaction().commit();
		
		
		//consulta de valor de pedido
		BigDecimal totalVendido = compraDao.valorTotalVendido();
		System.out.println("Valor Total: "+ totalVendido);
		
		//Não entendi essa merda mas para para trazer varios dados
		//Verificar aula 4 pra ajeitar isso aqui. Da para criar uma classe para retornar ela
		//ao inves de retornar um Object
		List<Object[]> relatorio = compraDao.relatorioDeVendas();
		for (Object[] obj : relatorio) {
			System.out.println(obj[0]);
			System.out.println(obj[1]);
			System.out.println(obj[2]);
			
		} 

	}


	static void cadastrarPersonagem() {
		
		TipoDePersonagem humano = new TipoDePersonagem("humano");
		TipoDePersonagem orc = new TipoDePersonagem("orc");
		TipoDePersonagem elfo = new TipoDePersonagem("elfo");

		Personagem p1 = new Personagem(null, "Adriano", 18, "Mago", elfo);
		Personagem p2 = new Personagem(null, "Felipe", 21, "Paladino", humano);
		Personagem p3 = new Personagem(null, "Faqui", 30, "Guerreiro", orc);

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
		em.getTransaction().commit();

		System.out.println("Personagens cadastrados");
		em.close();
	}
	
	static void cadastrarArmas(){
		
		TipoDaArma espada = new TipoDaArma("Espada");
		TipoDaArma machado = new TipoDaArma("Machado");
		TipoDaArma lanca = new TipoDaArma("Lança");
		
		Arma espadaComum = new Arma("Espada comum", 10, 50.0, espada);
		Arma machadoDeGuerra = new Arma("Machado de guerra", 50, 500.0 , machado);
		Arma lancaDeGuerra = new Arma("lança de guerra", 35, 250.0, lanca);
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		TipoDaArmaDao tipoDaArmaDao = new TipoDaArmaDao(em);
		ArmaDao armaDao = new ArmaDao(em);
		
		em.getTransaction().begin();
		tipoDaArmaDao.cadastrar(espada);
		tipoDaArmaDao.cadastrar(machado);
		tipoDaArmaDao.cadastrar(lanca);
		
		armaDao.cadrastar(espadaComum);
		armaDao.cadrastar(machadoDeGuerra);
		armaDao.cadrastar(lancaDeGuerra);
		em.getTransaction().commit();
		
		System.out.println("Armas cadastradas");
		em.close();
	}
}
