package com.mysite.board.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysite.user.VO.Users;

public class BoardDAO {

	public static void insert(Users users) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DAOConnection.connection();

			String sql = "insert into users values(user_SEQ.nextval, ?,?,?,?)";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, users.getName());
			stmt.setString(2, users.getEmail());
			stmt.setString(3, users.getPassword());
			stmt.setString(4, users.getGender());
			stmt.executeUpdate();//
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static Users selectNo(String email, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Users users = null;
		try {
			conn = DAOConnection.connection();
			String sql = "select no,name  from users where email=? and password=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				users = new Users();
				users.setName(name);
				users.setNo(no);

			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}

	public static Users selectNo(Long no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Users users = null;
		try {
			conn = DAOConnection.connection();
			String sql = "select no,name,email,password,gender  from users where no = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, no);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				no = rs.getLong(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String password = rs.getString(4);
				String gender = rs.getString(5);

				users = new Users();
				users.setName(name);
				users.setNo(no);
				users.setEmail(email);
				users.setGender(gender);
				users.setPassword(password);

			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}

	public static void update(Users users) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DAOConnection.connection();

			String sql = "update users set name =?, password = ? , gender = ? where no =?";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, users.getName());
			stmt.setString(2, users.getPassword());
			stmt.setString(3, users.getGender());
			stmt.setLong(4, users.getNo());

			stmt.executeUpdate();//
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
