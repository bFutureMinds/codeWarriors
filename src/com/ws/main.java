package com.ws;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class main {

    public static void main(String[] args) throws IOException {
        
        try {
        	/*ReadExcelDatabase rd = new ReadExcelDatabase();
        	rd.getAnswerForQuestion("balance");*/
            // connect method #2 - network client driver
            String dbUrl = "jdbc:derby:E:/hackthon/code/chatbot/DBDerby/ChatBotDB;create=true";
      /*      String user = "admin";
            String password = "admin";*/
            Connection conn = DriverManager.getConnection(dbUrl);
            if (conn != null) {
                System.out.println("Connected to derby database...");
            }
            Statement stmt2 = conn.createStatement();
            ResultSet rs = stmt2.executeQuery("select * from QUESTION_BANK where QUESTION like '%balance%'");
            int num = 0;

            while (rs.next()) {
              System.out.println(++num + ": CAT: " + rs.getString(3) + "\n "
                  + rs.getString(4));
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
