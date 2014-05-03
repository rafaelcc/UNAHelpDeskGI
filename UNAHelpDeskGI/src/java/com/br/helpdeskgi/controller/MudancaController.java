/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.helpdeskgi.controller;

import com.br.helpdeskgi.dao.MudancaDao;
import com.br.helpdeskgi.entity.Mudanca;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author rafacc
 */
@ManagedBean
@SessionScoped
public class MudancaController {

    private Mudanca mudanca;
    private MudancaDao mudancaDao;

    public Mudanca getMudanca() {
        if (this.mudanca == null) {
            this.mudanca = new Mudanca();
        }
        return mudanca;
    }

    public void setMudanca(Mudanca mudanca) {
        this.mudanca = mudanca;
    }

    public void criarMudanca() throws Exception {
        mudancaDao = new MudancaDao();
        if (mudancaDao.buscarIncidenteId(mudanca.getIdChamado())) {
            mudancaDao.salvar(getMudanca());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Incidente Criado", "Incidente Criado"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Incidente inexiste", "Incidente inexiste"));
        }

    }
}
