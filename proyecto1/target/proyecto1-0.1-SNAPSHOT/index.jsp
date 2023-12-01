<%@page import="org.banxico.proyecto1.entity.Actor"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Actores</title>
</head>
	<body>
		<div>
			<h3>Relacion de clientes</h3>
			<table border="1">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nombre</th>
						<th>Apellido</th>
					</tr>
				</thead>
				<tbody>
				<% 
					List<Actor> actores = (List<Actor>)request.getAttribute("actorsList");
					for (Actor actor : actores) {
				%>
					<tr>
						<td><%= actor.getActorId() %></td>
						<td><%= actor.getFirstName() %></td>
						<td><%= actor.getLastName() %></td>
					</tr>
				<% } %>
				</tbody>
			</table>
		</div>
	</body>
</html>