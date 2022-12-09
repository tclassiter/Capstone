package Login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerLoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
        
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//Database access information and CustomerLogin.jsp parameter requests	
	String DBURL = "jdbc:mysql://localhost:3306/Capstone";
	String DBName = "root";
	String DBPassWord = "12345678";
	
	String JSPEmailAddress = request.getParameter("EmailAddress");
	String JSPPassWord = request.getParameter("PassWord");
			
		//Establishing database connection, passing database statement.
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(DBURL,DBName,DBPassWord);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT EmailAddress, PassWord FROM Customers");
			
			//Iterative while loop that retrieves data from SQL database and tests it against JSP and ResultSet values
			while(rs.next() ) {
				
				String EmailPull = rs.getString("EmailAddress");
				String PassWordPull = rs.getString("PassWord");

				//Start of if/else if algorithm that tests user input against database information
				if((JSPEmailAddress.equalsIgnoreCase(EmailPull)) && (JSPPassWord.equalsIgnoreCase(PassWordPull))) {
	            	        	
					HttpSession session = request.getSession();
					session.setAttribute("DBUserName", EmailPull);
					session.setAttribute("DBPassWord", PassWordPull);
					response.sendRedirect("CustomerPortal.jsp");
			    	}
				
				//Second part of If/Else If algorithm
				else if ((!JSPEmailAddress.equalsIgnoreCase(EmailPull)) && (!JSPPassWord.equals(PassWordPull))){
					
					RequestDispatcher rd = request.getRequestDispatcher("InvalidCustomerLogin.jsp");
					rd.include(request, response);				
					}	
				
				//Terminal part of If/Else If algorithm
				else if (rs.wasNull()) {
					
					RequestDispatcher rd = request.getRequestDispatcher("InvalidCustomerLogin.jsp");
					rd.include(request, response);
					}
					}
					}
		
//Exception if database connection fails
catch(Exception e) {
e.printStackTrace();
} 
}
}











