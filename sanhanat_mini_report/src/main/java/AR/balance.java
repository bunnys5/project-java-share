package AR;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class balance
 */
@WebServlet("/balanceServlet")
public class balance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public balance() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html"); // HTML 5
		out.println("<html><head>");
		out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
		String title = "balance goods";
		out.println("<head><title>" + title + "</title></head>");
		out.println("<body>");
		out.println("<h3>" + title + "</h3>");
		try {
			String sql = SQLbalancegoods.viewbalancegoods();
			Vector<balancegoods> Balance = DBbalancegoods.balanceDB(sql);
			
			out.println("<table border=1 cellpadding=4>\n");
			out.println("<tr>");
			out.println("<td> NAME </td>"
					+ "<td> STOCK </td>");
			out.println("</tr>");
			for(Iterator it=Balance.iterator();it.hasNext();) {
				balancegoods balancegoods = (balancegoods)it.next();
				out.println("<tr>");
				out.println("<td>" + balancegoods.name + "</td>"
						+ "<td>" + balancegoods.stock + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</br></br>");
			out.println("balancegoods retrieved successfully</br>");
		}catch (SQLException ex) {
			out.println("Error! " + ex.getMessage());
			ex.printStackTrace();
		}
		out.println("</br>");
		out.println("<a href=\"index.html\">Home</a>");
		out.println("</body></html>");
		out.close();


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
