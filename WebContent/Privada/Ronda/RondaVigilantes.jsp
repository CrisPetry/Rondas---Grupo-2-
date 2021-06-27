<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<style>
body {
	overflow-x: hidden;
}

td {
	height: 2rem !important;
}

table {
	text-align: center;
	width: 46%;
	border-collapse: collapse;
}

.conteiner {
	width: 100%;
	padding-left: 25rem;
}

h1 {
	font-size: 1rem;
}

button:hover {
	cursor: pointer;
	background-color: #8db863;
	color: #fff;
}
</style>




</head>
<body>
	<jsp:include page="../Fragmentos/Header.jsp"></jsp:include>

	<script type="text/javascript">
		function confirmar(excluir) {
			$.confirm({
				title : 'Confirmar',
				content : 'Confirmar a exclusão?',
				type : 'orange',
				typeAnimated : true,
				buttons : {
					Sim : {
						text : 'Sim',
						btnClass : 'btn-orange',
						action : function() {
							$(excluir).attr("type", "submit");
							excluir.click();
						}
					},
					Nao : {
						text : 'Não',
						btnClass : 'btn-dark',
						action : function() {
							// programar algo se clicou não
						}
					},
				}
			});

		}
	</script>

	<div class='conteiner'>
		<h1>LISTAGEM DE VIGILANTES DA RONDA</h1>

		<form action="RondaCon">

			<button type="submit" name="voltar">
				<i class="fas fa-arrow-left"></i> Voltar
			</button>
			<br> <br> <select name="vigilante">
				<c:forEach items="${pessoas}" var="p" varStatus="cont">
					<option value="${p.id}">${p.nome}</option>
				</c:forEach>
			</select>

			<button type="submit" name="incluirVigilante">
				<i class="fas fa-plus-circle"></i> Incluir
			</button>
			<br> <input type="hidden" name="idRonda" value="${obj.id}">


			<br>
			<table border="1" class="table table-hover table-condensed">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nome</th>
						<th>Login</th>
						<th>Ações</th>
					</tr>
				</thead>
				<c:forEach items="${obj.vigilantes}" var="p" varStatus="cont">
					<tr>
						<td>${p.id}</td>
						<td>${p.nome}</td>
						<td>${p.loginApp}</td>
						<td><button class='fas fa-trash' type="button" onclick="confirmar(this)"
								name="excluirVigilante" value="${p.id}"> Excluir</button></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
</body>
</html>