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
import pojo.AccDepositPojo;

/**
 * Servlet implementation class AccDeposit
 */
public class AccDeposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	dao.AccDepositData AccDepositData=new dao.AccDepositData();
	Gson gson=new Gson();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccDeposit() {
        super();
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
		ServletContext context=request.getServletContext();
		Connectionn obj=(Connectionn) context.getAttribute("dacon");
		try {
			AccDepositPojo json=gson.fromJson(request.getReader(), AccDepositPojo.class);
			PrintWriter out=response.getWriter();
			Connection conn=obj.getConnection();
			String str=AccDepositData.Deposits(json,conn);
			out.println(str);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
