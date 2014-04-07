/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.helpdeskgi.controller;

import com.br.helpdeskgi.dao.IncidenteDao;
import com.br.helpdeskgi.entity.Incidente;
import java.util.Date;
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
public class BuscaIncidenteController {

    private Incidente incidente;
    private IncidenteDao idao;
    private Incidente incidenteSelecionado;
    private String idIncidente;
    private String solicitante;
    private int novoStatus;
    private String novaDescricao;
    private int novoEscalonamento;
    private int novaPrioridade;

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

    public int getStatus() {
        return novoStatus;
    }

    public void setStatus(int status) {
        this.novoStatus = status;
    }

    public String getNovaDescricao() {
        return novaDescricao;
    }

    public void setNovaDescricao(String novaDescricao) {
        this.novaDescricao = novaDescricao;
    }

    public int getNovoEscalonamento() {
        return novoEscalonamento;
    }

    public void setNovoEscalonamento(int novoEscalonamento) {
        this.novoEscalonamento = novoEscalonamento;
    }

    public int getNovaPrioridade() {
        return novaPrioridade;
    }

    public void setNovaPrioridade(int novaPrioridade) {
        this.novaPrioridade = novaPrioridade;
    }

    public void buscaIncidentePeloId(String idIncidente) throws Exception {
        idao = new IncidenteDao();
        this.incidente = idao.buscarIncidenteId(idIncidente);
    }

    public Incidente getIncidentes() {
        return incidente;
    }

    public String getCategoriaNome(int categoria) {

        if (categoria == 1) {
            return "Aplicações Corporativas";
        } else if (categoria == 3) {
            return "Redes de Dados";
        } else if (categoria == 4) {
            return "Banco de Dados";
        } else if (categoria == 5) {
            return "Sistemas Operacionais";
        } else if (categoria == 6) {
            return "Business Intelligence";
        } else if (categoria == 7) {
            return "Segurança da Informação";
        } else {
            return "";
        }
    }

    public int calcularSLA(int prioridade, Date data_abertura) {
        Long fimSLA = null;
        if (prioridade == 1) {
            fimSLA = data_abertura.getTime() + 1;
        } else if (prioridade == 2) {
            fimSLA = data_abertura.getTime() + 2;
        } else if (prioridade == 3) {
            fimSLA = data_abertura.getTime() + 3;
        } else if (prioridade == 4) {
            fimSLA = data_abertura.getTime() + 4;
        }

        int SLA = (int) (fimSLA - data_abertura.getTime());

        return SLA;
    }

    public String getNomePessoas(int id) {
        return idao.retornaNome(id);
    }

    public String updateIncidente() {
        if (novaPrioridade != 0) {
            incidente.setPrioridade(novaPrioridade);
        }
        if (novoEscalonamento != 0) {
            incidente.setEscalonamento(novoEscalonamento);
        }
        incidente.setStatus(novoStatus);
        incidente.setDescricao(incidente.getDescricao() + " Upd: " + novaDescricao);
        idao.alterar(incidente);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Incidente Alterado", "Incidente Alterado"));
        return null;
    }

    public String deletarIncidente() {
        idao.excluir(incidente);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Incidente Deletado", "Incidente Deletado"));
        return "buscarincidentes.xhtml";
    }
}
