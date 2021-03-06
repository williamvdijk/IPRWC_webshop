package nl.hsleiden.persistence;

import io.dropwizard.hibernate.AbstractDAO;
import nl.hsleiden.model.Persoon;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class PersoonDAO extends AbstractDAO<Persoon> {

    /**
     * Constructor.
     *
     * @param sessionFactory Hibernate session factory.
     */
    public PersoonDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Persoon> getAll() {
        return list(namedQuery("Persoon.getAll"));
    }

    public List<Persoon> findByName(String name) {
        return list(namedQuery("Persoon.findByName")
                .setParameter("naam", "%" + name + "%")
        );
    }

    public Optional<Persoon> findById(long id) {
        return Optional.ofNullable(get(id));
    }
}
