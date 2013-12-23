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

@WebServlet("/AddItemRemoveItem")
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
		String price = request.getParameter("price");
		try {
			db.executeQuery("USE INVENTORY");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (request.getParameter("buttonType").equals("+ Item")) {
			try {
				db.executeQuery("INSERT INTO items VALUES(\"" + item + "\", " + price + ")");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher dispatch = request.getRequestDispatcher("added.jsp");
			dispatch.forward(request, response);
		}
		else if (request.getParameter("buttonType").equals("Remove Item")) {
			try {
				db.executeQuery("DELETE FROM items WHERE item = \"" + item + "\"");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher dispatch = request.getRequestDispatcher("removed.jsp");
			dispatch.forward(request, response);
		}
	}
	
	
}
