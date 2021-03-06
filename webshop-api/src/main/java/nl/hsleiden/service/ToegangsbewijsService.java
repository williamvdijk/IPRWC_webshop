package nl.hsleiden.service;

import nl.hsleiden.model.Gebruiker;
import nl.hsleiden.model.Toegangsbewijs;
import nl.hsleiden.persistence.ToegangsbewijsDAO;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class ToegangsbewijsService {

    ToegangsbewijsDAO toegangsbewijsDAO;

    @Inject
    public ToegangsbewijsService(ToegangsbewijsDAO toegangsbewijsDAO) {
        this.toegangsbewijsDAO = toegangsbewijsDAO;
    }

    /**
     * Get single toegangsbewijs by unique id
     *
     * @param id
     * @return
     */
    public Toegangsbewijs get(long id) {
        Toegangsbewijs toegangsbewijs = toegangsbewijsDAO.findById(id).orElse(null);
        return toegangsbewijs;
    }

    /**
     * Get all toegangsbewijs by user id
     *
     * @param id
     * @return
     */
    public List<Toegangsbewijs> getByUser(long id) {
        List<Toegangsbewijs> toegangsbewijs = toegangsbewijsDAO.findByUser(id);
        return toegangsbewijs.size() > 0 ? toegangsbewijs : null;
    }

    /**
     * @param id
     * @param toegangsbewijs
     */
    public void update(long id, Toegangsbewijs toegangsbewijs) {
        toegangsbewijs.setId(id);
        if (get(id).getId() == toegangsbewijs.getId()) {
            toegangsbewijsDAO.update(toegangsbewijs);
        }
    }

    /**
     * @param toegangsbewijs
     * @return
     */
    public Toegangsbewijs set(Toegangsbewijs toegangsbewijs) {
        return toegangsbewijsDAO.set(toegangsbewijs).orElse(null);
    }

    /**
     * @param id
     */
    public void delete(long id) {
        Toegangsbewijs toegangsbewijs = get(id);
        if (toegangsbewijs != null) {
            toegangsbewijsDAO.delete(toegangsbewijs);
        }
    }

}
