<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/fragments/header.jspf" %>

<section class="section-head">
    <div>
        <h1>Detalhes do tutor</h1>
        <p>Informações completas do tutor selecionado.</p>
    </div>
</section>

<div class="page-actions">
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/app?entidade=tutor&acao=listar">Voltar</a>
</div>

<div class="detail-card">
    <p><strong>ID:</strong> ${tutor.id}</p>
    <p><strong>Nome:</strong> ${tutor.nomeCompleto}</p>
    <p><strong>CPF:</strong> ${tutor.cpf}</p>
    <p><strong>Telefone:</strong> ${tutor.telefone}</p>
    <p><strong>Email:</strong> ${tutor.email}</p>
    <p><strong>Endereço:</strong> ${tutor.endereco}</p>
    <p><strong>Cidade:</strong> ${tutor.cidade}</p>
    <p><strong>Observações:</strong> ${tutor.observacoes}</p>
</div>

<%@ include file="/WEB-INF/views/fragments/footer.jspf" %>