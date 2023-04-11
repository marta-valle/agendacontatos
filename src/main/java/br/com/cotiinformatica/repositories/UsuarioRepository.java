package br.com.cotiinformatica.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.br.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.factories.ConnectionFactory;

public class UsuarioRepository {
	// INSERIR USUARIO
	
	public void create(Usuario usuario) throws Exception { // CHAMA USUARIO COM TRATAMENTO DE EXCEÇÃO
		
		// INSTANCIOU O CONNECTIONFACTORY
		ConnectionFactory connectionFactory = new ConnectionFactory();
		// ABRIR CONEXÃO COM BD
		Connection connection = connectionFactory.getConnection();

		// executando comando no bd

		PreparedStatement statement = connection.prepareCall("insert into usuario (nome, email, senha)values(?,?,?)");
		statement.setString(1, usuario.getNome());
		statement.setString(2, usuario.getEmail());
		statement.setString(3, usuario.getSenha());
		statement.execute();

		// FECHANDO CONEXÃO
		connection.close();

	}

}
