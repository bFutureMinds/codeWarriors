/**
 * 
 */
package com.ws.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ws.va.domain.QuestionBank;

/**
 * @author Chetan
 *
 */
public class DBConnection {

	public Connection getConnection() throws SQLException {

		String dbUrl = "jdbc:derby:E:/hackthon/code/chatbot/DBDerby/ChatBotDB;create=true";
		/*
		 * String user = "admin"; String password = "admin";
		 */
		Connection conn = DriverManager.getConnection(dbUrl);
		if (conn != null) {
			System.out.println("Connected to database...");
		}
/*		Statement stmt2 = conn.createStatement();
		ResultSet rs = stmt2.executeQuery("select * from QUESTION_BANK");
		System.out.println("Addressed present in your Address Book\n\n");
		int num = 0;

		while (rs.next()) {
			System.out.println(++num + ": CAT: " + rs.getString(1) + "\n "
					+ rs.getString(2));
		}*/
		return conn;
	}

	public List<QuestionBank> getQuestionBankData() {
		List<QuestionBank> bankList = new ArrayList<QuestionBank>();
		QuestionBank data = new QuestionBank();
		Connection conn = null;
		//PreparedStatement stmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "SELECT * from QUESTION_BANK";
			//stmt = conn.prepareStatement(sql);
			stmt = conn.createStatement();
			//stmt.setString(1, "%"+finalSearchString+"%");			
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				data = new QuestionBank();
				data.setQuestionId(rs.getInt(1));
				data.setTopicId(rs.getInt(2));
				data.setQuestion(rs.getString(3));
				data.setAnswer(rs.getString(4));
				data.setCatId(rs.getInt(5));
				data.setAmbiguity(rs.getString(6));
				data.setVerify(rs.getString(7));
				bankList.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (conn != null)
					conn.close();
				if (stmt != null) 
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bankList;
	}

}
