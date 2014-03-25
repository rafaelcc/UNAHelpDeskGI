/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.helpdeskgi.dao;

import com.br.helpdeskgi.entity.Incidente;
import com.br.helpdeskgi.entity.Incidente_;
import com.br.helpdeskgi.entity.Pessoas;
import com.br.helpdeskgi.persistence.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author rafacc
 */
public class IncidenteDao implements IDao {

    private Session session;
    private Transaction transaction;

    @Override
    public void salvar(Object obj) {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = session.beginTransaction();
            this.session.save(obj);
            this.transaction.commit();
        } catch (HibernateException he) {
            transaction.rollback();
        } finally {
            this.session.close();
        }
    }

    @Override
    public void alterar(Object obj) {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = session.beginTransaction();
            this.session.update(obj);
            this.transaction.commit();
        } catch (HibernateException he) {
            transaction.rollback();
        } finally {
            this.session.close();
        }
    }

    @Override
    public void excluir(Object obj) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(obj);
            transaction.commit();
        } catch (HibernateException he) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Object> listarTodos() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM db_solicitante");
            return query.list();
        } catch (HibernateException he) {
            return null;
        } finally {
            session.close();
        }
    }

    public ArrayList<Pessoas> listarSolicitantes() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String grupo = "6";
            Criteria criteria = session.createCriteria(Pessoas.class).add(Restrictions.eq("grupo", grupo));
            ArrayList<Pessoas> solicitante = (ArrayList<Pessoas>) criteria.list();
            return solicitante;
        } catch (HibernateException he) {
            return null;
        } finally {
            session.close();
        }
    }

    public ArrayList<Pessoas> listarAtendentes() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Pessoas.class);//.add(Restrictions.eq("grupo", Incidente_.categoria));
            ArrayList<Pessoas> atendente = (ArrayList<Pessoas>) criteria.list();
            return atendente;
        } catch (HibernateException he) {
            return null;
        } finally {
            session.close();
        }
    }

    public int pegarId(String db_atendente_id) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Pessoas.class).add(Restrictions.eq("atendente", db_atendente_id));
            Pessoas id = (Pessoas)criteria.uniqueResult();
            return id.getId();
        } catch (HibernateException he) {
            return 0;
        } finally {
            session.close();
        }
        
    }
}
