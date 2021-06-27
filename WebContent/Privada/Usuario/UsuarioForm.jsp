<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style>
legend {
	text-align: center;
	font-size: 1.5rem;
}

button:hover {
	cursor: pointer;
	background-color: #8db863;
}

fieldset {
	margin-top: 5rem;
}
</style>
</head>
<body>
	<jsp:include page="../Fragmentos/Header.jsp"></jsp:include>
	<form action="UsuarioCon" method="post">
		<fieldset>
			<legend>Adicionar Usuário:</legend>

			<div class="row">
				<div class="col-md-2">
					<label>ID</label> <input class="form-control" type="number"
						name="id" value="${obj.id}">
				</div>
				<div class="col-md-2">
					<label>E-mail</label> <input class="form-control" type="text"
						name="email" value="${obj.email}">
				</div>
				<div class="col-md-2">
					<label>Login</label> <input class="form-control" type="text"
						name="nome" value="${obj.nome}">
				</div>
				<div class="col-md-2">
					<label>Senha</label> <input class="form-control" type="text"
						name="senha" value="${obj.senha}">
				</div>
			</div>


			<br>
			<button class="fas fa-save" type="submit" name="gravar">
				Gravar</button>
			<button class="fas fa-trash" type="submit" name="cancelar">
				Cancelar</button>

		</fieldset>
	</form>

</body>
</html>