/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.lojinha.web.jsf2.managedbean;


import br.senac.tads.dsw.lojinha.web.jsf2.entity.UsuarioSistema;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * http://www.itcuties.com/j2ee/jsf-2-login-filter-example/
 *
 * @author Fernando
 */
public class UsuarioBean implements Serializable {

  // OBS: Usuarios mantidos em um mapa somente como exemplo.
  // A validação deve ser feita com os dados armazenados no BD.
  private static final Map<String, UsuarioSistema> USUARIOS_CADASTRADOS;

  static {
    USUARIOS_CADASTRADOS = new HashMap<String, UsuarioSistema>();
    USUARIOS_CADASTRADOS.put("fulano", new UsuarioSistema("fulano", "abcd1234", new String[]{"ADMIN", "BASICO"}));
    USUARIOS_CADASTRADOS.put("ciclano", new UsuarioSistema("ciclano", "abcd1234", new String[]{"BASICO"}));
  }

}
