package br.com.casadocodigo.loja.models;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.transaction.Transactional;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Produto {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String sumarioPath;
	private String titulo;
	@Lob
	private String descricao;
	private int paginas;
	@DateTimeFormat
	private Calendar dataLancamento;
	
	
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<Preco> precos;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}	
	public List<Preco> getPrecos() {
		return precos;
	}
	public void setPrecos(List<Preco> precos) {
		this.precos = precos;
	}	
	public Calendar getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	public String getSumarioPath() {
		return sumarioPath;
	}
	public void setSumarioPath(String sumarioPath) {
		this.sumarioPath = sumarioPath;
	}
	@Override
	public String toString() {
		return "Produto [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", paginas=" + paginas
				+ ", dataLancamento=" + dataLancamento + ", precos=" + precos + "]";
	}
	
		
}