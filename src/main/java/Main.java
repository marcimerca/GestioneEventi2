import dao.EventoDao;
import entity.Evento;
import entity.TipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
        EntityManager em = emf.createEntityManager();
        EventoDao dao = new EventoDao(em);

        Evento e1 = new Evento();
        e1.setTipoEvento(TipoEvento.PUBBLICO);
        e1.setNumeroMassimoPartecipanti(150);
        e1.setDescrizione("Aperitivo");
        e1.setDataEvento(LocalDate.of(2024,10,10));

       /* dao.save(e1);*/

       Evento e2 = dao.getById(1);

        System.out.println(e2);

        dao.delete(e2);
    }
}
