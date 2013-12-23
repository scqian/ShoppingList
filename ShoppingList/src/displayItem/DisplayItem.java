package displayItem;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import database.DataBaseConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DisplayItem")
public class DisplayItem extends HttpServlet{
	
	public DisplayItem() {
		//empty
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ServletContext sContext = request.getServletContext();
		DataBaseConnection db = (DataBaseConnection) sContext.getAttribute("dbConnection");
		Map<String, Integer> mp = new HashMap<String, Integer>();
		try {
			ResultSet rs = db.executeQuery("SELECT * FROM clothing");
			while (rs.next()) {
				String item = rs.getString("item");
				int price = Integer.parseInt(rs.getString("price"));
				mp.put(item, price);
			}
			HttpSession session = request.getSession();
			session.setAttribute("map", mp);
			RequestDispatcher dispatch = request.getRequestDispatcher("displayItem.jsp");
			dispatch.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
	
}
