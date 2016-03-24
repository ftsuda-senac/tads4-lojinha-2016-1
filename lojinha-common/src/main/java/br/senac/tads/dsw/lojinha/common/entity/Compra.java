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
import java.util.Date;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class Compra implements Serializable {

  private Long id;

  private Date dataCompra;

  private Cliente usuario;

  private List<ItemCompra> itensCompra;

  public Compra() {

  }

  public Compra(Long id, Date dataCompra, Cliente usuario) {
    this.id = id;
    this.dataCompra = dataCompra;
    this.usuario = usuario;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getDataCompra() {
    return dataCompra;
  }

  public void setDataCompra(Date dataCompra) {
    this.dataCompra = dataCompra;
  }

  public Cliente getUsuario() {
    return usuario;
  }

  public void setUsuario(Cliente usuario) {
    this.usuario = usuario;
  }

  public List<ItemCompra> getItensCompra() {
    return itensCompra;
  }

  public void setItensCompra(List<ItemCompra> itensCompra) {
    this.itensCompra = itensCompra;
  }

  @Override
  public String toString() {
    return "Compra{" + "id=" + id + ", dataCompra=" + dataCompra + ", usuario=" + usuario + ", itensCompra=" + itensCompra + '}';
  }

}
