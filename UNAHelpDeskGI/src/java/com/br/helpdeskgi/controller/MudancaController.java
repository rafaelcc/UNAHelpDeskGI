/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.helpdeskgi.controller;

import com.br.helpdeskgi.dao.MudancaDao;
import com.br.helpdeskgi.entity.Mudanca;
import com.br.helpdeskgi.entity.Pessoas;
import java.util.ArrayList;
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
    private int mudancasAbertas;
    private int mudancasImplantadas;

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
        if (mudancaDao.verificarIncidente(getMudanca().getIdChamado())) {
            getMudanca().setStatus(0);
            mudancaDao.salvar(getMudanca());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mudança Criada", "Mudança Criada"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Incidente inexiste", "Incidente inexiste"));
        }
    }

    public void buscaMudancaPeloId(int idBusca) throws Exception {
        mudancaDao = new MudancaDao();
        setMudanca((Mudanca) mudancaDao.buscarMudancaId(idBusca));
    }

    public String retornaNome(int id) throws Exception {
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

    public List<Mudanca> getListaMudancaAbertas() {
        mudancaDao = new MudancaDao();
        ArrayList<Mudanca> mudancaLista = new ArrayList<Mudanca>();
        mudancaLista = (ArrayList<Mudanca>) mudancaDao.listarMudancasAbertas();
        return mudancaLista;
    }

    public List<Mudanca> getListaMudancasImplantadas() {
        mudancaDao = new MudancaDao();
        ArrayList<Mudanca> mudancaLista = new ArrayList<Mudanca>();
        mudancaLista = (ArrayList<Mudanca>) mudancaDao.listarMudancasImplantadas();
        return mudancaLista;
    }
    
    public void levantamentoMudancas(){
        setMudancasAbertas(getListaMudancaAbertas().size());
        setMudancasImplantadas(getListaMudancasImplantadas().size());
    }

    public int getMudancasAbertas() {
        return mudancasAbertas;
    }

    public void setMudancasAbertas(int mudancasAbertas) {
        this.mudancasAbertas = mudancasAbertas;
    }

    public int getMudancasImplantadas() {
        return mudancasImplantadas;
    }

    public void setMudancasImplantadas(int mudancasImplantadas) {
        this.mudancasImplantadas = mudancasImplantadas;
    }

}
