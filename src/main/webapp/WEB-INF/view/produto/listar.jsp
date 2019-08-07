<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Listagem de produtos</h1>
	<table>
		<tr>
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
				Preço
			</th>
		</tr>
		<c:forEach items="${produtos }" var="produto" varStatus="status">
		<tr>
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
				<c:if test="${produto.precos ne null }">
					<c:forEach items="${produto.precos }" var="tipoPreco">
						${tipoPreco.valor }
					</c:forEach>				
				</c:if>
			</td>	
		</tr>
		</c:forEach>
	</table>
</body>
</html>