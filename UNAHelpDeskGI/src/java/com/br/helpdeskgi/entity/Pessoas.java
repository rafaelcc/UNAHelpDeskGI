/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.helpdeskgi.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author rafacc
 */
@Entity
@Table(name = "db_atendente")
public class Pessoas implements Serializable{
    
    @Id
    @GeneratedValue
    private int id;
    
    @Column(name = "atendente", nullable = false, length = 45)
    private String atendente;
    
    @Column(name = "grupo", nullable = false, length = 45)
    private String grupo;

    public Pessoas() {
    }

    public Pessoas(String atendente, String grupo) {
        this.atendente = atendente;
        this.grupo = grupo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAtendente() {
        return atendente;
    }

    public void setAtendente(String atendente) {
        this.atendente = atendente;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}
