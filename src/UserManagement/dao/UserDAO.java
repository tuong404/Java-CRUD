package UserManagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import UserManagement.model.User;

public class UserDAO {
	private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=QLTK;"
            + "integratedSecurity=true";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "";
    private static Connection jdbcConnection;


        public UserDAO() {}
        
        protected void connect() throws SQLException {
            if (jdbcConnection == null || jdbcConnection.isClosed()) {
                try {
                	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                } catch (ClassNotFoundException e) {
                    throw new SQLException(e);
                }
                jdbcConnection = DriverManager.getConnection(
                		DB_URL, USER_NAME, PASSWORD);
            }
        }
        
        protected void disconnect() throws SQLException {
            if (jdbcConnection != null && !jdbcConnection.isClosed()) {
                jdbcConnection.close();
            }
        }
        
        public boolean login(User user) throws SQLException {
        	
        	boolean check;
        	String sql = "select *from users where username= ? and password= ? ";
        	connect();
        	PreparedStatement pre = jdbcConnection.prepareStatement(sql);
        	pre.setString(1, user.getUserName());
        	pre.setString(2, user.getPassWord());
        	ResultSet rs = pre.executeQuery();
        	check = rs.next();
        	disconnect();
			return check;
        	
        }
        
        public boolean registerUser(User user) throws SQLException {
        	String sql = "INSERT INTO users (firstname, lastname,email, username, password) VALUES (?, ?,?, ?, ?)";
            connect();
            
            PreparedStatement statement = jdbcConnection.prepareStatement(sql);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getUserName());
            statement.setString(5, user.getPassWord());
             
            boolean rowRegister = statement.executeUpdate() > 0;
            statement.close();
            disconnect();
            return rowRegister;
        }

        public boolean insertUser(User user) throws SQLException {
        	String sql = "INSERT INTO users (firstname, lastname, email) VALUES (?, ?, ?)";
            connect();
            
            PreparedStatement statement = jdbcConnection.prepareStatement(sql);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
             
            boolean rowInserted = statement.executeUpdate() > 0;
            statement.close();
            disconnect();
            return rowInserted;
      }
        public List<User> listAllUsers() throws SQLException {
            List<User> listUser = new ArrayList<>();
             
            String sql = "SELECT * FROM users";
             
            connect();
            PreparedStatement prStatement  = jdbcConnection.prepareStatement(sql);
            ResultSet resultSet = prStatement.executeQuery();
             
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                User user = new User(id, firstname, lastname, email, username, password);
                listUser.add(user);
            }
             
            resultSet.close();
            prStatement.close();
             
            disconnect();
             
            return listUser;
        }
        
        public boolean deleteUser(User user) throws SQLException {
            String sql = "DELETE FROM users where id = ?";
             
            connect();
             
            PreparedStatement statement = jdbcConnection.prepareStatement(sql);
            statement.setInt(1, user.getId());
             
            boolean rowDeleted = statement.executeUpdate() > 0;
            statement.close();
            disconnect();
            return rowDeleted;     
        }
         
        public boolean updateUser(User user) throws SQLException {
            String sql = "UPDATE users SET firstname = ?, lastname = ?, email = ? where id = ?";
            
            connect();
             
            PreparedStatement statement = jdbcConnection.prepareStatement(sql);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setInt(4, user.getId());
             
            boolean rowUpdated = statement.executeUpdate() > 0;
            statement.close();
            disconnect();
            return rowUpdated;     
        }
         
        public User getUser(int id) throws SQLException {
            User user = null;
            String sql = "SELECT id,firstname,lastname,email FROM users WHERE id = ?";
             
            connect();
             
            PreparedStatement statement = jdbcConnection.prepareStatement(sql);
            statement.setInt(1, id);
             
            ResultSet resultSet = statement.executeQuery();
             
            if (resultSet.next()) {
            	int id1 = Integer.parseInt(resultSet.getString("id"));
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                user = new User(id,firstname, lastname, email);
            }
             
            resultSet.close();
            statement.close();
             
            return user;
        }
        
}
