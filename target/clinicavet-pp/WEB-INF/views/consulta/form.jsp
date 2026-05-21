<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file="/WEB-INF/views/fragments/header.jspf" %>

<section class="section-head">
    <div>
        <h1>
            <c:choose>
                <c:when test="${not empty consulta.id}">Editar consulta</c:when>
                <c:otherwise>Nova consulta</c:otherwise>
            </c:choose>
        </h1>
        <p>Preencha os dados para agendar ou editar uma consulta.</p>
    </div>
</section>

<form class="form-card" method="post"
      action="${pageContext.request.contextPath}/app?entidade=consulta&acao=${not empty consulta.id ? 'atualizar' : 'salvar'}">

    <c:if test="${not empty consulta.id}">
        <input type="hidden" name="id" value="${consulta.id}">
    </c:if>

    <div class="form-grid">
        <label>Pet
            <select name="petId" required>
                <option value="">Selecione</option>
                <c:forEach var="pet" items="${pets}">
                    <option value="${pet.id}" ${not empty consulta.id and pet.id eq consulta.petId ? 'selected' : ''}>
                        ${pet.nome} (#${pet.id})
                    </option>
                </c:forEach>
            </select>
        </label>

        <label>Data e hora
            <input type="datetime-local" name="dataConsulta" value="${dataConsultaFormatada}" required>
        </label>

        <label>Tipo
            <input type="text" name="tipoConsulta" value="${consulta.tipoConsulta}" required>
        </label>

        <label>Status
            <input type="text" name="statusConsulta" value="${not empty consulta.id ? consulta.statusConsulta : 'Agendada'}">
        </label>

        <label>Valor
            <input type="number" step="0.01" name="valor" value="${consulta.valor}">
        </label>
    </div>

    <label>Observações
        <textarea name="observacoes" rows="4">${consulta.observacoes}</textarea>
    </label>

    <div class="hero-actions">
        <button class="btn btn-primary" type="submit">Salvar</button>
        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/app?entidade=consulta&acao=listar">Cancelar</a>
    </div>
</form>

<%@ include file="/WEB-INF/views/fragments/footer.jspf" %>
