package UserManagement.Web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UserManagement.dao.UserDAO;
import UserManagement.model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO uDao;  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {
    	uDao = new UserDAO();
    	super.init();
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
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		User user = new User(userName, passWord);
		try {
			if(uDao.login(user)) request.getRequestDispatcher("Home.jsp").forward(request, response);
			else response.sendRedirect(request.getContextPath()+"/Login.jsp?err=1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

