package com.jason;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jason.DataTable;

/**
 * Test
 */
public class Test {

	public static void main(String[] args) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;databaseName=mydb";
			String sqlcmd = "select * from studentinfo";
			Connection conn  = DriverManager.getConnection(url,"sa","Jb991015");
			PreparedStatement ps  = conn.prepareStatement(sqlcmd);
			ResultSet rs = ps.executeQuery();
			DataTable tb = new DataTable(rs);
			// DataRow dr = tb.ROWS[0];
			System.out.println(tb.ROWS[0].COLS[1]);
			System.out.println(tb.rows(1).cols(1));
			
		} catch (Exception e) {
			e.printStackTrace();
			//TODO: handle exception
		}
	}
}