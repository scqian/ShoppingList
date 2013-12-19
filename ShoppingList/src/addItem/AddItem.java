package addItem;

import java.io.*;
import java.sql.SQLException;

import database.DataBaseConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddItem")
public class AddItem extends HttpServlet{
	
	public AddItem() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//empty
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sContext = getServletContext();
		DataBaseConnection db = (DataBaseConnection) sContext.getAttribute("dbConnection");
		String item = request.getParameter("item");
		int price = Integer.parseInt(request.getParameter("price"));
		try {
			db.executeQuery("USE INVENTORY");
			System.out.println("Switched to Inventory");
			db.executeQuery("INSERT INTO clothing VALUES(\"" + item + "\", " + price + ")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatch = request.getRequestDispatcher("added.jsp");
		dispatch.forward(request, response);
	}
	
	
}
