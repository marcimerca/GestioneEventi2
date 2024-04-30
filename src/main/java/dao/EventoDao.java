package dao;

import entity.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDao {
    private EntityManager em;

    public EventoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Evento e){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(e);
        et.commit();
    }

    public Evento getById(int id){
        EntityTransaction et = em.getTransaction();
        et.begin();
        Evento evento = em.find(Evento.class,id);
        et.commit();
        return evento;

    }

    public void delete(Evento e){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(e);
        et.commit();
    }
}
