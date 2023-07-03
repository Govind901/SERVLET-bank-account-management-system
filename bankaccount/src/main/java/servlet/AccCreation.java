package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import connection.Connectionn;
import pojo.AccCreationPojo;

/**
 * Servlet implementation class AccCreation
 */
public class AccCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gson gson=new Gson();
	dao.AccCreationData AccCreationData=new dao.AccCreationData();
    /**
     * Default constructor. 
     */
    public AccCreation() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext sc=request.getServletContext();
		Connectionn obj=(Connectionn)sc.getAttribute("dacon");
		Connection conn;
		try {
			conn = obj.getConnection();
			AccCreationPojo json=gson.fromJson(request.getReader(), AccCreationPojo.class);
			PrintWriter out=response.getWriter();
			String st=AccCreationData.creation(json,conn);
			out.println(st);
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}

}
