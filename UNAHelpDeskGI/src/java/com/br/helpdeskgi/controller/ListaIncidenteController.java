/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.helpdeskgi.controller;

import com.br.helpdeskgi.dao.IncidenteDao;
import com.br.helpdeskgi.entity.Incidente;
import java.util.ArrayList;
import java.util.Calendar;
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
    private List<Incidente> incidenteListaAberto;
    private List<Incidente> incidenteListaFechado;
    private List<Incidente> incidenteListaExportar;
    private Incidente incidenteSelecionado;
    private int quantidadeIncidentesAbertos;
    private int quantidadeIncidentesFechados;
    private int quantidadeIncidentesExportar;

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
        incidenteLista = new ArrayList<Incidente>();
        idao = new IncidenteDao();
        incidenteLista = idao.listarIncidentes();
        incidenteListaFechado = new ArrayList<Incidente>();
        for (int i = 0; i < incidenteLista.size(); i++) {
            if (incidenteLista.get(i).getStatus() == 1) {
                incidenteListaFechado.add(incidenteLista.get(i));
            }
        }
        return incidenteListaFechado;
    }

    public List<Incidente> getIncidentesAbertos() {
        incidenteLista = new ArrayList<Incidente>();
        idao = new IncidenteDao();
        incidenteLista = idao.listarIncidentes();
        incidenteListaAberto = new ArrayList<Incidente>();
        for (int i = 0; i < incidenteLista.size(); i++) {
            if (incidenteLista.get(i).getStatus() == 0) {
                incidenteListaAberto.add(incidenteLista.get(i));
            }
        }
        return incidenteListaAberto;
    }

    public List<Incidente> getIncidentesExportar() {
        incidenteLista = new ArrayList<Incidente>();
        idao = new IncidenteDao();
        incidenteLista = idao.listarIncidentes();
        incidenteListaExportar = new ArrayList<Incidente>();
        for (int i = 0; i < incidenteLista.size(); i++) {
            if (incidenteLista.get(i).getStatus() == 0 && incidenteLista.get(i).getEscalonamento() == 4) {
                incidenteListaExportar.add(incidenteLista.get(i));
            }
        }
        return incidenteListaExportar;
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
        long oneDay = 1 * 24 * 60 * 60 * 1000;
        long fimSLA;
        if (prioridade == 1) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(data_abertura);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            int SLA = ((((((int) (calendar.getTime().getTime() - data_abertura.getTime())) / 1000) / 60) / 60) / 24);
            SLA = (SLA * 100) / 24;
            return SLA;
        } else if (prioridade == 2) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(data_abertura);
            calendar.add(Calendar.DAY_OF_MONTH, 2);
            int SLA = ((((((int) (calendar.getTime().getTime() - data_abertura.getTime())) / 1000) / 60) / 60) / 24);
            SLA = (SLA * 100) / 48;
            return SLA;
        } else if (prioridade == 3) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(data_abertura);
            calendar.add(Calendar.DAY_OF_MONTH, 3);
            int SLA = ((((((int) (calendar.getTime().getTime() - data_abertura.getTime())) / 1000) / 60) / 60) / 24);
            SLA = (SLA * 100) / 72;
            return SLA;
        } else if (prioridade == 4) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(data_abertura);
            calendar.add(Calendar.DAY_OF_MONTH, 4);
            int SLA = ((((((int) (calendar.getTime().getTime() - data_abertura.getTime())) / 1000) / 60) / 60) / 24);
            SLA = (SLA * 100) / 96;
            return SLA;
        }

        return 0;
    }

    public String getNomePessoas(int id) {
        return idao.retornaNome(id);
    }

    public String visualizarIncidente(String idChamado) {
        return "buscar.xhtml";
    }

    public void levatamentoIncidentes() {
        setQuantidadeIncidentesAbertos(getIncidentesAbertos().size()); 
        setQuantidadeIncidentesFechados(getIncidentesFechados().size());
        setQuantidadeIncidentesExportar(getIncidentesExportar().size());
    }
    
    public int getQuantidadeIncidentesAbertos() {
        return quantidadeIncidentesAbertos;
    }

    public void setQuantidadeIncidentesAbertos(int quantidadeIncidentesAbertos) {
        this.quantidadeIncidentesAbertos = quantidadeIncidentesAbertos;
    }

    public int getQuantidadeIncidentesFechados() {
        return quantidadeIncidentesFechados;
    }

    public void setQuantidadeIncidentesFechados(int quantidadeIncidentesFechados) {
        this.quantidadeIncidentesFechados = quantidadeIncidentesFechados;
    }

    public int getQuantidadeIncidentesExportar() {
        return quantidadeIncidentesExportar;
    }

    public void setQuantidadeIncidentesExportar(int quantidadeIncidentesExportar) {
        this.quantidadeIncidentesExportar = quantidadeIncidentesExportar;
    }
    
    
}
