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


public class AdminLoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//JDBC connection information	
	String URL = "jdbc:mysql://localhost:3306/Capstone";
	String DBUserName = "root";
	String DBPassWord = "12345678";
	
		//Trying to establish database connection and pass parameters from JSPs.
		try{			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL,DBUserName,DBPassWord);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT UserName,PassWord FROM AdminLogin"); 

			//Iterative while loop that retrieves data from SQL database and tests it against JSP and ResultSet values
			while(rs.next()) {
				
			//Retrieving JSP parameter and ResultSet method values
			String JSPUserName = request.getParameter("UserName");
			String JSPPassWord = request.getParameter("PassWord");
	        String AdminUserName = rs.getString("UserName");  
	   	    String AdminPassWord = rs.getString("PassWord");
	   	        
	   	    //Start of if/else if algorithm that tests user input against database information
	        if ((JSPUserName.equalsIgnoreCase(AdminUserName)) && (JSPPassWord.equalsIgnoreCase(AdminPassWord))) {
	            	
	        HttpSession session = request.getSession();
			session.setAttribute("UserName", AdminUserName);
			session.setAttribute("PassWord", AdminPassWord);
			response.sendRedirect("AdminPortal.jsp");
			}
	            
	        //Second half of if/else if algorithm that may direct user to InValidAdminLogin
	        else if ((!JSPUserName.equals(AdminUserName)) && (!JSPPassWord.equals(AdminPassWord))
	            	|| (rs.wasNull())) {
	            	
	        RequestDispatcher rd = request.getRequestDispatcher("InvalidAdminLogin.jsp");
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

	










