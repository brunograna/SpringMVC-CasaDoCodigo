<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<p>${sucesso }</p>
		<h1>Listagem de produtos</h1>
		<table border="1" cellpadding="10">
			<tr>
				<th>
					Id
				</th>
				<th>
					Titulo do produto
				</th>
				<th>
					Descricao
				</th>
				<th>
					Paginas
				</th>
				<th>
					Data de Lançamento
				</th>
				<th>
					Preço
				</th>
				<th>
					Ações
				</th>
			</tr>
			<c:forEach items="${produtos }" var="produto" varStatus="status">
			<tr>
				<td>
					${produto.id }
				</td>
				<td>
					${produto.titulo }
				</td>
				<td>
					${produto.descricao }
				</td>
				<td>
					${produto.paginas }
				</td>
				<td>
					<fmt:formatDate value="${produto.dataLancamento.time }" pattern="dd/MM/yyyy"/> 
				</td>		
				<td>			
					<c:if test="${produto.precos ne null }">
						<c:forEach items="${produto.precos }" var="tipoPreco">
							${tipoPreco.tipo } | R$ ${tipoPreco.valor } <br/>
						</c:forEach>				
					</c:if>
				</td>	
				<td>
					<a href="${s:mvcUrl('PC#detalhe').arg(0, produto.id).build() }">Visualizar</a>
				</td>
				
			</tr>
			</c:forEach>
		</table>
		<div>
			<a href="${s:mvcUrl('PC#form').build() }">Adicionar Produto</a>
		</div>
	</body>
</html>