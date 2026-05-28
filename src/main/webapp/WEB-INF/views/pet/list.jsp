<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file="/WEB-INF/views/fragments/header.jspf" %>

<section class="section-head">
    <div>
        <h1>Pets</h1>
        <p>Veja os pets cadastrados e acesse seus dados rapidamente.</p>
    </div>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/app?entidade=pet&acao=formNovo">Novo pet</a>
</section>

<div class="table-card">
    <table>
        <thead>
            <tr>
                <th>ID</th><th>Nome</th><th>Espécie</th><th>Raça</th><th>Status vacinal</th><th>Tutor ID</th><th>Ações</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="pet" items="${pets}">
            <tr>
                <td>${pet.id}</td>
                <td>${pet.nome}</td>
                <td>${pet.especie}</td>
                <td>${pet.raca}</td>
                <td>

            <c:choose>

                <c:when test="${pet.statusVacinal == 'Em dia'}">
                    <span class="status-badge em-dia">
                        ${pet.statusVacinal}
                    </span>
                </c:when>

                <c:when test="${pet.statusVacinal == 'Atrasada'}">
                    <span class="status-badge atrasada">
                        ${pet.statusVacinal}
                    </span>
                </c:when>

                <c:otherwise>
                    <span class="status-badge pendente">
                        ${pet.statusVacinal}
                    </span>
                </c:otherwise>

            </c:choose>

                </td>
                <td>${pet.tutorId}</td>
                <td class="actions">
                    <a class="link-btn" href="${pageContext.request.contextPath}/app?entidade=pet&acao=buscarPorId&id=${pet.id}">Ver</a>
                    <a class="link-btn" href="${pageContext.request.contextPath}/app?entidade=pet&acao=editar&id=${pet.id}">Editar</a>
                    <form method="post" action="${pageContext.request.contextPath}/app?entidade=pet&acao=automatizarTriagem&id=${pet.id}" class="inline-form">
                        <button class="link-btn" type="submit">Triagem</button>
                    </form>
                    <form method="post"
                          action="${pageContext.request.contextPath}/app?entidade=pet&acao=deletar&id=${pet.id}"
                          class="inline-form"
                          onsubmit="return confirm('Esta ação removerá o pet permanentemente. Deseja continuar?');">
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
