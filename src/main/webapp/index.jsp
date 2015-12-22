<html>
<head>
<script src="js/jquery-2.1.4.min.js"></script>
<title>XY-Inc | Home</title>
</head>
<body>
	<h2>Bem vindo ao sistema da XY-Inc!</h2>
	
	<div style="margin-bottom: 10px">
		<a href="cadastro.jsp">> Cadastro</a><br />
	</div>
	<div style="margin-bottom: 4px">
		Já cadastrados: <input style="margin-left: 10px" id="sendBtn" type="submit" value="Carregar"> 
						<input style="margin-left: 30px" id="filtrarBtn" type="submit" value="Filtrar">
	</div>
	
	<!-- Tabela 1 -->	
	<div style="display: inline-block;vertical-align: top">
		<table style="display: inline-block; margin-bottom: 30px; min-width: 183px" border="solid 1px">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>X</th>
					<th>Y</th>
				</tr>
			</thead>
			<tbody id="tabela1-body">
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<!-- Tabela 2 -->
	<div style="display: inline-block; margin-left: 30px">
		<table>
			<tr>
				<td>Distância-Máxima:</td>
				<td><input id="inputDist" type="text" name="nome"></td>
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
			style="display: inline-block; margin-bottom: 30px; min-width: 183px"
			border="solid 1px">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>X</th>
					<th>Y</th>
				</tr>
			</thead>
			<tbody id="tabela2-body">
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>


	<hr/>
	Web Services: <br/>
	<a href="rest/pontosDeInteresse/todos">	rest/pontosDeInteresse/todos </a> <br/>
	<a href="rest/pontosDeInteresse/proximos/2/2/100"> rest/pontosDeInteresse/proximos/X/Y/dMax</a>


	<script type="text/javascript">
		function populaTabelaBody(elemento, poi){
			elemento.append(
					"<tr> " + "<td>" + poi.id + "</td>"
					+ "<td>" + poi.nome + "</td>"
					+ "<td>" + poi.x + "</td>"
					+ "<td>" + poi.y + "</td>"
					+ "</tr>");
		}
		
		//btn todos
		$("#sendBtn").click(
				function() {
					$.ajax({
						type : "GET",
						contentType : "application/json;",
						url : "rest/pontosDeInteresse/todos",
						dataType : "json",
						success : function(data) {
							$("#tabela1-body").html("");
							jQuery.each(data, function(i, poi) {
								populaTabelaBody($("#tabela1-body"),poi);
							});
						}
					});
				});
		
		//btn filtro
		$("#filtrarBtn").click(
				function() {
					var urlStr = "rest/pontosDeInteresse/proximos/"; 
					urlStr+= $("#inputX").val() + "/";
					urlStr+= $("#inputY").val() + "/";
					urlStr+= $("#inputDist").val();
					
					$.ajax({
						type : "GET",
						contentType : "application/json;",
						url : urlStr,
						dataType : "json",
						success : function(data) {
							$("#tabela2-body").html("");
							jQuery.each(data, function(i, poi) {
								populaTabelaBody($("#tabela2-body"),poi);
							});
						}
					});
				});
		
	</script>

</body>
</html>
