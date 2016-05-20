/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.lojinha.web.jsf2.managedbean;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author fernando.tsuda
 */
@Named(value = "testeAjaxBean")
@Dependent
public class TesteAjaxBean {

  /**
   * Creates a new instance of TesteAjaxBean
   */
  public TesteAjaxBean() {
  }
  
  public List<String> getValores() {
    List<String> valores = new ArrayList<>();
    valores.add("Valor 1");
    valores.add("Valor 2");
    return valores;
  }
  
}
