<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/fragments/header.jspf" %>

<section class="section-head">
    <div>
        <h1>Detalhes da consulta</h1>
        <p>Informações completas da consulta selecionada.</p>
    </div>
</section>

<div class="page-actions">
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/app?entidade=consulta&acao=listar">Voltar</a>
</div>

<div class="detail-card">
    <p><strong>ID:</strong> ${consulta.id}</p>
    <p><strong>Pet ID:</strong> ${consulta.petId}</p>
    <p><strong>Data:</strong> ${consulta.dataConsulta}</p>
    <p><strong>Tipo:</strong> ${consulta.tipoConsulta}</p>
    <p><strong>Status:</strong> ${consulta.statusConsulta}</p>
    <p><strong>Valor:</strong> ${consulta.valor}</p>
    <p><strong>Observações:</strong> ${consulta.observacoes}</p>
</div>

<%@ include file="/WEB-INF/views/fragments/footer.jspf" %>