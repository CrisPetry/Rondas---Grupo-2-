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
	<form action="PessoaCon" method="post">
		<fieldset>
			<legend>Adicionar Pessoa:</legend>

			<div class="row">
				<div class="col-md-2">
					<label>ID</label> <input class="form-control" type="number"
						name="id" value="${obj.id}">
				</div>
			</div><br>

			<div class="row">
				<div class="col-md-5">
					<label>Nome</label> <input class="form-control" type="text"
						name="nome" value="${obj.nome}">
				</div>
			</div><br>
			
			<div class="row">
				<div class="col-md-5">
					<label>Login</label> <input class="form-control" type="text"
						name="loginApp" value="${obj.loginApp}">
				</div>
			</div><br>
			
			<div class="row">
				<div class="col-md-5">
					<label>Senha</label> <input class="form-control" type="text"
						name="senha" value="${obj.senha}">
				</div>
			</div><br>

			<br><button class="fas fa-save" type="submit" name="gravar"> Gravar</button>
			<button class="fas fa-trash" type="submit" name="cancelar"> Cancelar</button>

		</fieldset>
	</form>

</body>
</html>