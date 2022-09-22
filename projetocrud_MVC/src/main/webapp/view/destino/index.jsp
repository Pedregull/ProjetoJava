<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.Destino" import="java.util.List"%>

<%
@SuppressWarnings("unchecked")
	List<Destino> lista = (List<Destino>) request.getAttribute("destino");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Destino</title>

<link rel="stylesheet" href="./css/style.css">

<!-- CDN CSS Bootstrap v-5.1 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>

	

	<!-- Inicio Menu Nav -->
	<section class="container-fluid bg-nav-container py-2">
		<header class="container">
			<nav class="navbar-nav navbar-dark">
				<div class="row">
					<div class="col">
						<h1 class="navbar-brand title-logo">Destino</h1>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<ul class="list-group list-group-horizontal  ajust-nav-sm">
							
							<li class="list-group-item">
								<a class="link" href="./index.html">Home</a>
							</li>
							<li class="list-group-item">
								<a class="link" href="./usuario">Usuarios</a>
							</li>
							<li class="list-group-item">
								<a class="link" href="./passagem">Passagens</a>
							</li>
							
							<li class="list-group-item">
								<a class="link" href="./destino">Destinos</a>
							</li>	
						</ul>
					</div>
				</div>
			</nav>
		</header>
	</section>
	<!-- final Menu Nav -->
	
	<header class="container-fluid bg-danger p-2">
		<h1 class="h3">Destinos</h1>
	</header>

	<header class="container my-4">
		<div class="row">
			<div class="col">
				<a class="btn btn-info" href="./view/destino/cadastrar.html">Cadastrar Destino</a>
				
			</div>

		</div>
	</header>



	<!-- Tabelas -->

	<table class="table container">
		<thead class="thead-dark">
			<tr>
				<th scope="col">ID do Destino</th>
				<th scope="col">Nome do Destino</th>
				
			</tr>
		</thead>
		<tbody>

		 	<%
			for (Destino a : lista) {
			%>
			<tr>
				
			
				<td><%=a.getId_destino()%></td>
				<td><%=a.getnome_destino()%></td>
						
				<td>
					<a class="btn btn-success" href="editar-destino?id=<%=a.getId_destino()%>">Atualizar Destino</a>
					<a class= "btn btn-danger" href="deletar-destino?id=<%=a.getId_destino()%>">Deletar Destino</a>
				</td>
				
				<%
					};
				%>
				
				</tr>
		</tbody>
	</table>

	<!-- CDN JS Bootstrap v-5.1 -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>