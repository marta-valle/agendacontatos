package br.com.cotiinformatica.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public Connection getConnection() throws Exception {

		String driver = "org.postgresql.Driver";
		String host = "jdbc:postgresql://localhost:5432/bd_agendacontatos";
		String user = "postgres";
		String password = "coti";

		Class.forName(driver);
		return DriverManager.getConnection(host, user, password);
	}

}
