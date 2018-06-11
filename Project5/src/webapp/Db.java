package webapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

public class Db {

	private DataSource dataSource;
	private boolean authenticated = false;
	private List<Resource> resources;

	public void init() throws ServletException {
		resources = new ArrayList<Resource>();
		try {
			Context init = new InitialContext(); // look up in the META-INF folder for context.xml
			Context contx = (Context) init.lookup("java:comp/env"); // specified in context.xml (settings)
			dataSource = (DataSource) contx.lookup("jdbc/mydb");
		} catch (NamingException exc) {
			throw new ServletException("I cannot reach the source java:comp/env/jdbc/mydb", exc);
		}
	}

	public boolean authenticate(String login, String password) {
		String sel = "select * from user where Login = '" + login + "' AND Password = '" + password + "'";
		Connection con = null;
		authenticated = false;
		try {
			synchronized (this) {
				con = dataSource.getConnection();
			}
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sel);
			if(rs.next()==true)
				authenticated = true;
			rs.close();
			stmt.close();
		} catch (SQLException exc) {
			System.out.println(exc.getMessage());
			throw new DbAccessException("Cannot access the database, SQL exception", exc);
		} finally {
			try {
				con.close(); // very important, to close the connection when finished, otherwise we may have
								// too many threads!
			} catch (Exception exc) {
			}
		}
		return authenticated;
	}

	public void serviceView(String login, String password) {
		Connection con = null;
		String sel = "  SELECT `resource`.`Name`" + "      FROM `resource`" + "INNER JOIN `resource_user`"
				+ "        ON `resource`.`idResource` = `resource_user`.`idResource_User`" + "INNER JOIN `user`\r\n"
				+ "        ON `resource_user`.`IdUsers` = `user`.`idUser`" + "     WHERE `user`.`login` = " + "'"
				+ login + "'" + " and `user`.`password` = " + "'" + password + "';";
		try {
			synchronized (this) {
				con = dataSource.getConnection();
			}
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sel);

			while (rs.next()) {
				resources.add(new Resource(rs.getString("Name")));
			}
			rs.close();
			stmt.close();

		} catch (SQLException exc) {
			System.out.println(exc.getMessage());
			// we create an exception to afterwards show it to a user if necessary
			throw new DbAccessException("Cannot access the database, SQL exception", exc);
		} finally {
			try {
				con.close();
			} catch (Exception exc) {
			}
		}
	}

	public void serviceDetailedView(User user, String resourceName) {
		Connection con = null;

		String sel = "  SELECT `resource`.`Name`, `resource`.`Content`" + "      FROM `resource`"
				+ "INNER JOIN `resource_user`"
				+ "        ON `resource`.`idResource` = `resource_user`.`idResource_User`" + "INNER JOIN `user`"
				+ "        ON `resource_user`.`IdUsers` = `user`.`idUser`" + "     WHERE `user`.`login` = " + "'"
				+ user.getLogin() + "'" + " and `user`.`password` = " + "'" + user.getPassword() + "'" + " and `resource`.`Name` = " + "'"
				+ resourceName + "';";
		try {
			synchronized (this) {
				con = dataSource.getConnection();
			}
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sel);

			while (rs.next()) {
				resources.add(new Resource(rs.getString("Name"), rs.getString("Content")));
			}
			rs.close();
			stmt.close();

		} catch (SQLException exc) {
			System.out.println(exc.getMessage());
			throw new DbAccessException("Cannot access the database, SQL exception", exc);
		} finally {
			try {
				con.close();
			} catch (Exception exc) {
			}
		}
	}

	public List<Resource> getResources() {
		return resources;
	}
}
