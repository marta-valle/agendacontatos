  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container">
      <a class="navbar-brand" href="/agendacontatos/admin/home">
      Agenda de Contatos
      </a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
         
          <li class="nav-item">
            <a class="nav-link" href="/agendacontatos/admin/cadastro-contato">
            Cadastrar Contatos
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/agendacontatos/admin/consulta-contato">
            Consultar Contatos
             </a>
          </li>
            <!-- Incluido dia 02/05 -->
          <li class="nav-item">
            <a class="nav-link" href="/agendacontatos/admin/dados-usuario">
            Dados do Usuario
            </a>
          </li>
          
          
        </ul>
        <div class="d-flex">
          <span class="navbar-text me-3 text-white"><strong>${usuario.nome}</strong></span>
          <a class="btn text-white" href="/agendacontatos/logout"
          	onclick="return confirm('Deseja realmente sair da agenda?');">
          	Sair do Sistema
          	 <!--  Dia20/04: acrescentou o controlador logaut + JS: onclick a��o// confirm aparece um poup-up -->
          
          </a>
        </div>
      </div>
    </div>
  </nav>