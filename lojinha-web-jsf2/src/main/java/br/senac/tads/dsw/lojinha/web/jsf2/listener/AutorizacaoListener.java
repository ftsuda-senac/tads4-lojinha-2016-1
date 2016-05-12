/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.lojinha.web.jsf2.listener;

import br.senac.tads.dsw.lojinha.web.jsf2.entity.UsuarioSistema;
import br.senac.tads.dsw.lojinha.web.jsf2.managedbean.UsuarioBean;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author fernando.tsuda
 */
public class AutorizacaoListener implements PhaseListener {

  @Override
  public void afterPhase(PhaseEvent event) {
    FacesContext facesContext = event.getFacesContext();
    
    UsuarioBean usuarioBean = facesContext.getApplication()
            .evaluateExpressionGet(facesContext, 
                    "#{usuarioBean}", UsuarioBean.class);
    
    String paginaAtual = facesContext.getViewRoot().getViewId();

    NavigationHandler nh = facesContext.getApplication()
            .getNavigationHandler();
    if (paginaAtual.contains("/admin/")) {
      if (usuarioBean == null || usuarioBean.getUsuario() == null) {
        nh.handleNavigation(facesContext, null,
                "/login.xhtml?faces-redirect=true");
        return;
      }
      if (!verificarAcesso(usuarioBean.getUsuario(), paginaAtual)) {
        nh.handleNavigation(facesContext, null,
                "/erroNaoAutorizado.xhtml?faces-redirect=true");
        return;
      }
    }
  }
  
  private static boolean verificarAcesso(UsuarioSistema usuario, 
          String pagina) {
    if (pagina.lastIndexOf("produto-form.xhtml") > -1 &&
            usuario.autorizado("ADMIN")) {
      return true;
    }
    return false;
  }

  @Override
  public void beforePhase(PhaseEvent event) {

  }

  @Override
  public PhaseId getPhaseId() {
    return PhaseId.RESTORE_VIEW;
  }
  
}
