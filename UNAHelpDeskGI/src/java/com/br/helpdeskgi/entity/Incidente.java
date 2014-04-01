/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.helpdeskgi.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.metamodel.SingularAttribute;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author rafacc
 */
@Entity
@Table(name = "db_incidentes")
public class Incidente implements Serializable {

    @Id
    @GeneratedValue(generator = "UUIDGenerator")
    @GenericGenerator(name = "UUIDGenerator", strategy = "com.br.helpdeskgi.controller.UUIDGenerator")
    @Column(name = "idchamado", columnDefinition = "char", length = 36)
    private String idChamado;

    @Column(name = "categoria", nullable = false)
    private int categoria;

    @Column(name = "db_atendente_id", nullable = false)
    private int db_atendente_id;

    @Column(name = "db_solicitante_id", nullable = false)
    private int db_solicitante_id;

    @Column(name = "descricao", nullable = false, length = 150)
    private String descricao;

    @Column(name = "data_abertura", nullable = false)
    @Temporal(value =TemporalType.DATE )
    private Date data_abertura;

    @Column(name = "escalonamento", nullable = false)
    private int escalonamento;

    @Column(name = "prioridade", nullable = false)
    private int prioridade;
    
    @Column(name = "status")
    private int status;

    public Incidente() {
    }

    public Incidente(String idChamado, int categoria, int db_atendente_id, int db_solicitante_id, String descricao, Date data_abertura, int escalonamento, int prioridade) {
        this.idChamado = idChamado;
        this.categoria = categoria;
        this.db_atendente_id = db_atendente_id;
        this.db_solicitante_id = db_solicitante_id;
        this.descricao = descricao;
        this.data_abertura = data_abertura;
        this.escalonamento = escalonamento;
        this.prioridade = prioridade;
    }

    public Incidente(String idChamado, int categoria, int db_atendente_id, int db_solicitante_id, String descricao, Date data_abertura, int escalonamento, int prioridade, int status) {
        this.idChamado = idChamado;
        this.categoria = categoria;
        this.db_atendente_id = db_atendente_id;
        this.db_solicitante_id = db_solicitante_id;
        this.descricao = descricao;
        this.data_abertura = data_abertura;
        this.escalonamento = escalonamento;
        this.prioridade = prioridade;
        this.status = status;
    }
    
    public String getIdChamado() {
        return UUID.fromString(idChamado).toString();
    }

    public void setIdChamado(String idChamado) {
        this.idChamado = idChamado;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getDb_atendente_id() {
        return db_atendente_id;
    }

    public void setDb_atendente_id(int db_atendente_id) {
        this.db_atendente_id = db_atendente_id;
    }

    public int getDb_solicitante_id() {
        return db_solicitante_id;
    }

    public void setDb_solicitante_id(int db_solicitante_id) {
        this.db_solicitante_id = db_solicitante_id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData_abertura() {
        return data_abertura;
    }

    public void setData_abertura(Date data_abertura) {
        this.data_abertura = data_abertura;
    }

    public int getEscalonamento() {
        return escalonamento;
    }

    public void setEscalonamento(int escalonamento) {
        this.escalonamento = escalonamento;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
