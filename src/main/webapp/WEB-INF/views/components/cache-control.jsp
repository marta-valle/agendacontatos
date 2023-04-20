  <!--  dia 20/04: FUNÇÃO PARA QUE O NAVEGADOR NÃO SALVE NO NAVEGADOR O CASH - REGRA DE SEGURANÇA CASO SEJA SALVO OS DADOS DE USUARIO COM SESSAO -->
    <%
  	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
  	response.setHeader("Pragma", "no-cache");
  	response.setDateHeader("Expires", 0);
    %>