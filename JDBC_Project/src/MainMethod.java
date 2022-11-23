import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.constants.Role;
import com.jdbc.AccountDetails;
import com.jdbc.Registration;

public class MainMethod {

	public static Registration newUserRegistration(Connection con) throws SQLException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the User_name: ");
		String user_name = sc.next();
		System.out.println("Enter the First Name: ");
		String f_name = sc.next();
		System.out.println("Enter the Last Name2: ");
		String l_name = sc.next();
		System.out.print("Enter the password: ");
		String password = sc.next();
		System.out.println();

		String role = Role.USER.name();
		System.out.println();
		Registration reg = new Registration(user_name, f_name, l_name, password, role);
		// System.out.println(reg.getUser_id());
		PreparedStatement pstmt = con.prepareStatement(
				"insert into registration(user_name,f_name,l_name,password,role) values( ?, ?, ?, ?, ?)");
		// pstmt.execute("alter table registration AUTO_INCREMENT = 1001");
		// pstmt.setInt(1, user_id);
		pstmt.setString(1, user_name);
		pstmt.setString(2, f_name);
		pstmt.setString(3, l_name);
		pstmt.setString(4, password);
		pstmt.setString(5, role);
		int i = pstmt.executeUpdate();

		ResultSet rs = pstmt.executeQuery("select user_id from Registration");

		int user_id = 0;

		while (rs.next()) {

			user_id = rs.getInt("user_id");

		}

		System.out.println("Enter the account type 1.SAVING/2.CURRENT: Enter your choice number 1 or 2: ");
		int ch = sc.nextInt();
		String account_type = null;
		if (ch == 1)
			account_type = "SAVING";
		else if (ch == 2)
			account_type = "CURRENT";

		AccountDetails ad = new AccountDetails(account_type);
		double balance = ad.getBalance();
		PreparedStatement pstmt2 = con
				.prepareStatement("insert into account_details(user_id,account_type,balance) values(?,?,?)");
		//pstmt2.execute("alter table account_details AUTO_INCREMENT = 1010101");
		pstmt2.setInt(1, user_id);
		pstmt2.setString(2, account_type);
		pstmt2.setInt(3, (int) balance);
		int j = pstmt2.executeUpdate();

		if (i != 0 && j != 0) {
			System.out.println("Registration Successful (: ");
		} else {
			System.out.println("Registration failed ): ");
		}
		pstmt.close();
		pstmt2.close();
		return reg;
	}

	public static void entryPoint(Connection con) throws SQLException {
		System.out.println("1.Login.\n2.Register.\n");
		int choice = 0;
		Scanner sc1 = new Scanner(System.in);

		do {
			choice = sc1.nextInt();
			switch (choice) {
			case 1:
				login(con);
				break;
			case 2:
				Registration acc = null;
				System.out.println("\n Register yourself with us please provide following details");
				acc = newUserRegistration(con);
				if (acc != null)
					login(con);
				break;
			default:
				break;
			}
		} while (choice != 0);

	}

	public static void login(Connection con) throws SQLException {
		System.out.println("Please enter the username and password To login");
		System.out.print("Username: ");
		Scanner sc2 = new Scanner(System.in);
		String uname = sc2.next();
		System.out.println();

		System.out.print("Password: ");
		String password = sc2.next();
		System.out.println();

		java.sql.Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from registration");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)
					+ " " + rs.getString(5) + " " + rs.getString(6));
		}
//		ResultSet rs = stmt.executeQuery("Select user_name, password from registration where user_name="+uname);
//		if(rs.getString("user_name").equals(uname) && rs.getString("password").equals(password)) {
//			System.out.println("You are successfully Logged In !!!!");
//		}else{
//			System.out.println("Invalid Username or Password");
//			login(con);
//		}

	}

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "manager");
		System.out.println("Welcome to the Banking System !!!!!");
		entryPoint(con);

	}

}
