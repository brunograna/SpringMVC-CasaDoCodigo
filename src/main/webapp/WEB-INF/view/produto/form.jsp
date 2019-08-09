<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:url value="/produtos" var="produtoAddUrl" />

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<form:form action="${s:mvcUrl('PC#salvar').build() }" method="POST" commandName="produto">
		
			<div>
				<label>Titulo:</label>
				<input type="text" name="titulo" />
				<form:errors path="titulo" />
				<br/>
			</div>
			
			<div>
				<label>Descrição:</label>
				<textarea rows="10" cols="15" name="descricao"></textarea>
				<form:errors path="descricao" />
				<br/>
			</div>
			
			<div>
				<label>Páginas:</label>
				<input type="text" name="paginas" />
				<form:errors path="paginas" />
				<br/>
			</div>
			
			<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
				<div>
					<label>${tipoPreco}</label>
					<input type="text" name="precos[${status.index }].valor">
					<input type="hidden" name="precos[${status.index }].tipo" value="${tipoPreco }">
				</div>
			</c:forEach>
			
			<button type="submit">Salvar novo produto</button>
		</form:form>
	</body>
</html>