/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.helpdeskgi.dao;

import com.br.helpdeskgi.entity.Incidente;
import com.br.helpdeskgi.entity.Mudanca;
import com.br.helpdeskgi.entity.Pessoas;
import com.br.helpdeskgi.persistence.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author rafacc
 */
public class MudancaDao implements IDao {

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
            this.session.flush();
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
            this.session.flush();
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
            session.flush();
            session.close();
        }
    }

    @Override
    public List<Object> listarTodos() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Mudanca.class);
            return criteria.list();
        } catch (HibernateException he) {
            return null;
        } finally {
            session.flush();
            session.close();
        }
    }

    public List<Object> listarSolicitantes() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String grupo = "6";
            Criteria criteria = session.createCriteria(Pessoas.class).add(Restrictions.eq("grupo", grupo));
            return criteria.list();
        } catch (HibernateException he) {
            return null;
        } finally {
            session.flush();
            session.close();
        }
    }

    public Object buscarMudancaId(int idBusca) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Mudanca.class).add(Restrictions.eq("id", idBusca));
            return (Mudanca) criteria.uniqueResult();
        } catch (HibernateException he) {
            throw new Exception("Mudanca não encontrada");
        } finally {
            session.flush();
            session.close();
        }
    }

    public Pessoas buscarNome(int id) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Pessoas.class).add(Restrictions.eq("id", id));
            return (Pessoas) criteria.uniqueResult();
        } catch (HibernateException he) {
            throw new Exception("Pessoa não encontrada");
        } finally {
            session.flush();
            session.close();
        }
    }

    public List<Mudanca> listarMudancasAbertas() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Mudanca.class).add(Restrictions.eq("status", 0));
            ArrayList<Mudanca> listaMudanca = (ArrayList<Mudanca>) criteria.list();
            return listaMudanca;
        } catch (HibernateException he) {
            return null;
        } finally {
            session.flush();
            session.close();
        }
    }

    public List<Mudanca> listarMudancasImplantadas() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Mudanca.class).add(Restrictions.eq("status", 1));
            ArrayList<Mudanca> listaMudanca = (ArrayList<Mudanca>) criteria.list();
            return listaMudanca;
        } catch (HibernateException he) {
            return null;
        } finally {
            session.flush();
            session.close();
        }
    }

    public boolean verificarIncidente(String idChamado) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Incidente.class).add(Restrictions.eq("idChamado", idChamado));
            if (criteria.list().isEmpty()) {
                return false;
            }
            return true;
        } catch (HibernateException he) {
            throw new Exception("Incidente não encontrado");
        } finally {
            session.flush();
            session.close();
        }
    }
}
