<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/casadocodigo/produto" method="POST">
		<label>Titulo:</label>
		<input type="text" name="titulo" />
		
		<label>Descrição:</label>
		<textarea rows="10" cols="15" name="descricao"></textarea>
		
		<label>Páginas:</label>
		<input type="text" name="paginas" />
		
		<button type="submit">Salvar novo produto</button>
	</form>
</body>
</html>