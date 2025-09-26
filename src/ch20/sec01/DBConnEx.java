package ch20.sec01;

import java.sql.*;


public class DBConnEx {
    private void getUser(Connection conn, String userName) throws SQLException {
        // SQL 구문을 만든다
        String sql = new StringBuilder()
                .append("SELECT userid, username, userpassword, userage, useremail ")
                .append("FROM users ")
                .append("WHERE userid = ?")
                .toString();

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, userName);

        // SELECT 문은 executeQuery 메소드를 사용한다
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            User user = new User();
            user.setUserId(rs.getString("userid")); // 컬럼 이름을 지정해서 가지고 올 수 있다
            user.setUserName(rs.getString(2)); // 컬럼 순번을 이용해서 지정할 수도 있다
            user.setUserPassword(rs.getString(3));
            user.setUserAge(rs.getInt(4));
            user.setUserEmail(rs.getString(5));
            System.out.println(user);
        } else {
            System.out.println("존재하지 않는 ID 입니다 : "+userName);
        }

        rs.close();
    }

    private int addUser(Connection conn, String userId, String userName, String userPassword, int userage, String userEmail) throws SQLException {
        // QUERY 구문을 만든다. 매개화된 SQL 구문을 위해 VALUE 값을 ?로 대체했다
        String sql = new StringBuilder()
                .append("INSERT INTO users (userid, username, userpassword, userage, useremail) ")
                .append("VALUES (?, ?, ?, ?, ?)")
                .toString();

        // 매개화된 SQL 구문을 실행하기 위해 PreparedStatement를 만든다
        PreparedStatement pstmt = conn.prepareStatement(sql);
        // ?에 들어갈 값을 지정한다
        pstmt.setString(1, userId);
        pstmt.setString(2, userName);
        pstmt.setString(3, userPassword);
        pstmt.setInt(4, userage);
        pstmt.setString(5, userEmail);
        // 쿼리를 실행한다.
        int rows = pstmt.executeUpdate();
        System.out.println("rows affected: " + rows);
        pstmt.close();

        return rows;
    }

    private int addBoard(Connection conn, String btitle, String bcontent, String bwriter) throws SQLException {
        String sql = new StringBuilder()
                .append("INSERT INTO boards (bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata) ")
                .append("VALUES (NULL, ?, ?, ?, now(), NULL, NULL)")
                .toString();

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, btitle);
        ps.setString(2, bcontent);
        ps.setString(3, bwriter);

        System.out.println(ps);

        int rows = ps.executeUpdate();
        System.out.println("rows affected: " + rows);
        ps.close();
        return rows;
    }

//    private static int addBoards(Connection conn, String btitle, String bcontent, String bwriter, String bfilename, )

    public static void main(String[] args) {
        Connection conn = null;
        DBConnEx ex = new DBConnEx();

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("JDBC_DRIVER LOADED");

            // DB 접속 정보
            String server = "localhost";
            String port = "3306";
            String database = "thisisjava";
            String user_name = "root";
            String password = "1234";

            // DB에 연결한다
            conn = DriverManager.getConnection("jdbc:mariadb://" +
                    server + ":" + port + "/" +
                    database +
                    "?useSSL=false", user_name, password);

            if(conn != null)
                System.out.println("Connected to database successfully");

            //ex.addUser(conn,"winter", "한겨울", "12345", 25, "winter@mycompany.com");
            //ex.getUser(conn, "winter");
            ex.addBoard(conn, "봄의 정원", "정워의 꽃이 이쁘네요.", "winter");
            ex.addBoard(conn, "눈오는 날", "함박눈이 내려요.", "winter");
            ex.addBoard(conn, "크리스마스", "메리 크리스마스~", "winter");

        } catch (ClassNotFoundException e) {
            System.err.println("JDBC DRIVER LOAD FAILED : " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // DB 연결을 종료한다
            if(conn != null){
                try{
                    conn.close();
                } catch(SQLException e) {}
            }
        }
    }
}
