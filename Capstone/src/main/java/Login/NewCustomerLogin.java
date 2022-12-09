package Login;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class NewCustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//JDBC Driver, URL and Credentials
		String URL = "jdbc:mysql://localhost:3306/Capstone";
		String DBUserName = "root";
		String DBPassWord = "12345678";
		
		//Response content type
		response.setContentType("text/html");
	    PrintWriter pw1= response.getWriter();
				
		//Trying to establish database connection and retrieve JSP parameter values
		try{
					
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL,DBUserName,DBPassWord);
			Statement stmt = con.createStatement();
			
			//Retrieving JSP parameter values
			String JSPFirstName = request.getParameter("NewFirstName");
			String JSPLastName = request.getParameter("NewLastName");
			String JSPEmailAddress = request.getParameter("NewEmailAddress");
			String JSPPassWord = request.getParameter("NewPassWord");
			
			//Inserting JSP parameter values into database
			String submit = 
					           "INSERT INTO Customers (FirstName,LastName,EmailAddress,PassWord) "
							+ "VALUES ('"+JSPFirstName+"','"+JSPLastName+"','"+JSPEmailAddress+"','"+JSPPassWord+"')";
			stmt.executeUpdate(submit);
					
			//PrintWriter method to print HTML
			pw1.println
			
			             ("<html>"
					+   "<body>"
			            		 
					+   "<style>"
				
					
					
					
					
					
					+   "</style>"
		
					+ "<div class = bg-image></div>"
					+ "<div class = bg-text>"
					+	"<h1><center><font color = 'white'>Your account has been updated.</font></h1>"
					+	"<h1><center><font color = 'white'>Ready to order some food?</font></h1><br>"			
					+  "<form action = CustomerLogin.jsp align = center>"
					+  "<input type = submit value = 'Let's Eat!' style = 'background-color: #00cc99';>"
					+  "</div>"
					+	"</body>"
					+	"</html>");
					    
			stmt.close();
			con.close();
}			   
//Exception if database connection fails
catch(Exception e) {
e.printStackTrace();
}
}
}