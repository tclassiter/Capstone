package ProductControl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

 
public class CustomerSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//JDBC Driver, URL and Credentials
		String URL = "jdbc:mysql://localhost:3306/Capstone";
		String Username = "root"; 
		String Password = "12345678";
								
		//Response content type
		response.setContentType("text/html");
		PrintWriter pw1 = response.getWriter();
								
		//Trying to establish database connection and pass parameters from JSPs.
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL,Username,Password);
		Statement stmt = con.createStatement();
							
		//Retrieving database values via ResultSet method
		ResultSet FoodResult = stmt.executeQuery("SELECT Foods FROM FoodTypes");	
		
		//Iterative loop to retrieve database values
		while (FoodResult.next()) {
		
			//Retrieving JSP parameter values
			String FoodSelection = request.getParameter("JSPFoodSelection");
			
			if((FoodSelection.equals(FoodResult))) {
	        	
				HttpSession session = request.getSession();
				session.setAttribute("JSPFoodSelection", FoodSelection);
				response.sendRedirect("FoodBoxPortal.jsp");
		    	}
			
			   //Second part of If/Else If algorithm
			   else if ((!FoodSelection.equals(FoodResult))){
				RequestDispatcher rd = request.getRequestDispatcher(".jsp");
				rd.include(request, response);				
			   
		
		//PrintWriter method to print HTML page with JSP parameter values 
		pw1.println
		("<html>"
	+   "<style>"			
	+   "body {"
    +	"background-image: URL('FriendsEating.jpeg');" 
	+	"background-repeat: no-repeat;"
	+	"background-size: cover;"
	+	"background-color: #d3d3d3;}"			    	
	+	"input[type=submit], select {"
	+	"text-align: center;"
    +   "width: 20%;"
	+	"padding: 12px 20px;"
	+	"margin: 15px;"
	+	"border: 1px solid #ccc;"
	+	"cursor: pointer;}"			    		
	+	".Format {"
	+	"text-align: center;"
	+	"width: 60%;"
	+	"margin: 155px 100px;"
	+	"padding: 20px;}"
	+   "</style>"		
	
	+   "<body>"
	+	"<div class = Format>"
	+   "<form action = 'PaymentGateway.jsp'>"
	+   "<h2><font color = 'white'>Yes, those shoes are available! </font>"		
	
		//For purposes of this project, I have coded $30 into the HTML just for visual effect. For real world use, the 
		//"Price" will be replaced with variable +ProductPrice+ and the value will be pulled from the 
	    //SQL database via the RusultSet method using 'ProductPrice' in the SQL statement.
		
	+   "<h2><font color = 'white'>Yes, we have that! "
	+   "Entre: "+FoodResult+"  Price: $30 <br><br><br><br>"
	+   "Availability: Here on the portal and at your local shopping center</h2></font>"		
	+   "<input type = submit value = 'Purchase' style ='background-color:#00cc99\"'>"
	+   "</form>"
	
	+	"<br><br><br><br><br>"
	+   "<form action  = 'CustomerPortal.jsp'>"
	+   "<h2><font color = 'white'>Not done shopping?<br>"
	+   "<input type = submit value = 'Customer Portal' style ='background-color:#00cc99\"'>"
	+	"</div>"		
    +   "</body>"
	+   "</html>");
}
}
}
		
//Exception if database connection fails		
catch(Exception e) {
e.printStackTrace();
}	
}
}
	





		

