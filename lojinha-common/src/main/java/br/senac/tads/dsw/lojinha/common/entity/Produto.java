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
package br.senac.tads.dsw.lojinha.common.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Fernando
 */
@Entity
@Table(name = "TB_PRODUTO")
@NamedQueries({
  @NamedQuery(name = "Produto.listarPorCategoria",
          query = "SELECT DISTINCT p FROM Produto p " // Espaço 
          + "LEFT JOIN FETCH p.categorias "           // antes
          + "LEFT JOIN FETCH p.imagens "              // das aspas
          + "INNER JOIN p.categorias c "
          + "WHERE c.id = :idCategoria"),
  @NamedQuery(name = "Produto.obter",
          query = "SELECT DISTINCT p FROM Produto p "
          + "LEFT JOIN FETCH p.categorias "
          + "LEFT JOIN FETCH p.imagens "
          + "WHERE p.id = :idProduto")
})
public class Produto implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_PRODUTO")
  private Long id;

  @Column(name = "NM_PRODUTO", nullable = false)
  private String nome;

  @Column(name = "DS_PRODUTO")
  private String descricao;

  @Column(name = "VL_PRODUTO", precision = 12,
          scale = 2, nullable = false)
  private BigDecimal preco;

  @Column(name = "DT_CADASTRO", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date dtCadastro;

  @ManyToMany
  @JoinTable(name = "TB_PRODUTO_CATEGORIA",
          joinColumns = {
            @JoinColumn(name = "ID_PRODUTO")
          },
          inverseJoinColumns = {
            @JoinColumn(name = "ID_CATEGORIA")
          })
  private List<Categoria> categorias;

  @OneToMany(mappedBy = "produto")
  private List<ImagemProduto> imagens;

  @Transient
  private List<ItemCompra> itensCompra;

  public Produto() {

  }

  public Produto(Long id, String nome, String descricao, BigDecimal preco, Date dtCadastro) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.preco = preco;
    this.dtCadastro = dtCadastro;
  }

  public Produto(Long id, String nome, String descricao, BigDecimal preco, Date dtCadastro, List<ImagemProduto> imagens, List<Categoria> categorias) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.preco = preco;
    this.dtCadastro = dtCadastro;
    this.imagens = imagens;
    this.categorias = categorias;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public BigDecimal getPreco() {
    return preco;
  }

  public void setPreco(BigDecimal preco) {
    this.preco = preco;
  }

  public Date getDtCadastro() {
    return dtCadastro;
  }

  public void setDtCadastro(Date dtCadastro) {
    this.dtCadastro = dtCadastro;
  }

  public List<Categoria> getCategorias() {
    return categorias;
  }

  public void setCategorias(List<Categoria> categorias) {
    this.categorias = categorias;
  }

  public List<ImagemProduto> getImagens() {
    return imagens;
  }

  public void setImagens(List<ImagemProduto> imagens) {
    this.imagens = imagens;
  }

  public List<ItemCompra> getItensCompra() {
    return itensCompra;
  }

  public void setItensCompra(List<ItemCompra> itensCompra) {
    this.itensCompra = itensCompra;
  }

  @Override
  public String toString() {
    return "Produto{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", dtCadastro=" + dtCadastro + ", categorias=" + categorias + ", imagens=" + imagens + '}';
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.id);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Produto other = (Produto) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }

}
