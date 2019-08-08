package br.com.casadocodigo.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoDAO produtoDao;
	
	@RequestMapping("/form")
	public ModelAndView form() {		
		ModelAndView modelandview = new ModelAndView("produto/form");
		
		modelandview.addObject("tipos", TipoPreco.values());
		
		return modelandview;
	}
	
	@RequestMapping( method = RequestMethod.GET )
	public ModelAndView listarProdutos() {
		ModelAndView modelandview = new ModelAndView("produto/listar");
		
		List<Produto> produtos = produtoDao.listar();		
		modelandview.addObject("produtos", produtos);
		
		return modelandview;
	}
	
	@RequestMapping( method = RequestMethod.POST )
	public ModelAndView salvar(Produto produto, RedirectAttributes redirectAttributes) {
		System.out.println(produto);
		produtoDao.gravar(produto);
		//Added the redirect attribute
		redirectAttributes.addFlashAttribute("sucesso", "Produto salvo com sucesso!");
		return new ModelAndView("redirect:produtos");
	}
}
