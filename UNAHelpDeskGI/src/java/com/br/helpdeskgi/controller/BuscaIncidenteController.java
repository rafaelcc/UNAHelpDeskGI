/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.helpdeskgi.controller;

import com.br.helpdeskgi.dao.IncidenteDao;
import com.br.helpdeskgi.entity.Incidente;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author rafacc
 */
@ManagedBean
@SessionScoped
public class BuscaIncidenteController {

    private Incidente incidente;
    private IncidenteDao idao;
    private List<Incidente> incidenteLista;
    private Incidente incidenteSelecionado;
    private String idIncidente;
    private String solicitante;

    public String getId() {
        return idIncidente;
    }

    public void setId(String id) {
        this.idIncidente = id;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }
    
    public Incidente buscaIncidentePeloId(String idIncidente) throws Exception{
        idao = new IncidenteDao();
        return idao.buscarIncidenteId(idIncidente);
    }
}
