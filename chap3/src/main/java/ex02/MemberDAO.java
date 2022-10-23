package ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ex02.MemberVO;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost/spring4fs";
	
	void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "spring4", "spring4");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	void disconnect() {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<MemberVO> listMembers() {
		connect();
		
		ArrayList<MemberVO> list = new ArrayList<>();
		String sql = "select * from member order by id";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberVO member = new MemberVO();
				member.setId(rs.getInt("id"));
				member.setEmail(rs.getString("email"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setRegdate(rs.getString("regdate"));
				list.add(member);
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		} finally {
			disconnect();
		}
		return list;
	}
	
	public int insert (MemberVO member) {
		String sql = "insert into member(email, password, name, regdate) values(?, ?, ?, ?)";
		int result = 0;
		
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getRegdate());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
			return result;
		} finally {
			disconnect();
		}
		
		return result;
	}
	
	public int updatePassword (String password, int id) {
		String sql = "update member set password = ? where id = ?";
		int result = 0;
		
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setInt(2, id);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
			return result;
		} finally {
			disconnect();
		}
		
		return result;
	}
	
	public int update (MemberVO member) {
		String sql = "update member set email =?, password =?, name=?, regdate=? where id = ?"; // isnert문
		int result = 0;
		
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getRegdate());
			pstmt.setInt(5, member.getId()); // insert
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
			return result;
		} finally {
			disconnect();
		}
		
		return result;
	}
	
	public int delete (int id) {
		String sql = "delete from member where id = ?"; // delete문
		int result = 0;
		
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id); // insert
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
			return result;
		} finally {
			disconnect();
		}
		
		return result;
	}
	
	public MemberVO getMemberById(int id) {
		connect();
		
		MemberVO member = new MemberVO();
		String sql = "select * from member where id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				member.setId(rs.getInt("id"));
				member.setEmail(rs.getString("email"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setRegdate(rs.getString("regdate"));
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		} finally {
			disconnect();
		}
		return member;
	}
	
	public MemberVO getMemberByEmail(String email) {
		connect();
		
		MemberVO member = new MemberVO();
		String sql = "select * from member where email = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				member.setId(rs.getInt("id"));
				member.setEmail(rs.getString("email"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setRegdate(rs.getString("regdate"));
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		} finally {
			disconnect();
		}
		return member;
	}
	
	
}
