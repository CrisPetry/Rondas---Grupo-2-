<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>GRUPO 2</title>

	<script src="../../Resources/jquery/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="../../Resources/jquery-confirm/jquery-confirm.min.css">
    <script src="../../Resources/jquery-confirm/jquery-confirm.min.js"></script> 	

	<link rel="stylesheet" href="../../resources/bootstrap/css/bootstrap.min.css">
	<script src="../../Resources/bootstrap/js/bootstrap.min.js"></script>

	<link href="../../Resources/fontawesome/css/all.css" rel="stylesheet">

	<link href="../../Resources/smartmenus/css/sm-core-css.css" rel="stylesheet" type="text/css"/>
	<link href="../../Resources/smartmenus/css/sm-mint/sm-mint.css" rel="stylesheet" type="text/css" />	
	    

	
	<link href="../../Resources/estilos.css" rel="stylesheet">
	
	<style>
		body{
		background-color: #dbf4fc;
		}
		
		h2{
		float: right;
		font-size: 1rem !important;
		}
		
		h3{
		text-align: center;
		}
	</style>
</head>
<body>
    <h3>Painel Administrativo</h3>
    <h2><i class='fa fa-user'>	${sessionScope.usuarioLogado.nome} </i> </h2>
    
	<nav class="main-nav">
	  <!-- Sample menu definition -->
	  <ul id="main-menu" class="sm sm-mint">
	    <li><a href="../Inicio/Inicio.jsp">Inicio</a></li>
	    <li><a href="#">Cadastros</a>
	      <ul>
	        <li><a href="../Ronda/RondaCon">Rondas</a></li>
	        <li><a href="../Pessoa/PessoaCon">Pessoas</a></li>
	        <li><a href="../Usuario/UsuarioCon">Usuarios</a></li>
	        <li><a href="../Localizacao/LocalizacaoCon">Localizações</a></li>
	        <li><a href="../Ocorrencia/OcorrenciaCon">Ocorrências</a></li>
	        <li><a href="../Locomocao/LocomocaoCon">Locomoções</a>
	      </ul>
	    </li>
	    	    <li><a href="#">Relatórios</a>
	      <ul>
	        <li><a href="../relatorios/RelRonda" target="_blank">Relatório de Rondas</a></li>
	        <li><a href="../relatorios/RelPessoa" target="_blank">Relatório de Pessoas</a></li>
	        <li><a href="../relatorios/RelUsuario" target="_blank">Relatório de Usuarios</a></li>
	        <li><a href="../relatorios/RelLocalizacao" target="_blank">Relatório de Localizações</a></li>
	        <li><a href="../relatorios/RelOcorrencia" target="_blank">Relatório de Ocorrências</a></li>
	        <li><a href="../relatorios/RelLocomocao" target="_blank">Relatório de Locomoções</a>
	      </ul>
	    </li>
	    <li> <a href= "${pageContext.request.contextPath}/Login.jsp">Sair</a></li>
	  </ul>
	</nav>


	<!-- SmartMenus jQuery plugin -->
	<script type="text/javascript"	src="../../Resources/smartmenus/jquery.smartmenus.js"></script>
	<!-- SmartMenus jQuery init -->
	<script type="text/javascript">
		$(function() {
			$('#main-menu').smartmenus({
				subMenusSubOffsetX : 1,
				subMenusSubOffsetY : -8
			});
		});
	</script>


</body>
</html>