package br.com.cotiinformatica.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cotiinformatica.entities.Contato;
import br.com.cotiinformatica.factories.ConnectionFactory;

public class ContatoRepository {

	// método para inserir um contato no banco de dados
	public void create(Contato contato) throws Exception {

		// abrindo conexão com o banco de dados
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();

		// executando um comando SQL no banco de dados
		PreparedStatement statement = connection.prepareStatement(
				"insert into contato(nome, telefone, email, observacoes, idusuario) values(?,?,?,?,?)");

		statement.setString(1, contato.getNome());
		statement.setString(2, contato.getTelefone());
		statement.setString(3, contato.getEmail());
		statement.setString(4, contato.getObservacoes());
		statement.setInt(5, contato.getIdUsuario());
		statement.execute();

		connection.close();
	}

	// método para atualizar um contato no banco de dados
	public void update(Contato contato) throws Exception {

		// abrindo conexão com o banco de dados
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();

		// executando um comando SQL no banco de dados
		PreparedStatement statement = connection
				.prepareStatement("update contato set nome=?, telefone=?, email=?, observacoes=? where idcontato=?");

		statement.setString(1, contato.getNome());
		statement.setString(2, contato.getTelefone());
		statement.setString(3, contato.getEmail());
		statement.setString(4, contato.getObservacoes());
		statement.setInt(5, contato.getIdContato());
		statement.execute();

		connection.close();
	}

	// método para excluir um contato no banco de dados
	public void delete(Contato contato) throws Exception {

		// abrindo conexão com o banco de dados
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();

		// executando um comando SQL no banco de dados
		PreparedStatement statement = connection.prepareStatement("delete from contato where idcontato=?");

		statement.setInt(1, contato.getIdContato());
		statement.execute();

		connection.close();
	}

	// RETORNANDO OS CONTATOS
	public List<Contato> findByUsuario(Integer idUsuario) throws Exception {

		// ABRIR CONEXAO
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();

		// INICIANDO COMUNICAÇÃO COM O BD
		PreparedStatement statement = connection.prepareStatement("select * from contato where idusuario=?");

		statement.setInt(1, idUsuario);
		ResultSet resultSet = statement.executeQuery();

		// declarando uma lista de contatos ainda vazia

		List<Contato> lista = new ArrayList<Contato>();

		while (resultSet.next()) {

			Contato contato = new Contato();
			contato.setIdContato(resultSet.getInt("idcontato"));
			contato.setNome(resultSet.getString("nome"));
			contato.setEmail(resultSet.getString("email"));
			contato.setTelefone(resultSet.getString("telefone"));
			contato.setObservacoes(resultSet.getString("observacoes"));
			contato.setIdUsuario(resultSet.getInt("idusuario"));

			lista.add(contato);

		}

		connection.close();
		return lista;

	}
	//RETORNANDO APENAS 1 CONTATO
	public Contato findById(Integer idContato) throws Exception{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();
		
		//escrevendo no bd
		PreparedStatement statement = connection.prepareStatement("select * from contato where id=contato =?");
		
		statement.setInt(1, idContato);
		ResultSet resultSet = statement.executeQuery();
		
		Contato contato = null;
		
		
		if(resultSet.next()) {
			
		contato = new Contato();
		
		contato.setIdContato(resultSet.getInt("idcontato"));
		contato.setNome(resultSet.getString("nome"));
		contato.setEmail(resultSet.getString("email"));
		contato.setTelefone(resultSet.getString("telefone"));
		contato.setObservacoes(resultSet.getString("observacoes"));
		contato.setIdUsuario(resultSet.getInt("idusuario"));
		
		}
		connection.close();
		return contato;	
	}

}