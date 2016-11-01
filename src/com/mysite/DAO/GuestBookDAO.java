package com.mysite.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysite.VO.GuestBook;

public class GuestBookDAO {

	public static Long insert(GuestBook guestBook) {
		Long no = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DAOConnection.connection();

			String sql = "insert into guestBook values(GUESTBOOK_SEQ.nextval, ?,?,?,sysdate)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, guestBook.getName());
			pstmt.setString(2, guestBook.getPassword());
			pstmt.setString(3, guestBook.getContent());
			pstmt.executeUpdate();//

			stmt = conn.createStatement();

			sql = "select guestbook_seq.currval from dual";
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				no = rs.getLong(1);
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return no;
	}

	public static ArrayList<GuestBook> selectAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<GuestBook> list = null;
		try {
			conn = DAOConnection.connection();
			String sql = "select rank() over (order by regdate asc),id, name, password, content,to_char(regdate,'yyyy-mm-dd hh:mi:ss') from guestbook order by regdate desc";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			list = new ArrayList<GuestBook>();
			while (rs.next()) {
				GuestBook gb = new GuestBook();
				gb.setRank(rs.getLong(1));
				gb.setId(rs.getLong(2));
				gb.setName(rs.getString(3));
				gb.setPassword(rs.getString(4));
				gb.setContent(rs.getString(5));
				gb.setRegdate(rs.getString(6));
				list.add(gb);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public static ArrayList<GuestBook> selectAll(int page) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<GuestBook> list = null;
		try {
			conn = DAOConnection.connection();
			String sql = " select * from (select a.*, rownum rn from ( select id,  name, content, password, to_char(regdate, 'yyyy-mm-dd hh:mi:ss' ) from guestbook order by regdate desc ) a ) where (?-1)*5+1 <= rn and rn <= ?*5";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page);
			pstmt.setInt(2, page);
			rs = pstmt.executeQuery();

			list = new ArrayList<GuestBook>();
			while (rs.next()) {
				GuestBook gb = new GuestBook();
				gb.setId(rs.getLong(1));
				gb.setName(rs.getString(2));
				gb.setContent(rs.getString(3));
				gb.setPassword(rs.getString(4));
				gb.setRegdate(rs.getString(5));
				list.add(gb);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public static GuestBook get(Long id) {
		GuestBook vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = DAOConnection.connection();
		String sql = "select id,name,password,content,TO_CHAR (regdate, 'yyyy-mm-dd hh:mi:ss') from guestbook where id = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new GuestBook();
				vo.setId(rs.getLong(1));
				vo.setName(rs.getString(2));
				vo.setPassword(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setRegdate(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return vo;
	}

	public static void delete(Long id) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DAOConnection.connection();

			String sql = "delete guestbook where id = ?";

			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);

			stmt.executeUpdate();//
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static boolean delete(GuestBook vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			conn = DAOConnection.connection();

			String sql = "DELETE FROM GUESTBOOK WHERE id = ? and name = ? and password = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPassword());
			count = pstmt.executeUpdate();

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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count == 1;
	}
}
