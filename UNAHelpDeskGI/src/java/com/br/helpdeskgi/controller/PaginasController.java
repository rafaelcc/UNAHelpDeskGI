/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.helpdeskgi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author rafacc
 */
@ManagedBean
@SessionScoped
public class PaginasController {
    
    public String novoIncidente(){
        return "novoincidente.xhtml";
    }
    
    public String principal(){
        return "principal.xhtml";
    }
    
    public String listarIncidente(){
        return "listar.xhtml";
    }
    
    public String buscarIncidente(){
        return "buscar.xhtml";
    }
}
