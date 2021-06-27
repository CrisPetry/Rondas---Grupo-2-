<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>

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
<body>
	<jsp:include page="../Fragmentos/Header.jsp"></jsp:include>

	<script type="text/javascript">
		function confirmar() {
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
							$("#excluir").attr("type", "submit");
							$("#excluir").click();
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
		<br> <br>
		<h1>LISTAGEM DE USUÁRIOS</h1>

		<form action="UsuarioCon">
			<button type="submit" name="incluir">
				<i class="fas fa-plus-circle"></i> Incluir
			</button>
			<br> <br>
			<table border="1" class="table table-hover table-condensed">
				<thead>
					<tr>
						<th>Id</th>
						<th>E-mail</th>
						<th>Nome</th>
						<th>Senha</th>
						<th>#</th>
						<th>Ações</th>
						<th>#</th>
					</tr>
				</thead>
				<c:forEach items="${lista}" var="p" varStatus="cont">
					<tr>
						<td>${p.id}</td>
						<td>${p.email}</td>
						<td>${p.nome}</td>
						<td>${p.senha}</td>

						<td><button type="submit" name="incluir" value="${p.id}"
								class="fas fa-plus-circle">Incluir</button></td>

						<td><button type="submit" name="alterar" value="${p.id}"
								class="fas fa-edit">Alterar</button></td>
						<td><button type="button" onclick="confirmar()" id="excluir"
								name="excluir" class="fas fa-trash" value="${p.id}">
								Excluir</button></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
</body>
</html>