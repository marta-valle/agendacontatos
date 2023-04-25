<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Agenda de Contatos</title>
  
  <!-- Incluindo o componente para controle de cache -->
  <jsp:include page="/WEB-INF/views/components/cache-control.jsp"/>
  
  <!-- Adiciona os arquivos CSS do Bootstrap -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.2/css/bootstrap.min.css"/>

</head>
<body>
  
  <!-- Incluindo o componente navbar -->
  <jsp:include page="/WEB-INF/views/components/navbar.jsp"/>

  <!-- Cards -->
  <div class="container mt-4">
  
  	<div class="mt-4 mb-4">
  	
  		<h5>Consulta de Contatos</h5>
  		<p>Listagem de contatos cadastrados em sua agenda</p>
  		<hr/>
  		
  		<div class="table-responsive">
  		
  			<%@page import="br.com.cotiinformatica.entities.Contato" %>
  			<%@page import="java.util.List" %>
  			<%
  				List<Contato> contatos = (List<Contato>) request.getAttribute("contatos");
  			%>
  		
  			<table class="table table-sm">
  				<thead>
  					<tr>
  						<th>Nome do contato</th>
  						<th>Telefone</th>
  						<th>Email</th>
  						<th>Observações</th>
  						<th>Operações</th>
  					</tr>
  				</thead>
  				<tbody>
  				
  					<% for(Contato contato : contatos) { %>
  				
  					<tr>
  						<td><%= contato.getNome() %></td>
  						<td><%= contato.getTelefone() %></td>
  						<td><%= contato.getEmail() %></td>
  						<td><%= contato.getObservacoes() %></td>
  						<td>
  							<a href="#" class="btn btn-outline-primary btn-sm">
  								Editar
  							</a>
  							<a href="#" class="btn btn-outline-danger btn-sm">
  								Excluir
  							</a>
  						</td>
  					</tr>
  					
  					<% } %>
  					
  				</tbody>
  			</table>
  		
  		</div>
  		
  	</div>
  	
  </div>  
    
  <!-- Adiciona os arquivos JavaScript do Bootstrap -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.2/js/bootstrap.min.js"></script>

 </body>
 </html>


