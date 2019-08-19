package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.CarrinhoCompras;
import br.com.casadocodigo.loja.models.CarrinhoItem;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;

@Controller
@RequestMapping("/carrinho")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoCompraController {
	
	@Autowired
	private ProdutoDAO produtoDao;
	
	@Autowired
	private CarrinhoCompras carrinho;	
	
	private CarrinhoItem criaItem(Integer produtoId, TipoPreco tipo) {
		System.out.println(produtoId);
		Produto produto = produtoDao.find(produtoId);
		System.out.println(produto);
		CarrinhoItem carrinhoItem = new CarrinhoItem(tipo, produto);
		return carrinhoItem;
	}

	@RequestMapping("/add")
	public ModelAndView add(Integer produtoId, TipoPreco tipo) {
		ModelAndView mv = new ModelAndView("redirect:/produtos");
		CarrinhoItem carrinhoItem = criaItem(produtoId, tipo);
		carrinho.add(carrinhoItem);
		return mv;
	}
	
}
