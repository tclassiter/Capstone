package CheckOut;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
 
public class FinalConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
      	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//JDBC connection information and variable declarations for JSP parameter values
		String URL = "jdbc:mysql://localhost:3306/Capstone";
		String Username = "root"; 
		String Password = "12345678";				
		
		//Response content type
		response.setContentType("text/html");
	    PrintWriter pw = response.getWriter();	
	    
		//Trying to establish database connection
		try{							
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL,Username,Password);
		Statement stmt = con.createStatement();
		
		//Retrieving JSP parameter values
		String CardFirstName = request.getParameter("CardFirstName");
		String CardLastName = request.getParameter("CardLastName");
		String CardAddress = request.getParameter("CardAddress"); 
		String CardNumber = request.getParameter("CardNumber");  
		String CardExpiration = request.getParameter("CardExpiration");  
		String CardSecurity = request.getParameter("CardSecurity");	
	    
	    //Putting JSP parameter values from into database
	    String submit = 
	    		   
	    		"INSERT INTO Purchase(CardFirstName,CardLastName,CardAddress,CardNumber,CardExpiration,CardSecurity) "
	    		
	    		+ "VALUES ('"+CardFirstName+"','"+CardLastName+"','"+CardAddress+"','"+ CardNumber +"','"+CardExpiration+"','"+CardSecurity+"')";
	    		
	            stmt.executeUpdate(submit); 

	    //PrintWriter method printing HTML page        
	   	pw.println
   		 ("<html>"                            
   		+ "<style>" 
   		+ "body {"	                    
   
   		+ "<body>"
   		+ "<br><br><br><br><br><br>"
   		+ "<h1><font color = 'white'><center>Confirmation Page</font></h1>"
   		+ "<h2><font color = 'white'><center>Please print and keep this page!</font></h2>"
   		+ "<br><br><br>"
   		+ "<div class = 'format'>"
   		
   		//I have encoded $100 into the HTML for visual effect. When deployed, this application will "call" 
   		//the price amounts that the administrator places in the database via AdminProductControl.
   		  
   		+ "<h2><font color = 'white'>'Your order is on the way! | $100 USD <br><br><br>" 
   	    + "First Name: "+CardFirstName+" <br> "
   	    + "Last Name: "+CardLastName+" <br> "
   	    + "Mailing Address: "+CardAddress+" <br> "
   	    + "Credit Card Number: "+CardNumber+" <br> "		
   	    + "Card Expiration Date: "+CardExpiration+" <br> " 
   	    + "Security Code: "+CardSecurity+"</font><p>"
   	    + "</div>"    
   	    + "</body>"
   	    + "</html>");
}
		
//The exception for if the application cannot connect to the database.
catch(Exception e) {
e.printStackTrace();

}
}
}



       	         