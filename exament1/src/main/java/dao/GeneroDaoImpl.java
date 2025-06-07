package dao;

import java.util.List;
import entidades.Genero;
import jakarta.persistence.*;

public class GeneroDaoImpl implements GeneroDao {

	EntityManagerFactory fabrica;
	EntityManager em;

	public GeneroDaoImpl() {
		fabrica = Persistence.createEntityManagerFactory("exament1");
		em = fabrica.createEntityManager();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Genero> findAll() {
		Query query = em.createNamedQuery("Genero.findAll");
		return query.getResultList();
	}

	@Override
	public Genero find(int id) {
		return em.find(Genero.class, id);
	}
}
