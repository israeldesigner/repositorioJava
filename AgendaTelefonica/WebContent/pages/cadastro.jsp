<%@page import="br.edu.evolucao.bean.Contato"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
</head>
<body>

	<jsp:include page="/pages/components/header.jsp"/>
	
	<div id="content">
	
		<% 
			Contato contato = (Contato) request.getAttribute("contato");
			boolean olhando = (contato != null);
		%>
	
		<form action="${pageContext.request.contextPath}/add" method="post">
			<% if (olhando) { %>
				<input type="hidden" value="<%=contato.getId()%>" name="contatoId">
			<% } %>
	
			<fieldset>
				<legend>Cadastro de Contato</legend>
				<div class="form-group">
							<label for="nomeContato" class="control-label">
								Nome: 
							</label>
							<% if (olhando) { %>
								<input id="nomeContato" type="text" name="nome" class="form-control"
								placeholder="Nome" value="<%=contato.getNome()%>"/>
							<% } else { %>
								<input id="nomeContato" type="text" class="form-control"
								 name="nome" placeholder="Nome"/>
							<% } %>											


							<label for="emailContato" class="control-label">
								E-mail: 
							</label>
		
							<% if (olhando) { %>
								<input id="emailContato" type="email" name="email" class="form-control"
											placeholder="E-mail" value="<%=contato.getEmail()%>"/>
							<% } else { %>
								<input id="emailContato" type="email" name="email" class="form-control"
											placeholder="E-mail"/>
							<% } %>	

							<label for="telefoneContato">
								Telefone: 
							</label>
							<% if (olhando) { %>
								<input id="telefoneContato" type="text" name="telefone" class="form-control"
											placeholder="Telefone" value="<%=contato.getTelefone()%>"/>
							<% } else { %>
								<input id="telefoneContato" type="text" name="telefone" class="form-control"
											placeholder="Telefone"/>
							<% } %>
				</div>
				<div class="form-group">
					<input type="submit" value="Salvar" class="btn btn-info"/>
					<input type="reset" value="Limpar" class="btn btn-warning"/>
				</div>
		
			</fieldset>
	
		</form>
	
	</div>
	
	<jsp:include page="/pages/components/footer.jsp"/>

</body>
</html>