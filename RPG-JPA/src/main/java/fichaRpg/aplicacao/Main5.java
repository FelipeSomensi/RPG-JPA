package fichaRpg.aplicacao;

import javax.persistence.EntityManager;

import fichaRpg.model.Compra;
import util.JPAUtil;

public class Main5 {

	static long teste = 1;
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		Compra compra = em.find(Compra.class,teste);
		System.out.println(compra.getPersonagem());
		
		
		
	}
	

	
}
