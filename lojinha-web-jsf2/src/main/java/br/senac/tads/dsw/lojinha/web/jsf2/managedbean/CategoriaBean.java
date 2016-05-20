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
import br.senac.tads.dsw.lojinha.common.service.CategoriaService;
import br.senac.tads.dsw.lojinha.common.service.fakeimpl.CategoriaServiceFakeImpl;
import br.senac.tads.dsw.lojinha.common.service.jpaimpl.CategoriaServiceJPAImpl;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Fernando
 */
@ManagedBean
@ApplicationScoped
public class CategoriaBean implements Serializable {

  public CategoriaBean() {
  }

  public List<Categoria> getLista() {
    CategoriaService service = new CategoriaServiceJPAImpl();
    return service.listar();
  }
}
