<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String url = "jdbc:mysql://localhost/world?characterEncoding=UTF-8&serverTimezone=UTC";
String user = "root";
String passwd = "root11";
Connection con = null;
String sql = "select * from oneline";
PreparedStatement pstmt = null;
PreparedStatement pstmt2 = null;

Class.forName("com.mysql.jdbc.Driver");

con = DriverManager.getConnection(url, user, passwd);

pstmt2 = con.prepareStatement("use world");
pstmt2.executeUpdate();
pstmt2.close();

pstmt = con.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery();

while(rs.next()) {
	int no = rs.getInt(1);
	String memo = rs.getString("memo");
	String wdate = rs.getString(3);
	
	out.println("일련번호"+no +":"+memo+ ":("+wdate+")<br>");
}

/*삭제 기능------일련번호 이용해서 삭제하고 싶은데
while(){
	PreparedStatement pstmt = con.prepareStatement();   
	pstmt.setInt();
	return pstmt2.executeUpdate();
}
*/

rs.close();
pstmt.close();		
con.close();
out.println("DB조회 성공");
%>

</body>
</html>