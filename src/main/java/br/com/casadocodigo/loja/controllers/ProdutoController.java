package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;
import br.com.casadocodigo.loja.validators.ProdutoValidator;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoDAO produtoDao;
	@Autowired
	private FileSaver fileSaver;
	@Autowired
	private HttpServletRequest request;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ProdutoValidator());
	}
	
	@RequestMapping("/form")
	public ModelAndView form(Produto produto) {		
		ModelAndView modelandview = new ModelAndView("produtos/form");
		
		modelandview.addObject("tipos", TipoPreco.values());
		
		return modelandview;
	}
	
	@RequestMapping( method = RequestMethod.GET )
	public ModelAndView listarProdutos() {
		ModelAndView modelandview = new ModelAndView("produtos/listar");
		
		List<Produto> produtos = produtoDao.listar();		
		modelandview.addObject("produtos", produtos);
		
		return modelandview;
	}
	
	@RequestMapping( method = RequestMethod.POST )
	public ModelAndView salvar(MultipartFile sumario , @Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes) {

		System.out.println(sumario.getOriginalFilename());
		
		if(result.hasErrors()) {
			redirectAttributes.addFlashAttribute("errors", result.getAllErrors());
			System.out.println(result.getAllErrors().toString());
			return form(produto);
		}
		
		String path = fileSaver.write("arquivos-sumario", sumario);
		produto.setSumarioPath(path);
		
		System.out.println(produto);
		produtoDao.gravar(produto);
		//Added the redirect attribute
		redirectAttributes.addFlashAttribute("sucesso", "Produto salvo com sucesso!");
		return new ModelAndView("redirect:produtos");
	}
	
	@RequestMapping("/detalhe/{id}")
	public ModelAndView detalhe(@PathVariable("id") Integer id) {
		System.out.println(request.getServletContext().getRealPath(""));
		ModelAndView mv = new ModelAndView("produtos/detalhe");
		Produto produto = produtoDao.find(id);
		mv.addObject("produto", produto);
		return mv;
	}
	
	
}