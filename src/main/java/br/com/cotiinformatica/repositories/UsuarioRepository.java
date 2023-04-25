package br.com.cotiinformatica.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.factories.ConnectionFactory;

public class UsuarioRepository {
	// INSERIR USUARIO

	public void create(Usuario usuario) throws Exception { // CHAMA USUARIO COM TRATAMENTO DE EXCEÇÃO

		// INSTANCIOU O CONNECTIONFACTORY
		ConnectionFactory connectionFactory = new ConnectionFactory();
		// ABRIR CONEXÃO COM BD
		Connection connection = connectionFactory.getConnection();

		// executando comando no bd

		PreparedStatement statement = connection
				.prepareCall("insert into usuario (nome, email, senha)values(?,?,md5(?))");
		statement.setString(1, usuario.getNome());
		statement.setString(2, usuario.getEmail());
		statement.setString(3, usuario.getSenha());
		statement.execute();

		// FECHANDO CONEXÃO
		connection.close();
		// CRIAR METODO PARA CONSULTAR NO BD SE O USUARIO JA EXISTE.
	}

	public Usuario findByEmail(String email) throws Exception {
		// abrir conexão com o bd
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();

		// reparar para escrever no banco de dados

		PreparedStatement statement = connection.prepareStatement("select * from usuario where email =?");
		statement.setString(1, email);
		ResultSet resultSet = statement.executeQuery();

		Usuario usuario = null; // Iniciando o Usuario, forçando uma resposta Vazia.

		// Questionando ao resultSet se possui um usuario com este mesmo email.
		if (resultSet.next()) {
			usuario = new Usuario();
			usuario.setIdUsuario(resultSet.getInt("idusuario"));
			usuario.setNome(resultSet.getString("nome"));
			usuario.setEmail(resultSet.getString("email"));
			usuario.setSenha(resultSet.getString("senha"));
		}

		connection.close();
		return usuario;
	}

	// Novo metodo: consultar 1 usuario no bd atraves do email e senha
	public Usuario findByEmailAndSenha(String email, String senha) throws Exception {
		// abrir conexão com o bd
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();

		// escrevendo no BD
		PreparedStatement preparedStatement = connection
				.prepareStatement("select * from usuario where email=? and senha=md5(?)");
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, senha);

		// consultar o resultSet
		ResultSet resultSet = preparedStatement.executeQuery();

		Usuario usuario = null;
		if (resultSet.next()) {// se encontrar
			// captura os dados
			usuario = new Usuario();

			usuario.setIdUsuario(resultSet.getInt("idusuario"));
			usuario.setNome(resultSet.getString("nome"));
			usuario.setEmail(resultSet.getString("email"));
			usuario.setSenha(resultSet.getString("senha"));

		}

		connection.close();
		return usuario;
	}

}
