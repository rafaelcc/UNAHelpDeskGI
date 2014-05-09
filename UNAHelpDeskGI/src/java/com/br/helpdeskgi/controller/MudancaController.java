/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.helpdeskgi.controller;

import com.br.helpdeskgi.dao.MudancaDao;
import com.br.helpdeskgi.entity.Mudanca;
import com.br.helpdeskgi.entity.Pessoas;
import java.util.List;
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
    private int idBusca;

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
//        if (mudancaDao.buscarIncidenteId(mudanca.getIdChamado()).equals(null)) {
            mudancaDao.salvar(getMudanca());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mudança Criado", "Mudança Criada"));
//        } else {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Incidente inexiste", "Incidente inexiste"));
//        }
    }

    public void buscaMudancaPeloId(int idBusca) throws Exception {
        mudancaDao = new MudancaDao();
        setMudanca((Mudanca) mudancaDao.buscarMudancaId(idBusca));
    }
    
    public String retornaNome (int id) throws Exception{
        mudancaDao = new MudancaDao();
        Pessoas pessoa = mudancaDao.buscarNome(id);
        return pessoa.getAtendente();
    }

    public int getIdBusca() {
        return idBusca;
    }

    public void setIdBusca(int idBusca) {
        this.idBusca = idBusca;
    }

}
