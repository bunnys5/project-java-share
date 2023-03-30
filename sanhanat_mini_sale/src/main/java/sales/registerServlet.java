package sales;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class register
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
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
		String title = "register";
		out.println("<head><title>" + title + "</title></head>");
		out.println("<body>");
		out.println("<h3>" + title + "</h3>");
		
		try {
			boolean noParam = true;
			String fromusername = "username";
			String frompassword = "password";
			String usernameStr = request.getParameter(fromusername);
			if (usernameStr != null && (usernameStr = usernameStr.trim()).length() != 0) {
				out.println(fromusername + ":" +usernameStr + "</br>");
				noParam = false;
			}
			String passwordStr = request.getParameter(frompassword);
			if (passwordStr != null && (passwordStr = passwordStr.trim()).length() != 0) {
				out.println(frompassword + ":" +passwordStr + "</br>");
				noParam = false;
			}
			long password = Long.parseLong(passwordStr);
			Register register= new Register(usernameStr, password);
			
			String addSql = SQLregister.registerSQL(register);
			
			DBregister.executeDB(addSql);
			out.println("</br>");
			out.println("register added successfully</br>");
		}catch (SQLException ex) {
			out.println("<font color=\"red\">Error! " + ex.getMessage() + "</font></br>");
			ex.printStackTrace();
		} catch (NumberFormatException ex) {
			out.println("<font color=\"red\">Error! " + ex.getMessage() + "</font></br>");
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
