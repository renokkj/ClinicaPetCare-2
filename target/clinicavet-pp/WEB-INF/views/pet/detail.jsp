<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file="/WEB-INF/views/fragments/header.jspf" %>

<section class="section-head">
    <div>
        <h1>Detalhes do pet</h1>
        <p>Informações completas do pet e do prontuário.</p>
    </div>
</section>

<div class="page-actions">
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/app?entidade=pet&acao=listar">Voltar</a>
</div>

<div class="detail-grid">
    <div class="detail-card">
        <h3>Dados do pet</h3>
        <p><strong>ID:</strong> ${pet.id}</p>
        <p><strong>Nome:</strong> ${pet.nome}</p>
        <p><strong>Espécie:</strong> ${pet.especie}</p>
        <p><strong>Raça:</strong> ${pet.raca}</p>
        <p><strong>Sexo:</strong> ${pet.sexo}</p>
        <p><strong>Cor:</strong> ${pet.cor}</p>
        <p><strong>Data de nascimento:</strong> ${dataNascimentoFormatada}</p>
        <p><strong>Peso:</strong> ${pet.peso}</p>
        <p><strong>Porte:</strong> ${pet.porte}</p>
        <p><strong>Castrado:</strong> ${pet.castrado ? 'Sim' : 'Não'}</p>
        <p><strong>Microchip:</strong> ${pet.numeroMicrochip}</p>
        <p><strong>Alergias:</strong> ${pet.alergias}</p>
        <p><strong>Status vacinal:</strong> ${pet.statusVacinal}</p>
        <p><strong>Tutor ID:</strong> ${pet.tutorId}</p>
    </div>

    <div class="detail-card">
        <h3>Prontuário</h3>
        <c:choose>
            <c:when test="${not empty prontuario}">
                <p><strong>Prioridade:</strong> ${prontuario.nivelPrioridade}</p>
                <p><strong>Histórico:</strong> ${prontuario.historicoClinico}</p>
                <p><strong>Medicação contínua:</strong> ${prontuario.medicacaoContinua}</p>
                <p><strong>Restrições alimentares:</strong> ${prontuario.restricoesAlimentares}</p>
                <p><strong>Última atualização:</strong> ${prontuario.ultimaAtualizacao}</p>
            </c:when>
            <c:otherwise>
                <p>Prontuário não encontrado.</p>
            </c:otherwise>
        </c:choose>
    </div>
</div>

<%@ include file="/WEB-INF/views/fragments/footer.jspf" %>