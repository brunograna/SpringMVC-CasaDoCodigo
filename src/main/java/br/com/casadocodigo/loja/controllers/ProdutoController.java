package br.com.casadocodigo.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoDAO produtoDao;
	
	@RequestMapping("/produto/form")
	public ModelAndView form() {		
		ModelAndView modelandview = new ModelAndView("produto/form");
		
		modelandview.addObject("tipos", TipoPreco.values());
		
		return modelandview;
	}
	
	@RequestMapping("/produto/all")
	public ModelAndView listarProdutos() {
		ModelAndView modelandview = new ModelAndView("produto/listar");
		
		List<Produto> produtos = produtoDao.listarTodos();		
		modelandview.addObject("produtos", produtos);
		
		return modelandview;
	}
	
	@RequestMapping("/produto")
	public String salva(Produto produto) {
		System.out.println(produto);
		produtoDao.gravar(produto);
		return "produto/sucesso";
	}
}
