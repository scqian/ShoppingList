package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.*;

import database.DataBaseConnection;
/**
 * Application Lifecycle Listener implementation class ContListener
 *
 */
@WebListener
public class ContextListener implements ServletContextListener {
	DataBaseConnection db;
	
    /**
     * Default constructor. 
     */
    public ContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
    	ServletContext init = arg0.getServletContext();
    	db = new DataBaseConnection();
    	init.setAttribute("dbConnection", db);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
