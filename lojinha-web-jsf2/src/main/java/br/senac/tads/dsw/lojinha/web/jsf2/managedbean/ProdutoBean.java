/*
 * The MIT License
 *
 * Copyright 2016 Fernando.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.senac.tads.dsw.lojinha.web.jsf2.managedbean;

import br.senac.tads.dsw.lojinha.common.entity.Categoria;
import br.senac.tads.dsw.lojinha.common.entity.Produto;
import br.senac.tads.dsw.lojinha.common.service.ProdutoService;
import br.senac.tads.dsw.lojinha.common.service.fakeimpl.ProdutoServiceFakeImpl;
import br.senac.tads.dsw.lojinha.common.service.jpaimpl.ProdutoServiceJPAImpl;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Fernando
 */
@ManagedBean
@RequestScoped
public class ProdutoBean implements Serializable {

  // @ManagedProperty permite associar um parametro passado na requisição
  // Só funciona se bean usar @ManagedBean
  // Se não usar, tem que obter usando o FacesContext.getCurrentInstance.getRequestParameterMap()
  @ManagedProperty(value = "#{param.id}")
  private Long idProduto;

  public ProdutoBean() {
  }

  public List<Produto> getLista() {
    ProdutoService service = new ProdutoServiceJPAImpl();
    Categoria cat = new Categoria(2, "teste");
    return service.listarPorCategoria(new Categoria(2, "teste"),
            0, 4);
  }

  public Produto getProduto() {
    //FacesContext fc = FacesContext.getCurrentInstance();
    //return obter(getIdParam(fc));
    return obter(getIdProduto());
  }

  private Produto obter(long idProduto) {
    ProdutoService service = new ProdutoServiceFakeImpl();
    return service.obter(idProduto);
  }

//    private Long getIdParam(FacesContext fc) {
//        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
//        return Long.parseLong(params.get("id"));
//    }

  public Long getIdProduto() {
    return idProduto;
  }

  public void setIdProduto(Long idProduto) {
    this.idProduto = idProduto;
  }

}
