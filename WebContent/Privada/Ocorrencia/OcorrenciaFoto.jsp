<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<jsp:include page="../Fragmentos/Header.jsp"></jsp:include>
	<form action="OcorrenciaCon" method="post"
		enctype="multipart/form-data">
		<fieldset>
			<legend>Formulário:</legend>

			<div class="row">
				<div class="col-md-2">
					<label>ID</label> <input class="form-control" type="number"
						readonly="readonly" name="id" value="${obj.id}">
				</div>
			</div>

			<div class="row">
				<div class="col-md-5">
					<label>Título</label> <input class="form-control" type="text"
						name="titulo" readonly="readonly" value="${obj.titulo}">
				</div>
			</div>

			<div class="row">
				<div class="col-md-5">
					<label>Descrição</label> <input class="form-control" type="text"
						name="descricao" readonly="readonly" value="${obj.descricao}">
				</div>
			</div>

			<div class="row">
				<div class="col-md-5">
					<label>Latitude</label> <input class="form-control" type="text"
						name="lat" readonly="readonly" value="${obj.lat}">
				</div>
			</div>

			<div class="row">
				<div class="col-md-5">
					<label>Longitude</label> <input class="form-control" type="text"
						name="lon" readonly="readonly" value="${obj.lon}">
				</div>
			</div>

			<div class="row">
				<div class="col-md-2">

					<label>Foto</label> <input type="file" name="foto" /><br>


					<div id="areaImagem"></div>

					<br>

					<div id="areaImagemBD">
						<img name="imagemBD" id="imagemBD" width="300" height="300"
							src="data:image/jpg;base64,${obj.fotoBase64}" />
					</div>

				</div>
			</div>


			<button class="btn btn-primary" type="submit" name="gravarFoto">Gravar</button>
			<button class="btn btn-primary" type="submit" name="cancelar">Cancelar</button>

		</fieldset>
	</form>

</body>
</html>