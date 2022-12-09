package ProductControl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

	 
	public class AdminProductInput extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//JDBC Driver, URL and Credentials
			String URL = "jdbc:mysql://localhost:3306/Capstone";
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
			String FoodBrand = request.getParameter("ProductBrand");
			String FoodCategory = request.getParameter("ProductCategory");
			String FoodDescription = request.getParameter("ProductDescription");
			String FoodPrice = request.getParameter("ProductPrice");
			
			//Inserting JSP parameter values into database via INSERT statement
			String submit = 
					
					"INSERT INTO ProductInformation(ProductBrand,ProductCategory,ProductDescription,ProductPrice,ProductAvailability) "
			     + "VALUES ('"+FoodBrand+"','"+FoodCategory+"','"+FoodDescription+"','"+FoodPrice+"',)";						
			
			stmt.executeUpdate(submit);
			
			//PrintWriter method for HTML display of JSP parameter values
			pw1.println
			("<html>"	
		+   "<style>"				
		+	"input[type=submit], select {"
		+	"text-align: center;"
	    +   "width: 20%;"
		+	"padding: 12px 20px;"
		+	"margin: 15px;"
		+	"border: 1px solid #ccc;"
		+	"cursor: pointer;}"		
		+	".DivFormat {"
		+	"text-align: center;"
		+	"width: 60%;"
		+	"margin: 255px 320px;"
		+	"padding: 20px;}"
		+   "</style>"			
		
		+   "<body>"
		+	"<div class = DivFormat>"
		+   "<form action = 'AdminPortal.jsp'>"
		+   "<h2>This product has been added to the customer database: </h2><br>"					
		+   "<h2>Brand: "+FoodBrand+" | Category: "+FoodCategory+" "
	    +   "| Description: "+FoodDescription+" | Price: "+FoodPrice+" </h2>"
		+	"<br><br><br>"
		+   "<p>Click here to add more products</p>"
		+   "<input type = submit value = 'Administrator Portal' style ='background-color:#FF0000\"'>"
		+	"</div>"		
	    +   "</body>"
		+   "</html>");
					    
			stmt.close();
			con.close();
					}
//Exception for if database connection fails				
catch(Exception e) {
e.printStackTrace();
}  		
} 
}