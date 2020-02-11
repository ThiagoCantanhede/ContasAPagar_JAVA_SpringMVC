<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<body>
	
	<a href="logOut">LogOut</a>
	
    <table style="height: 10px; width: 775px;" border="1">
        <tr>
        <th>Código</th>
        <th>Descrição</th>
        <th>Valor</th>
        <th>Tipo</th>
        <th>Paga?</th>
        <th>Data de pagamento</th>
        </tr>

        <c:forEach items="${contas}" var="conta">
        <tr>
            <td>${conta.id}</td>
            <td>${conta.descricao}</td>
            <td>${conta.valor}</td>
            <td>${conta.tipo}</td>
            <td id="conta_${conta.id}">
                <c:if test="${conta.paga eq false}">
                    Não paga
                </c:if>
                <c:if test="${conta.paga eq true }">
                    Paga!
                </c:if>
            </td>
            <td><a href = "removeConta?id=${conta.id}">Remover Conta</a> </td>
            <td><a href = "#" onclick = "pagaAgora(${conta.id});">Pagar Conta</a> </td>
            <td><a href="mostraConta?id=${conta.id}">Alterar</a></td>
            <td><fmt:formatDate value="${conta.dataPagamento.time}" pattern="dd/MM/yyyy"/></td>
        </tr>        
        </c:forEach>
    </table>
    
<script src="resources/js/jquery.js"></script>
<script>
	function deuCerto(dadosDaResposta) {
	  alert("Conta paga com sucesso!");
	}
	//function pagaAgora(id) {
	//  $.get("pagaConta?id="+id);
	//}
	
	function pagaAgora(id) {
	$.get("pagaConta", {'id' : id}, function() {
	  $("#conta_"+id).html("Paga");
	});
	}	
</script>
</body>


</html>


