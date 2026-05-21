<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file="/WEB-INF/views/fragments/header.jspf" %>

<section class="section-head">
    <div>
        <h1>
            <c:choose>
                <c:when test="${not empty tutor.id}">Editar tutor</c:when>
                <c:otherwise>Novo tutor</c:otherwise>
            </c:choose>
        </h1>
        <p>Cadastre ou atualize os dados do responsável pelo pet.</p>
    </div>
</section>

<form class="form-card" method="post"
      action="${pageContext.request.contextPath}/app?entidade=tutor&acao=${not empty tutor.id ? 'atualizar' : 'salvar'}">

    <c:if test="${not empty tutor.id}">
        <input type="hidden" name="id" value="${tutor.id}">
    </c:if>

    <div class="form-grid">
        <label>Nome completo<input type="text" name="nomeCompleto" value="${tutor.nomeCompleto}" required></label>
        <label>CPF<input type="text" name="cpf" value="${tutor.cpf}"></label>
        <label>Telefone<input type="text" name="telefone" value="${tutor.telefone}"></label>
        <label>Email<input type="email" name="email" value="${tutor.email}"></label>
        <label>Endereço<input type="text" name="endereco" value="${tutor.endereco}"></label>
        <label>Cidade<input type="text" name="cidade" value="${tutor.cidade}"></label>
    </div>

    <label>Observações
        <textarea name="observacoes" rows="4">${tutor.observacoes}</textarea>
    </label>

    <div class="hero-actions">
        <button class="btn btn-primary" type="submit">Salvar</button>
        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/app?entidade=tutor&acao=listar">Cancelar</a>
    </div>
</form>

<%@ include file="/WEB-INF/views/fragments/footer.jspf" %>
