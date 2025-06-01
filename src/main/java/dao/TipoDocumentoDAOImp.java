package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Tipodocumento;

public class TipoDocumentoDAOImp implements TipoDocumentoDAO {

	EntityManagerFactory factory;
	EntityManager em;
	
	public TipoDocumentoDAOImp() {
		factory = Persistence.createEntityManagerFactory("semana01");
		em = factory.createEntityManager();
	}
	
	@Override
	public void create(Tipodocumento tipo) {
		em.getTransaction().begin();
		em.persist(tipo);
		em.getTransaction().commit();
	}

	@Override
	public void update(Tipodocumento tipo) {
		em.getTransaction().begin();
		em.merge(tipo);
		em.getTransaction().commit();
	}

	@Override
	public void delete(Integer id) {
		em.getTransaction().begin();
		em.remove(id);
		em.getTransaction().commit();
	}

	@Override
	public Tipodocumento find(Integer id) {
		return em.find(Tipodocumento.class, id);
	}

	@Override
	public List<Tipodocumento> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
