<%@ page import="java.time.format.DateTimeFormatter" %>
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
                <th>ID</th><th>Pet</th><th>Data</th><th>Tipo</th><th>Status</th><th>Valor</th><th>Ações</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="consulta" items="${consultas}">
            <tr>
                <td>${consulta.id}</td>
                <td>${nomesPets[consulta.petId]}</td>
                <td>
                    ${consulta.dataConsulta.format(
                        DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm")
                    )}
                </td>
                <td>${consulta.tipoConsulta}</td>
                <td>
                    <span class="status-badge ${consulta.statusConsulta.toLowerCase()}">
                        ${consulta.statusConsulta}
                    </span>
                </td>
                <td>${consulta.valor}</td>
                <td class="actions">
                    <a class="link-btn" href="${pageContext.request.contextPath}/app?entidade=consulta&acao=buscarPorId&id=${consulta.id}">Ver</a>
                    <a class="link-btn" href="${pageContext.request.contextPath}/app?entidade=consulta&acao=editar&id=${consulta.id}">Editar</a>                    
                    <c:if test="${consulta.statusConsulta != 'FINALIZADA'}">
                        <a class="link-btn success"
                           href="${pageContext.request.contextPath}/app?entidade=consulta&acao=finalizar&id=${consulta.id}">
                            Finalizar
                        </a>
                    </c:if>                    
                    <form method="post"
                            action="${pageContext.request.contextPath}/app?entidade=consulta&acao=deletar&id=${consulta.id}"
                            class="inline-form"
                            onsubmit="return confirm('Deseja realmente excluir esta consulta?');">

                            <button class="link-btn danger" type="submit">
                                Excluir
                            </button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="/WEB-INF/views/fragments/footer.jspf" %>
