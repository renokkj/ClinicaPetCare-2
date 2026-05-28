<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/fragments/header.jspf" %>

<section class="hero hero-home">

    <div class="hero-copy">

        <span class="badge">
            Bem-vindo à Clínica Pet Care
        </span>

        <h1>Pet Care</h1>

        <p>
            Sistema de cadastro para a clínica veterinária Pet Care,
            com foco em organização, praticidade no atendimento
            e acesso rápido às informações de tutores, pets e consultas.
        </p>

        <div class="hero-actions">

            <a class="btn btn-secondary"
                href="${pageContext.request.contextPath}/app?entidade=tutor&acao=formNovo">
                Cadastrar tutor
            </a>

            <a class="btn btn-primary"
                href="${pageContext.request.contextPath}/app?entidade=pet&acao=formNovo">
                Cadastrar pet
            </a>

        </div>

        <div class="home-stats">

            <div class="home-stat-card">
                <strong>${totalPets}</strong>
                <span>Pets cadastrados</span>
            </div>

            <div class="home-stat-card">
                <strong>${totalConsultas}</strong>
                <span>Consultas registradas</span>
            </div>

            <div class="home-stat-card">
                <strong>${totalTutores}</strong>
                <span>Tutores ativos</span>
            </div>

        </div>

    </div>

    <div class="hero-panel hero-menu">

        <a class="menu-card menu-card-highlight"
           href="${pageContext.request.contextPath}/app?entidade=consulta&acao=listar">

            <strong>Consultas</strong>

            <span>
                Agende, acompanhe e atualize os atendimentos.
            </span>

        </a>

        <a class="menu-card"
           href="${pageContext.request.contextPath}/app?entidade=pet&acao=listar">

            <strong>Pets</strong>

            <span>
                Veja os dados cadastrais e o prontuário de cada animal.
            </span>

        </a>

        <a class="menu-card"
           href="${pageContext.request.contextPath}/app?entidade=tutor&acao=listar">

            <strong>Tutores</strong>

            <span>
                Gerencie os responsáveis e mantenha os contatos organizados.
            </span>

        </a>

    </div>

</section>

<%@ include file="/WEB-INF/views/fragments/footer.jspf" %>
