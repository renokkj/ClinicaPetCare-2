<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file="/WEB-INF/views/fragments/header.jspf" %>

<section class="section-head">
    <div>
        <h1>Tutores</h1>
        <p>Gerencie os tutores cadastrados na clínica.</p>
    </div>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/app?entidade=tutor&acao=formNovo">Novo tutor</a>
</section>

<div class="table-card">
    <table>
        <thead>
            <tr>
                <th>ID</th><th>Nome</th><th>Telefone</th><th>Email</th><th>Cidade</th><th>Ações</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="tutor" items="${tutores}">
            <tr>
                <td>${tutor.id}</td>
                <td>${tutor.nomeCompleto}</td>
                <td>${tutor.telefone}</td>
                <td>${tutor.email}</td>
                <td>${tutor.cidade}</td>
                <td class="actions">
                    <a class="link-btn" href="${pageContext.request.contextPath}/app?entidade=tutor&acao=buscarPorId&id=${tutor.id}">Ver</a>
                    <a class="link-btn" href="${pageContext.request.contextPath}/app?entidade=tutor&acao=editar&id=${tutor.id}">Editar</a>
                    <form method="post"
                          action="${pageContext.request.contextPath}/app?entidade=tutor&acao=deletar&id=${tutor.id}"
                          class="inline-form"
                          onsubmit="return confirm('Excluir esse tutor também pode afetar registro vinculador. Deseja continuar?');">
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
