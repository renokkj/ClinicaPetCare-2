<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/fragments/header.jspf" %>

<section class="section-head">
    <div>
        <h1>Detalhes da consulta</h1>
        <p>Informações completas da consulta selecionada.</p>
    </div>
</section>

<div class="page-actions">
    <a class="btn btn-secondary"
       href="${pageContext.request.contextPath}/app?entidade=consulta&acao=listar">
        Voltar
    </a>
</div>

<div class="detail-card">

    <p>
        <strong>ID:</strong>
        ${consulta.id}
    </p>

    <p>
        <strong>Pet ID:</strong>
        ${consulta.petId}
    </p>

    <p>
        <strong>Data:</strong>
        ${consulta.dataConsulta}
    </p>

    <p>
        <strong>Tipo:</strong>
        ${consulta.tipoConsulta}
    </p>

    <p>
        <strong>Status:</strong>
        ${consulta.statusConsulta}
    </p>

    <p>
        <strong>Valor:</strong>
        R$ ${consulta.valor}
    </p>

    <p>
        <strong>Observações:</strong>
        ${consulta.observacoes}
    </p>

    <hr style="margin: 25px 0; border: 1px solid #d5e8db;">

    <h3 style="margin-bottom: 18px; color: #146746;">
        Serviços adicionais
    </h3>

    <div class="decorator-box">

        <h3>Serviços adicionais</h3>

        <ul class="decorator-list">
            <li>✓ Consulta veterinária</li>
            <li>✓ Exames laboratoriais</li>
            <li>✓ Vacinação</li>
        </ul>

        <div class="decorator-values">
            <p><strong>Valor base:</strong> R$ 100.0</p>
            <p><strong>Adicionais:</strong> R$ 170.0</p>
            <p class="total">
                <strong>Total final:</strong>
                R$ ${custoAtendimento}
            </p>
        </div>

    </div>

</div>

<%@ include file="/WEB-INF/views/fragments/footer.jspf" %>