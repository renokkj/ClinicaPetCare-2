<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file="/WEB-INF/views/fragments/header.jspf" %>

<section class="section-head">
    <div>
        <h1>
            <c:choose>
                <c:when test="${not empty pet.id}">Editar pet</c:when>
                <c:otherwise>Novo pet</c:otherwise>
            </c:choose>
        </h1>
        <p>Cadastre ou atualize os dados do pet.</p>
    </div>
</section>

<form class="form-card" method="post"
      action="${pageContext.request.contextPath}/app?entidade=pet&acao=${not empty pet.id ? 'atualizar' : 'salvar'}">

    <c:if test="${not empty pet.id}">
        <input type="hidden" name="id" value="${pet.id}">
    </c:if>

    <div class="form-grid">
        <label>Nome<input type="text" name="nome" value="${pet.nome}" required></label>
        <label>Espécie<input type="text" name="especie" value="${pet.especie}" required></label>
        <label>Raça<input type="text" name="raca" value="${pet.raca}"></label>
        <label>Sexo<input type="text" name="sexo" value="${pet.sexo}"></label>
        <label>Cor<input type="text" name="cor" value="${pet.cor}"></label>
        <label>Data de nascimento<input type="date" name="dataNascimento" value="${dataNascimentoFormatada}"></label>
        <label>Peso<input type="number" step="0.01" name="peso" value="${pet.peso}"></label>
        <label>Porte<input type="text" name="porte" value="${pet.porte}"></label>
        <label>Número do microchip<input type="text" name="numeroMicrochip" value="${pet.numeroMicrochip}"></label>
        <label>
            Status vacinal

            <select name="statusVacinal">

                <option value="Em dia"
                    ${pet.statusVacinal == 'Em dia' ? 'selected' : ''}>
                    Em dia
                </option>

                <option value="Atrasada"
                    ${pet.statusVacinal == 'Atrasada' ? 'selected' : ''}>
                    Atrasada
                </option>

                <option value="Pendente"
                    ${pet.statusVacinal == 'Pendente' ? 'selected' : ''}>
                    Pendente
                </option>

            </select>
        </label>

        <label>Tutor
            <select name="tutorId" required>
                <option value="">Selecione</option>
                <c:forEach var="tutor" items="${tutores}">
                    <option value="${tutor.id}" ${not empty pet.id and tutor.id eq pet.tutorId ? 'selected' : ''}>
                        ${tutor.nomeCompleto}
                    </option>
                </c:forEach>
            </select>
        </label>

        <label class="check-field">
            <input type="checkbox" name="castrado" ${pet.castrado ? 'checked' : ''}> Castrado
        </label>
    </div>

    <label>Alergias
        <textarea name="alergias" rows="4">${pet.alergias}</textarea>
    </label>

    <div class="hero-actions">
        <button class="btn btn-primary" type="submit">Salvar</button>
        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/app?entidade=pet&acao=listar">Cancelar</a>
    </div>
</form>

<%@ include file="/WEB-INF/views/fragments/footer.jspf" %>
