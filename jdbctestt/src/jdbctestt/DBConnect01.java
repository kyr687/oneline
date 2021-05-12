package jdbctestt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			String url = "jdbc:mysql://localhost/world?characterEncoding=UTF-8&serverTimezone=UTC";
			String user = "root";
			String passwd = "root11";
			Connection con = null;
			String sql = "select * from oneline";
			PreparedStatement pstmt = null;
		
			Class.forName("com.mysql.jdbc.Driver");
		
			con = DriverManager.getConnection(url, user, passwd);
			
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt(1);
				String memo = rs.getString(2);
				String wdate = rs.getString(3);
				
				System.out.println(no +":"+memo+ ":("+wdate+")");
			}
			rs.close();
			pstmt.close();
			//pstmt.executeUpdate();		
			con.close();
			System.out.println("DB연결 성공");
		}
		catch (SQLException e)
		{
			System.out.println("DB연결 실패");
			System.out.print("사유 : " + e.getMessage());
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
}
