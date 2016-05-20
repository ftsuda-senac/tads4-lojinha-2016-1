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

import br.senac.tads.dsw.lojinha.common.entity.Produto;
import br.senac.tads.dsw.lojinha.common.service.ProdutoService;
import br.senac.tads.dsw.lojinha.common.service.fakeimpl.ProdutoServiceFakeImpl;
import br.senac.tads.dsw.lojinha.common.service.jpaimpl.ProdutoServiceJPAImpl;
import br.senac.tads.dsw.lojinha.web.jsf2.entity.ProdutoQuantidade;
import br.senac.tads.dsw.lojinha.web.jsf2.util.Mensagem;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

/**
 *
 * @author Fernando
 */
@ManagedBean
@SessionScoped
public class CompraBean implements Serializable {

  //@ManagedProperty("#{produtoBean}")
  //private ProdutoBean produtoBean;
  private Set<ProdutoQuantidade> itens = new LinkedHashSet<ProdutoQuantidade>();

  private ProdutoQuantidade obterItem(Produto produto) {
    for (ProdutoQuantidade pq : itens) {
      if (pq.getProduto().equals(produto)) {
        return pq;
      }
    }
    return null;
  }

  public String adicionarProduto(long idProduto, int quantidade) {

    // Obtem objeto a partir do id
    ProdutoService produtoService = new ProdutoServiceJPAImpl();
    Produto p = produtoService.obter(idProduto);

    ProdutoQuantidade pq = obterItem(p);
    if (pq == null) {
      // Cria um novo item para o produto com a quantidade informada
      itens.add(new ProdutoQuantidade(p, quantidade));
    } else {
      // Altera a quantidade informada do produto
      pq.setQuantidade(quantidade);
    }

    // Mensagem de sucesso para usuário
    Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
    flash.put("mensagem", new Mensagem("Produto '" + p.getNome() + "' adicionado com sucesso", "success"));

    // Redireciona para a tela de listagem de produtos
    return "lista.xhtml?faces-redirect=true";
  }

  public List<ProdutoQuantidade> getItens() {
    List<ProdutoQuantidade> lista = new ArrayList<ProdutoQuantidade>();
    lista.addAll(itens);
    return lista;
  }

  public BigDecimal getValorTotal() {
    BigDecimal total = new BigDecimal(0);
    for (ProdutoQuantidade pq : itens) {
      total = total.add(pq.getPreco());
    }
    return total;
  }

}
