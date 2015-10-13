package jaehyun.dao;

import jaehyun.vo.MemberVo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
	public Connection getConnection() throws SQLException{
		Connection connection =null;
		try{
			//1. 드라이버로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. 커넥션 만들기
			String dbURL= "jdbc:oracle:thin:@localhost:1521:xe";
			
			connection=DriverManager.getConnection(dbURL, "webdb","webdb");
			
		}catch(ClassNotFoundException ex){
			System.out.println("다라이버 로딩실패 :"+ex);
			
		}
		return connection;
	}
	public void insert(MemberVo vo){
		try{
			//1. dbconnection
			Connection conn = getConnection();
			
			//2. preare statement
			String sql=
					"insert "+
							"into member "+ 
							"values(member_no_seq.nextval, ?,?,?,SYSDATE))";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//3. binding
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPassword());
			
			//4. execute SQL
			pstmt.executeUpdate();
			
			//5. 자원정리
			pstmt.close();
			conn.close();
					
			
		}catch(SQLException ex){
			System.out.println(ex);
			
		}
	}
	public MemberVo get(String email, String password){
		MemberVo vo = null;
		try{
			//1. get Connection
			Connection conn  = getConnection();
			
			//2. preare statement
			String sql =
					"select no, name, email, date from member where email=? and password=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//3.binding
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			//4. execute
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				
				vo =new MemberVo();
				vo.setNo(rs.getLong(1));
				vo.setName(rs.getString(2));
				vo.setEmail(rs.getString(3));
				vo.setDate(rs.getString("gender"));
			}
			pstmt.close();
			conn.close();
			
			return vo;
			
		}catch(SQLException ex){
			System.out.println("SQL 에러얌 "+ex);
			
		}
		return vo;
	}
	public MemberVo get(Long no){
		MemberVo vo =null;
		return vo;
	}
	public void update(MemberVo vo){
		try{
			//1. get Connection
			Connection conn  = getConnection();
			
			//2. preare statement
			String sql =
					"update member "+
					"set name=? "+
					"email=? "+
					"password=? "+
					"where no=? ";
					
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//3.binding
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPassword());
			pstmt.setLong(4, vo.getNo());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		
		}catch(SQLException ex){
			System.out.println("sql 에러얌"+ex);
			
		}
	}
	
}
