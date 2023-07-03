package connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class Listnerr
 *
 */
public class Listnerr implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public Listnerr() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	System.out.println("server ended");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	Connectionn obj=new Connectionn();
    	ServletContext context=sce.getServletContext();
    	context.setAttribute("dacon", obj);
    	System.out.println("server strted");
    }
	
}
