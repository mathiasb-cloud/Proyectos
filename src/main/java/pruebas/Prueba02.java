package pruebas;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import model.Tipodocumento;

public class Prueba02 {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("semana01");
		EntityManager em = factory.createEntityManager();
		
		Query query = em.createQuery("SELECT t FROM Tipodocumento t");
		List<Tipodocumento> list = (List<Tipodocumento>) query.getResultList();
		
		for(Tipodocumento r: list) {
			System.out.println(r);
			System.out.println(r.getIdTipo());
			System.out.println(r.getDocumento());
		}
		
	}

}
