<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/fragments/header.jspf" %>
<section class="hero hero-home">
    <div class="hero-copy">
        <span class="badge">Bem-vindo à Clínica Pet Care</span>
        <h1>Pet<br>Care</h1>
        <p>
            Sistema de cadastro para a clínica veterinária Pet Care, com foco em organização,
            praticidade no atendimento e acesso rápido às informações de tutores, pets e consultas.
        </p>
        <div class="hero-actions">
            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/app?entidade=tutor&acao=formNovo">Cadastrar tutor</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/app?entidade=pet&acao=formNovo">Cadastrar pet</a>
        </div>
    </div>
    <div class="hero-panel hero-menu">
        <a class="menu-card menu-card-highlight" href="${pageContext.request.contextPath}/app?entidade=consulta&acao=listar">
            <strong>Consultas</strong>
            <span>Agende, acompanhe e atualize os atendimentos.</span>
        </a>
        <a class="menu-card" href="${pageContext.request.contextPath}/app?entidade=pet&acao=listar">
            <strong>Pets</strong>
            <span>Veja os dados cadastrais e o prontuário de cada animal.</span>
        </a>
        <a class="menu-card" href="${pageContext.request.contextPath}/app?entidade=tutor&acao=listar">
            <strong>Tutores</strong>
            <span>Gerencie os responsáveis e mantenha os contatos organizados.</span>
        </a>
    </div>
</section>
<section class="grid-cards info-cards">
    <article class="card">
        <h3>Atendimento mais ágil</h3>
        <p>Centralize as informações principais da clínica em um só lugar.</p>
    </article>
    <article class="card">
        <h3>Histórico do pet</h3>
        <p>Acesse rapidamente dados do animal, prontuário e acompanhamentos.</p>
    </article>
    <article class="card">
        <h3>Consultas organizadas</h3>
        <p>Cadastre, edite e acompanhe o status dos atendimentos com facilidade.</p>
    </article>
</section>
<%@ include file="/WEB-INF/views/fragments/footer.jspf" %>
