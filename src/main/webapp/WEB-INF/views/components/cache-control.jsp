  <!--  dia 20/04: FUN��O PARA QUE O NAVEGADOR N�O SALVE NO NAVEGADOR O CASH - REGRA DE SEGURAN�A CASO SEJA SALVO OS DADOS DE USUARIO COM SESSAO -->
    <%
  	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
  	response.setHeader("Pragma", "no-cache");
  	response.setDateHeader("Expires", 0);
    %>