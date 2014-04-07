/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.helpdeskgi.controller;

import com.br.helpdeskgi.dao.IncidenteDao;
import com.br.helpdeskgi.entity.Incidente;
import java.util.HashMap;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author rafacc
 */
@ManagedBean
public class IncidenteController {

    private Incidente incidente;
    private IncidenteDao incidenteDao;
    private String atendente;
    private String solicitante;

    public Incidente getIncidente() {
        if (this.incidente == null) {
            this.incidente = new Incidente();
        }
        return incidente;
    }

    public void setIncidente(Incidente incidente) {
        this.incidente = incidente;
    }

    public String criarIncidente() {
        incidenteDao = new IncidenteDao();
        incidenteDao.salvar(getIncidente());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Incidente Criado", "Incidente Criado"));
        return null;
    }

    public Map<String, String> getAtendentes() {
        incidenteDao = new IncidenteDao();
        Map<String, String> atendentes = new HashMap<String, String>();
        for (int i = 0; i < incidenteDao.listarAtendentes().size(); i++) {
            atendentes.put(incidenteDao.listarAtendentes().get(i).getAtendente(), incidenteDao.listarAtendentes().get(i).getAtendente());
        }
        return atendentes;
    }

    public Map<String, String> getSolicitantes() {
        incidenteDao = new IncidenteDao();
        Map<String, String> solicitante = new HashMap<String, String>();
        for (int i = 0; i < incidenteDao.listarSolicitantes().size(); i++) {
            solicitante.put(incidenteDao.listarSolicitantes().get(i).getAtendente(), incidenteDao.listarSolicitantes().get(i).getAtendente());
        }
        return solicitante;
    }

    public String getAtendente() {
        return atendente;
    }

    public void setAtendente(String atendente) {
        this.atendente = atendente;
        incidente.setDb_atendente_id(incidenteDao.retornaId(atendente));
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
        incidente.setDb_solicitante_id(incidenteDao.retornaId(solicitante));
        long datahoraEmMillisegundos = new java.util.Date().getTime();
        java.sql.Timestamp ts = new java.sql.Timestamp (datahoraEmMillisegundos); 
        incidente.setData_abertura(ts);
    }
}
