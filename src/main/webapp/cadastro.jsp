<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/jquery-2.1.4.min.js"></script>
<title>XY-Inc | Cadastro</title>
</head>
<body>

	<form id="formulario" method="post">
		<table style="display: inline-block;">
			<tr>
				<td>Nome:</td>
				<td><input id="inputNome" type="text" name="nome"></td>
			</tr>
			<tr>
				<td>X:</td>
				<td><input id="inputX" type="text" name="x"></td>
			</tr>
			<tr>
				<td>Y:</td>
				<td><input id="inputY" type="text" name="y"></td>
			</tr>
		</table>
		<table
			style="display: inline-block; height: 80px; width: 320px; margin-left: 10px; border: solid 1px;">
			<tr>
				<td id="painel-resultado"></td>
			</tr>
		</table>
		<div style="margin-bottom:10px">
			<input id="sendBtn" type="submit" value="Cadastrar">
		</div>
		
		Web Service: <a href="rest/pontosDeInteresse/cadastro"> rest/pontosDeInteresse/cadastro </a> [POST]
	</form>

	<script type="text/javascript">
		function cadastraPOI() {

		}
		$("#formulario").submit(function() {
			$("#painel-resultado").text("Aguarde...");
			$("#painel-resultado").fadeIn();
			$.ajax({
				type : "POST",
				contentType: "application/json;",
				url : "rest/pontosDeInteresse/cadastro",
				dataType : "json",
				data : JSON.stringify({
					"nome":$("#inputNome").val(),
					"x":$("#inputX").val(),
					"y":$("#inputY").val(),
				}),
				success: function(data){
					$("#painel-resultado").text("Sucesso! id= " + data.id);
					$("#painel-resultado").fadeIn();
				},
				error: function(data){
					$("#painel-resultado").text("Erro: " + data.responseJSON);
					$("#painel-resultado").fadeIn();
				},
				
			});

			event.preventDefault();
		});
	</script>
</body>
</html>