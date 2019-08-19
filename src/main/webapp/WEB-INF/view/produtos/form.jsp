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
		<form:form action="${s:mvcUrl('PC#salvar').build() }" method="POST" commandName="produto" enctype="multipart/form-data">
		
			<div>
				<label>Titulo:</label>
				<form:input path="titulo" />
				<form:errors path="titulo" />
				<br/>
			</div>
			
			<div>
				<label>Descrição:</label>
				<form:textarea rows="10" cols="15" path="descricao" />
				<form:errors path="descricao" />
				<br/>
			</div>
			
			<div>
				<label>Páginas:</label>
				<form:input path="paginas" />
				<form:errors path="paginas" />
				<br/>
			</div>
			
			<div>
				<label>Data de lançamento</label>
				<form:input path="dataLancamento" />
				<form:errors path="dataLancamento" />
			</div>
			
			<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
				<div>
					<label>${tipoPreco}</label>
					<form:input path="precos[${status.index }].valor" />
					<form:hidden path="precos[${status.index }].tipo" value="${tipoPreco }" />
				</div>
			</c:forEach>
			
			<div>
				<label>Sumário</label>
				<input type="file" name="sumario" />
			</div>
			
			<button type="submit">Salvar novo produto</button>
		</form:form>
	</body>
</html>