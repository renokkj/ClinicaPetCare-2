<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file="/WEB-INF/views/fragments/header.jspf" %>

<section class="section-head">
    <div>
        <h1>Consultas</h1>
        <p>Acompanhe os agendamentos e o status dos atendimentos.</p>
    </div>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/app?entidade=consulta&acao=formNovo">Nova consulta</a>
</section>

<div class="table-card">
    <table>
        <thead>
            <tr>
                <th>ID</th><th>Pet ID</th><th>Data</th><th>Tipo</th><th>Status</th><th>Valor</th><th>Ações</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="consulta" items="${consultas}">
            <tr>
                <td>${consulta.id}</td>
                <td>${consulta.petId}</td>
                <td>${consulta.dataConsulta}</td>
                <td>${consulta.tipoConsulta}</td>
                <td>${consulta.statusConsulta}</td>
                <td>${consulta.valor}</td>
                <td class="actions">
                    <a class="link-btn" href="${pageContext.request.contextPath}/app?entidade=consulta&acao=buscarPorId&id=${consulta.id}">Ver</a>
                    <a class="link-btn" href="${pageContext.request.contextPath}/app?entidade=consulta&acao=editar&id=${consulta.id}">Editar</a>
                    <form method="post" action="${pageContext.request.contextPath}/app?entidade=consulta&acao=deletar&id=${consulta.id}" class="inline-form">
                        <button class="link-btn danger" type="submit">Excluir</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="/WEB-INF/views/fragments/footer.jspf" %>
