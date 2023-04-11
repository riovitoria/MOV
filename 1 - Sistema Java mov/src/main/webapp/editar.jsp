<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<meta charset="utf-8">
<title>Sistema de Transferência de Pessoal</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar Registro</h1>

	<form name="frmContato" action="update">

		<table>

			<tr>
				<td><input type="text" name="idcon" id="caixa3" readonly value="<%out.print(request.getAttribute("idcon"));%>"></td>
			</tr>

			<tr>
				<td><input type="text" name="nome" 
					class="Caixa1" value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>

			<tr>
				<td><input type="text" name="prio1" 
					class="Caixa2" value="<%out.print(request.getAttribute("prio1"));%>"></td>
			</tr>

			<tr>
				<td><input type="text" name="prio2" 
					class="Caixa2" value="<%out.print(request.getAttribute("prio2"));%>"></td>
			</tr>

			<tr>
				<td><input type="text" name="prio3" 
					class="Caixa2" value="<%out.print(request.getAttribute("prio3"));%>"></td>
			</tr>

			<tr>
				<td><input type="text" name="prio4" 
					class="Caixa2" value="<%out.print(request.getAttribute("prio4"));%>"></td>
			</tr>

			<tr>
				<td><input type="text" name="prio5" 
					class="Caixa2" value="<%out.print(request.getAttribute("prio5"));%>"></td>
			</tr>
		</table>

		<input type="button" value="Salvar" class="Botao1"
			onclick="validar()">
	</form>
	<script src="scripts/validador.js">
		
	</script>

</body>
</html>