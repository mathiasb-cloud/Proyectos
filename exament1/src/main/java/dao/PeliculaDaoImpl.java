package dao;

import java.util.List;
import entidades.Pelicula;
import jakarta.persistence.*;

public class PeliculaDaoImpl implements PeliculaDao {

	EntityManagerFactory fabrica;
	EntityManager em;

	public PeliculaDaoImpl() {
		fabrica = Persistence.createEntityManagerFactory("exament1");
		em = fabrica.createEntityManager();
	}

	@Override
	public void create(Pelicula pelicula) {
		em.getTransaction().begin();
		em.persist(pelicula);
		em.getTransaction().commit();
	}

	@Override
	public void update(Pelicula pelicula) {
		em.getTransaction().begin();
		em.merge(pelicula);
		em.getTransaction().commit();
	}

	@Override
	public void delete(Integer id) {
		em.getTransaction().begin();
		Pelicula p = em.find(Pelicula.class, id);
		if (p != null) em.remove(p);
		em.getTransaction().commit();
	}

	@Override
	public Pelicula find(Integer id) {
		return em.find(Pelicula.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pelicula> findAll() {
		Query query = em.createNamedQuery("Pelicula.findAll");
		return query.getResultList();
	}
}

