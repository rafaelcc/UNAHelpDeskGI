/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.helpdeskgi.controller;

import com.br.helpdeskgi.dao.IncidenteDao;
import com.br.helpdeskgi.entity.Incidente;
import java.util.List;
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
        incidente = new Incidente();
        return null;
    }

    public List getAtendentes() {
        incidenteDao = new IncidenteDao();
        return incidenteDao.listarAtendentes();
    }

    public List getSolicitantes() {
        incidenteDao = new IncidenteDao();
        return incidenteDao.listarSolicitantes();
    }

    public void handleAtendChange() {
        if (incidente.getCategoria() != 0) {
            //getAtendentes(incidente.getCategoria());
        }
    }

    public String criarIncidente2() {
        incidenteDao = new IncidenteDao();
        Incidente incidentexml = new Incidente();
        incidentexml.setIdChamado("456a819d-b3b5-4cf6-afa1-8f12804e2a42");
        incidentexml.setCategoria(6);
        incidentexml.setPrioridade(4);
        incidentexml.setDb_solicitante_id(21);
        incidentexml.setDb_atendente_id(14);
        incidentexml.setDescricao("Favor verificar a construção de DataMarchs para a solução proposta. Contato:3183221212");
        incidentexml.setEscalonamento(4);
        incidentexml.setStatus(0);
        incidenteDao.salvar(incidentexml);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Incidente Armazenado", "Incidente Armazenado"));
        incidente = new Incidente();
        return null;
    }
}
