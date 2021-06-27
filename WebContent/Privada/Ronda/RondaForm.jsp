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
	<form action="RondaCon" method="post">
		<fieldset>
			<legend>Adicionar Ronda:</legend>

			<div class="row">
				<div class="col-md-2">
					<label>ID</label> <input class="form-control" type="number"
						name="id" value="${obj.id}">
				</div>
			</div>



			<br><button class="fas fa-save" type="submit" name="gravar"> Gravar</button>
			<button class="fas fa-trash" type="submit"  name="cancelar"> Cancelar</button>

		</fieldset>
	</form>

</body>
</html>