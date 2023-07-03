package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
 * Servlet implementation class TransHistory
 */
public class AccTransHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	dao.AccTransHistoryData AccTransHistoryData=new dao.AccTransHistoryData();
	Gson gson=new Gson();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccTransHistory() {
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
			try {
				Connection conn=obj.getConnection();
				AccDepositPojo json=gson.fromJson(request.getReader(), AccDepositPojo.class);
				PrintWriter out=response.getWriter();
				List<Object> list=AccTransHistoryData.transactionHistory(json, conn);
				String str=gson.toJson(list);
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
