/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.helpdeskgi.controller;

import com.br.helpdeskgi.dao.IncidenteDao;
import com.br.helpdeskgi.entity.Incidente;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author rafacc
 */
@ManagedBean
@SessionScoped
public class ListaIncidenteController {

    private Incidente incidente;
    private IncidenteDao idao;
    private List<Incidente> incidenteLista;
    private List<Incidente> incidenteListaFechado;
    private Incidente incidenteSelecionado;

    public ListaIncidenteController() {
        incidenteLista = new ArrayList<Incidente>();
        idao = new IncidenteDao();
        incidenteLista = idao.listarIncidentes();
    }

    public Incidente getIncidenteSelecionado() {
        return incidenteSelecionado;
    }

    public void setIncidenteSelecionado(Incidente incidenteSelecionado) {
        this.incidenteSelecionado = incidenteSelecionado;
    }

    public List<Incidente> getIncidentes() {
        return incidenteLista;
    }
    
    public List<Incidente> getIncidentesFechados() {
        incidenteListaFechado = new ArrayList<Incidente>();
        for (int i = 0; i < incidenteLista.size(); i++) {
            if (incidenteLista.get(i).getStatus() == 1){
                incidenteListaFechado.add(incidenteLista.get(i));
            }
        }
        return incidenteListaFechado;
    }
    
    public List<Incidente> getIncidentesAbertos() {
        incidenteListaFechado = new ArrayList<Incidente>();
        for (int i = 0; i < incidenteLista.size(); i++) {
            if (incidenteLista.get(i).getStatus() == 0){
                incidenteListaFechado.add(incidenteLista.get(i));
            }
        }
        return incidenteListaFechado;
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
    
    public int calcularSLA(int prioridade, Date data_abertura){
        Long fimSLA = null;
        if (prioridade == 1) {
            fimSLA = data_abertura.getTime()+ 1;
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
    
    public String getNomePessoas(int id){
        return idao.retornaNome(id);
    }
    
    public String visualizarIncidente(String idChamado){
        return "buscar.xhtml";
    }
}
