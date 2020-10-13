package serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/jdbc3")
public class jdbc3 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out= response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/cdac","ashutosh","2357");
			PreparedStatement p = con.prepareStatement(
					 "select * from stud;");
			         //p.setInt(1,1);
				ResultSet rs =	p.executeQuery();
					while(rs.next()) {
					String s =rs.getString("rno");
					String q = rs.getString("name");
					String m=rs.getString("marks");
					System.out.println(s+","+q+","+m);
					}
					out.println("value inserted into table creatd");
					con.close();
					} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		}
	}