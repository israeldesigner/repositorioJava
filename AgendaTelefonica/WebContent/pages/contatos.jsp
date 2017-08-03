<%@page import="br.edu.evolucao.bean.Contato"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%-- <%@ include file="" %> --%>
<%-- <%@ taglib uri="" prefix=""%> --%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8"/>
	<title>Agenda Telefônica</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/assets/css/style.css">
	<script src="${pageContext.request.contextPath}/resources/assets/js/jquery-1.9.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.min.js"></script>	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

	<jsp:include page="/pages/components/header.jsp"/>
	
	<div id="content">
	
		<form method="post" action="${pageContext.request.contextPath}/list">
			<fieldset>
				<legend>Pesquisar Contatos</legend>
				
				 <div class="form-inline">
					<input id="nomeContato" type="text" name="nome" class="form-control" placeholder="Nome"/>					
					<button type="submit" value="Pesquisar" class="btn btn-success">
						<i class="glyphicon glyphicon-search"></i> Pesquisar
					</button>
  				</div>			
				
			</fieldset>
		</form>
		
		
		<% List<Contato> contatos = (List<Contato>)request.getAttribute("contatos"); %>
		<% if (contatos != null && !contatos.isEmpty()) { %>
		
			<div class="col-md-12">
			<hr>
					<hr>
						<h4>Lista de Contatos</h4>
						<table class=" table table-list table-condensed">
				<tr>
					<th>Nome</th>
					<th>E-mail</th>
					<th>Telefone</th>
					<th class="text-center">Ações</th>
				</tr>
				
				<% for (int i = 0 ; i < contatos.size() ; i++) { %>
					<tr>
						<td><%=contatos.get(i).getNome() %></td>
						<td><%=contatos.get(i).getEmail() %></td>
						<td><%=contatos.get(i).getTelefone() %></td>
						<td>
						<span>
							<form  class="acao-inline" style="display:inline-flex;"action="${pageContext.request.contextPath}/contatoAction" class="btn-block">
								<button type="submit" class="btn btn-warning">
									<i class="glyphicon glyphicon-pencil"></i>
								</button>
								<input type="hidden" value="<%=contatos.get(i).getId()%>"  name="olharId"/>
							</form>
						 	<form class="acao-inline" style="display:inline-flex;" action="${pageContext.request.contextPath}/contatoAction">
								<button type="submit" class="btn btn-danger"/>
								 	   <i class="glyphicon glyphicon-trash"></i>
								</button>
								<input type="hidden" value="<%=contatos.get(i).getId()%>" name="excluirId"/> 
							</form>
						</span>						
						</td>
					</tr>
				<% } %>
				
			</table>
		
			</div>

		<% } else { %>
		
			<% if (contatos != null && contatos.isEmpty()) { %>
				<br/>
				<div class="col-md-12">				
					<div class="alert alert-danger" role="alert">
						<i class="glyphicon glyphicon-alert"></i> Nenhum registro encontrado
					</div>					
				</div>
				<br/>
			<% } %>
		
		<% } %>
		
	
	</div>
	
	<jsp:include page="/pages/components/footer.jsp"/>

</body>
</html>