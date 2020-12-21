package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa(null,"TesteA", "testeA@gmail.com");
		Pessoa p2 = new Pessoa(null,"TesteB", "testeB@gmail.com");
		Pessoa p3 = new Pessoa(null,"TesteC", "testeC@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		//Inicio da transação 
		em.getTransaction().begin();
		
		//Persistindo objetos
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		
		//Pesquisando objetos
		Pessoa p = em.find(Pessoa.class, 3);
		System.out.println(p);
		
		//Exclusao de objetos
		em.remove(p);
		
		//Comit de operações
		em.getTransaction().commit();
		System.out.println("Transação concluida!");
		
		
		em.close();
		emf.close();
	}

}
