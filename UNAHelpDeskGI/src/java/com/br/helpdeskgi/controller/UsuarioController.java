/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.helpdeskgi.controller;

import com.br.helpdeskgi.dao.UsuarioDao;
import com.br.helpdeskgi.entity.Usuario;
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
public class UsuarioController {
    
    private Usuario usuario;
    private UsuarioDao dao;
    private PaginasController paginas;
    
    public Usuario getUsuario() {
        if (this.usuario == null) {
            this.usuario = new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String autenticar() {
        dao = new UsuarioDao();
        Usuario validaLogin = dao.buscaLogin(usuario.getLogin());
        if (validaLogin != null) {
            String pass = usuario.getSenha().toString();
            if (pass.equals(validaLogin.getSenha())) {
                return "principal.xhtml";
            }
        } 
        FacesMessage fm = new FacesMessage("Usuario ou Senha invalidos");
        FacesContext.getCurrentInstance().addMessage("msg", fm);
        return null;
    }
}
