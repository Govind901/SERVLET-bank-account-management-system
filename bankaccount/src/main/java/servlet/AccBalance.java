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
import pojo.AccBalancePojo;

/**
 * Servlet implementation class AccBalance
 */
public class AccBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Gson gson=new Gson();
       dao.AccBalanceData AccBalanceData=new dao.AccBalanceData();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccBalance() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext context=request.getServletContext();
		Connectionn obj=(Connectionn) context.getAttribute("dacon");
		AccBalancePojo json=gson.fromJson(request.getReader(), AccBalancePojo.class);
		PrintWriter out=response.getWriter();
		Connection conn;
		try {
			conn = obj.getConnection();
			String str=AccBalanceData.retriveBalance(json, conn);
			out.println(str);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
