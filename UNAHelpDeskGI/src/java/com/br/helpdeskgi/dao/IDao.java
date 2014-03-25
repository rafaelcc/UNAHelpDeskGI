/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.helpdeskgi.dao;

import java.util.List;

/**
 *
 * @author rafacc
 */
public interface IDao {
    
    public void salvar(Object obj);
    public void alterar(Object obj);
    public void excluir(Object obj);
    public List<Object>listarTodos();
    
}
