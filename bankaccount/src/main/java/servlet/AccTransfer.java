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
import pojo.AccTransferPojo;

/**
 * Servlet implementation class AccTransfer
 */
public class AccTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	dao.AccTransferData AccTransferData=new dao.AccTransferData();
	Gson gson=new Gson();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccTransfer() {
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
		Connection conn;
		try {
			conn = obj.getConnection();
			AccTransferPojo json=gson.fromJson(request.getReader(), AccTransferPojo.class);
			PrintWriter out=response.getWriter();
			String str=AccTransferData.transferBal(json, conn);
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
