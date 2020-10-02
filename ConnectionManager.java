package br.com.globalcode.aj3.util;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.globalcode.aj3.exception.GlobalcodeException;
import java.sql.DriverManager;

public class ConnectionManager {

	private static final String DATABASE = "aj";
	private static final String IP = "192.168.0.1";
	private static final String STR_CON = "jdbc:mysql://" + IP + ":3306/" + DATABASE;
	private static final String USER = "aj";
	private static final String PASSWORD = "aj";

	public static Connection getConnection() throws GlobalcodeException {
		Connection conn = null;
		try {
                        conn = DriverManager.getConnection(STR_CON, USER, PASSWORD);
                    
			System.out.println("[ConnectionManager]: Obtendo conexao");
		} catch (SQLException e) {
			throw new GlobalcodeException("Erro ao obter a conexao", e);
		}
                return conn;
	}

	public static void closeAll(Connection conn) {
		try {
                    if(conn != null) {
                        conn.close();
                    }
                    
		} catch (Exception e) {
			System.out.println("---> Nao foi possivel fechar a conexao com o banco");
			System.out.println("---> Detalhamento do erro: ");
			e.printStackTrace();
		}
	}
}
