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
	
</head>
<body>

	<jsp:include page="/pages/components/header.jsp"/>
	
	<div id="content">
		 <div class="col-md-12">
		 		<div class="text-center">
		 			<img class="img-evol" src="${pageContext.request.contextPath}/resources/assets/img/photo.jpg"  width="400"/>
		 		</div>
		 </div>	
	</div>
	
	<jsp:include page="/pages/components/footer.jsp"/>

</body>
</html>