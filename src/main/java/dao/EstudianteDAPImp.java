package dao;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Estudiante;

public class EstudianteDAPImp {
    EntityManagerFactory factory;
    EntityManager em;

    public EstudianteDAPImp() {
        factory = Persistence.createEntityManagerFactory("semana01");
        em = factory.createEntityManager();
    }

    public void create(Estudiante estudiante) {
        em.getTransaction().begin();
        em.persist(estudiante);
        em.getTransaction().commit();
    }

    public void update(Estudiante estudiante) {
        em.getTransaction().begin();
        em.merge(estudiante);
        em.getTransaction().commit();
    }

    public void delete(Integer id) {
        em.getTransaction().begin();
        Estudiante estudiante = em.find(Estudiante.class, id);
        if (estudiante != null) {
            em.remove(estudiante);
        }
        em.getTransaction().commit();
    }

    public Estudiante find(Integer id) {
        return em.find(Estudiante.class, id);
    }

    public List<Estudiante> findAll() {
        return em.createQuery("SELECT e FROM Estudiante e", Estudiante.class).getResultList();
    }
}