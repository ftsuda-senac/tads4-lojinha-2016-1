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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * http://www.itcuties.com/j2ee/jsf-2-login-filter-example/
 *
 * @author Fernando
 */
@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {

  // OBS: Usuarios mantidos em um mapa somente como exemplo.
  // A validação deve ser feita com os dados armazenados no BD.
  private static final Map<String, UsuarioSistema> USUARIOS_CADASTRADOS;

  static {
    USUARIOS_CADASTRADOS = new HashMap<String, UsuarioSistema>();
    USUARIOS_CADASTRADOS.put("fulano", 
            new UsuarioSistema("fulano", "abcd1234", 
                    new String[]{"ADMIN", "BASICO"}));
    USUARIOS_CADASTRADOS.put("ciclano", 
            new UsuarioSistema("ciclano", "abcd1234", 
                    new String[]{"BASICO"}));
  }
  
  private String nome;
  private String senha;
  
  private UsuarioSistema usuario = null;
  
  public String autenticar() {
    UsuarioSistema usuario = validar(nome, senha);
    senha = "";
    if (usuario != null) {
      this.usuario = usuario;
      return "/admin/pagina-admin.xhtml?faces-redirect=true";
    }
    // Se der erro
    FacesMessage msg = new FacesMessage("Erro de login", "ERROR MSG");
    msg.setSeverity(FacesMessage.SEVERITY_ERROR);
    FacesContext.getCurrentInstance().addMessage(null, msg);
    return "login.xhtml?faces-redirect=true";
  }
  
  public String logout() {
    this.usuario = null;
    // Se der erro
    FacesMessage msg = new FacesMessage("Usuário fez logout", 
            "INFO MSG");
    msg.setSeverity(FacesMessage.SEVERITY_INFO);
    FacesContext.getCurrentInstance().addMessage(null, msg);
    return "/login.xhtml?faces-redirect=true";
  }
  
  private static UsuarioSistema validar(String nome, String senha) {
    UsuarioSistema usuario = USUARIOS_CADASTRADOS.get(nome);
    if (usuario != null && usuario.autenticar(nome, senha)) {
      return usuario;
    }
    return null;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public UsuarioSistema getUsuario() {
    return usuario;
  }

  public void setUsuario(UsuarioSistema usuario) {
    this.usuario = usuario;
  }

}
