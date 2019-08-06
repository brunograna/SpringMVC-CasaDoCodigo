package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoDAO produtoDao;
	
	@RequestMapping("/produto/form")
	public String form() {
		return "produto/form";
	}
	
	@RequestMapping("/produto")
	public String salva(Produto produto) {
		System.out.println(produto);
		produtoDao.gravar(produto);
		return "produto/sucesso";
	}
}
