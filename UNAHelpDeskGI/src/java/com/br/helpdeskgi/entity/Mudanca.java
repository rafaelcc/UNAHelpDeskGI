/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.helpdeskgi.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rafacc
 */
@Entity
@Table(name = "db_mudancas")
public class Mudanca implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "id_chamado", columnDefinition = "char", length = 36)
    private String idChamado;

    @Column(name = "data_implantacao", nullable = false)
    @Temporal(value =TemporalType.DATE )
    private Date dataImplantacao;
    
    @Column(name = "responsavel", nullable = false)
    private int responsavel;

    @Column(name = "problema_conhecido", nullable = false, length = 150)
    private String problemaConhecido;

    @Column(name = "causa_raiz", nullable = false, length = 150)
    private String causaRaiz;

    @Column(name = "solucao_definitiva", nullable = false, length = 150)
    private String solucaoDefinitiva;

    @Column(name = "plano_implantacao", nullable = false, length = 150)
    private String planoImplantacao;

    @Column(name = "plano_rollback", nullable = false, length = 150)
    private String planoRollback;

    public Mudanca() {
    }
    
    public Mudanca(int id, String idChamado, Date dataImplantacao, int responsavel, String problemaConhecido, String causaRaiz, String solucaoDefinitiva, String planoImplantacao, String planoRollback) {
        this.id = id;
        this.idChamado = idChamado;
        this.dataImplantacao = dataImplantacao;
        this.responsavel = responsavel;
        this.problemaConhecido = problemaConhecido;
        this.causaRaiz = causaRaiz;
        this.solucaoDefinitiva = solucaoDefinitiva;
        this.planoImplantacao = planoImplantacao;
        this.planoRollback = planoRollback;
    }
    
    public String getIdChamado() {
        return idChamado;
    }

    public void setIdChamado(String idChamado) {
        this.idChamado = idChamado;
    }

    public Date getDataImplantacao() {
        return dataImplantacao;
    }

    public void setDataImplantacao(Date dataImplantacao) {
        this.dataImplantacao = dataImplantacao;
    }

    public int getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(int responsavel) {
        this.responsavel = responsavel;
    }

    public String getProblemaConhecido() {
        return problemaConhecido;
    }

    public void setProblemaConhecido(String problemaConhecido) {
        this.problemaConhecido = problemaConhecido;
    }

    public String getCausaRaiz() {
        return causaRaiz;
    }

    public void setCausaRaiz(String causaRaiz) {
        this.causaRaiz = causaRaiz;
    }

    public String getSolucaoDefinitiva() {
        return solucaoDefinitiva;
    }

    public void setSolucaoDefinitiva(String solucaoDefinitiva) {
        this.solucaoDefinitiva = solucaoDefinitiva;
    }

    public String getPlanoImplantacao() {
        return planoImplantacao;
    }

    public void setPlanoImplantacao(String planoImplantacao) {
        this.planoImplantacao = planoImplantacao;
    }

    public String getPlanoRollback() {
        return planoRollback;
    }

    public void setPlanoRollback(String planoRollback) {
        this.planoRollback = planoRollback;
    }
    
    

    
}
