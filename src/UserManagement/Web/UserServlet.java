package UserManagement.Web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UserManagement.dao.UserDAO;
import UserManagement.model.User;

@WebServlet(urlPatterns = {"/new","/insert","/delete","/edit","/update","/list"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
        userDAO = new UserDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
	        switch (action) {
	        case "/new":
	            showNewForm(request, response);
	            break;
	        case "/insert":
	            insertUser(request, response);
	            break;
	        case "/delete":
	            deleteUser(request, response);
	            break;
	        case "/edit":
	            showEditForm(request, response);
	            break;
	        case "/update":
	            updateUser(request, response);
	            break;
	        default:
	        	listUser(request, response);
	            break;
	        }
	    } catch (SQLException ex) {
	        throw new ServletException(ex);
	    }
	}
	private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> listUser = userDAO.listAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("AddOrEdit.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userDAO.getUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("AddOrEdit.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
 
    }
 
    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
 
        User newUser = new User(0,firstname, lastname, email, username, password);
        userDAO.insertUser(newUser);
        response.sendRedirect("list");
    }
 
    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        User user = new User (id,firstname, lastname, email);
        userDAO.updateUser(user);
        response.sendRedirect("list");
    }
 
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        User user = new User(id, null, null, null, null, null);
        userDAO.deleteUser(user);
        response.sendRedirect("list");
 
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
