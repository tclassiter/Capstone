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

public class NewAdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

        
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//JDBC Driver, URL and Credentials
		String URL = "jdbc:mysql://localhost:3306/SportyShoes";
		String Username = "root";
		String Password = "12345678";
		
		//Response content type
		response.setContentType("text/html");
	    PrintWriter pw1= response.getWriter();
				

		//Trying to establish database connection and pass parameters from JSPs.
		try{
					
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL,Username,Password);
			Statement stmt = con.createStatement();
			
			//Retrieving JSP parameter values
			String NewUserName = request.getParameter("NewUserName");
			String NewPassWord = request.getParameter("NewPassWord");
		 
			//Submitting parameter values into database via INSERT statement
			String submit = "INSERT INTO AdminLogin VALUES ('"+NewUserName+"','"+NewPassWord+"')";
			stmt.executeUpdate(submit);
					
			//PrintWriter method printing HTML page
			pw1.println("<html>"
					+ 	"<style>"
					+   "body {"
					+	"background-image: URL();" 
					+   "background-repeat: no-repeat;"
					+	"background-size: cover;"
					+	"background-color: #d3d3d3;}"
					
					+	"input[type=text], select {"
					+		"text-align: center;"
					+		"width: 20%;"
					+		"padding: 10px 20px;"
					+		"margin: 20px;"
					+		"border: 1px solid #ccc;}"
					
					+	"input[type=submit], select {"
					+	    "text-align: center;"
					+	    "width: 20%;"
					+	    "padding: 12px 20px;"
					+		"margin: 15px;"
					+		"border: 1px solid #ccc;"
					+		"cursor: pointer;}"
					+	"</style>"
					
					+   "<body>"
					+   "<br><br><br><br><br><br><br><br>"
					+	"<center>Your Administrator account has been created or updated. <br><br>"
					
					+	"<form action = AdminLogin.jsp>"
					+	"Please select this button to return to the Administrator login page. <br><br>"
					+	"<input type = submit value = 'Administrator Login' style ='background-color: #FF0000'>"
					
					+	"</body>"
					+	"</html>");

}
//Exception if database connection fails
catch(Exception e) {
e.printStackTrace();	
}
}
}