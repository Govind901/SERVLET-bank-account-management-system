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
import dao.AccWithdrawData;
import pojo.AccWithdrawPojo;

/**
 * Servlet implementation class AccWithdraw
 */
public class AccWithdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Gson gson=new Gson();
       dao.AccWithdrawData AccWithdrawData=new AccWithdrawData();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccWithdraw() {
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
		AccWithdrawPojo json=gson.fromJson(request.getReader(), AccWithdrawPojo.class);
		PrintWriter out=response.getWriter();
		try {
			Connection conn=obj.getConnection();
			String str=AccWithdrawData.withdraw(json, conn);
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
