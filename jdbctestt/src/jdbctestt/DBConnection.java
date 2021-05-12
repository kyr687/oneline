package jdbctestt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
private Connection con;
public DBConnection() {
try
{
String url = "jdbc:mysql://localhost/?characterEncoding=UTF-8&serverTimezone=UTC";
String user = "root";
String passwd = "root11";
con = DriverManager.getConnection(url, user, passwd);
con.close();
System.out.println("DB연결 성공");
}
catch (SQLException e)
{
System.out.println("DB연결 실패");
System.out.print("사유 : " + e.getMessage());
}
}
public static void main(String[] args) {
new DBConnection();
}
}
