package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.bean.UserBean;

public class UserDao {

	public void addUser(UserBean user) {// 1 2 3 4 5

		try {
			String dbUrl = "jdbc:mysql://localhost:3306/vd";
			String dbUserName = "root";
			String dbPassword = "root";
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			PreparedStatement pstmt = con
					.prepareStatement("insert into users (firstName,lastName,email,password) values (?,?,?,?)");
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
//strlen(str)

//strlen(str,str);
