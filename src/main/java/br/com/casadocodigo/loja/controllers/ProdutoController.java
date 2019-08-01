package br.com.casadocodigo.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.casadocodigo.loja.models.Produto;

@Controller
public class ProdutoController {
	
	@RequestMapping("/produto/form")
	public String form() {
		return "produto/form";
	}
	
	@RequestMapping("/produto")
	public String salva(Produto produto) {
		System.out.println(produto);
		return "produto/sucesso";
	}
}
