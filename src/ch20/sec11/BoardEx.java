package ch20.sec11;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardEx {
    private Scanner sc = new Scanner(System.in);
    private Connection conn;
    private boolean DEBUG_MODE = true;
    private List<Board> boards = new ArrayList<>();

    //////////////////////////////////////////////////////////
    /// 생성자 : DB에 접속한다
    //////////////////////////////////////////////////////////
    public BoardEx() {
        // DB 접속 정보
        String server = "localhost";
        String port = "3306";
        String database = "thisisjava";
        String user_name = "root";
        String password = "1234";

        try{
            // JDBC Driver 등록
            Class.forName("org.mariadb.jdbc.Driver");

            // DB에 연결한다
            conn = DriverManager.getConnection("jdbc:mariadb://" +
                    server + ":" + port + "/" +
                    database +
                    "?useSSL=false", user_name, password);

            if(DEBUG_MODE && conn != null){
                System.out.println("Connected to database successfully");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC DRIVER LOAD FAILED : " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //////////////////////////////////////////////////////////
    /// readBoards : DB에서 게시물을 읽는다
    //////////////////////////////////////////////////////////
    private int readBoards() {
        int rows = 0;

        // 결과를 저장할 boards를 초기화 한다
        boards.clear();

        try{
            // SQL 쿼리 문을 만든다
            // SELECT bno, btitle, bcontent, bwriter, bdate FROM boards ORDER BY bno DESC;
            String sql = "SELECT bno, btitle, bcontent, bwriter, bdate FROM boards " +
                    "ORDER BY bno DESC";

            // 쿼리를 실행한다
            PreparedStatement ps = conn.prepareStatement(sql);
            if(DEBUG_MODE) System.out.println(ps);
            ResultSet rs = ps.executeQuery();

            // 가져온 데이터를 board에 저장한다
            while(rs.next()){
                Board board = new Board();
                board.setBno(rs.getInt("bno"));
                board.setBtitle(rs.getString("btitle"));
                board.setBcontent(rs.getString("bcontent"));
                board.setBwriter(rs.getString("bwriter"));
                board.setBdate(rs.getDate("bdate"));

                // boards array에 추가한다
                boards.add(board);

                // 읽은 행 개수를 저장한다
                rows++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            exit();
        }

        if(DEBUG_MODE) System.out.println("Board count: " + rows);

        return rows;
    }

    //////////////////////////////////////////////////////////
    /// printList : 상단 타이틀과 게시물 목록을 출력한다
    //////////////////////////////////////////////////////////
    public void printList() {
        // 제목 영역을 출력한다
        System.out.println();
        System.out.println("[게시물 목록]");
        System.out.println("--------------------------------------------------------------");
        System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date","title");
        System.out.println("--------------------------------------------------------------");

        // 게시물 목록을 출력한다
        if(boards.size() == 0){
            System.out.println("등록된 게시물이 없습니다.");
        }
        else {
            for (Board board : boards) {
                System.out.printf("%-6s%-12s%-16s%-40s\n", board.getBno(), board.getBwriter(), board.getBdate(), board.getBtitle());
            }
        }
    }

    //////////////////////////////////////////////////////////
    /// printContent : 게시물 내용을 출력한다
    //////////////////////////////////////////////////////////
    public void printContent(String no, String writer, String date, String title) {
        System.out.printf("%-6s%-12s%-16s%-40s\n", no, writer, date,title);
    }

    //////////////////////////////////////////////////////////
    /// printMenu : 하단 메뉴 영역을 출력한다
    //////////////////////////////////////////////////////////
    public void printMenu() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("메뉴: 1. Create  |  2. Read  |  3. Clear  |  4. Exit");
        System.out.print("메뉴 선택: ");
    }

    //////////////////////////////////////////////////////////
    /// processInput : 사용자의 입력을 처리한다
    //////////////////////////////////////////////////////////
    public void processInput(){
        // 값을 입력받는다
        String menuSel = sc.nextLine();

        switch(menuSel) {
            case "1" -> create();
            case "2" -> read();
            case "3" -> clear();
            case "4" -> exit();
            default -> System.out.println("1 ~ 4번 중 하나를 입력해주세요.");
        }
    }

    //////////////////////////////////////////////////////////
    /// create : 새 게시물을 작성하고, DB에 저장한다
    //////////////////////////////////////////////////////////
    private void create() {
        // 새 게시물 정보를 입력받는다
        System.out.println("");
        System.out.println("[새 게시물 작성]");
        System.out.print("작성자: ");
        String writer = sc.nextLine();
        System.out.print("제목: ");
        String title = sc.nextLine();
        System.out.print("내용: ");
        String content = sc.nextLine();
        System.out.println("--------------------------------------------------------------");
        while(true) {
            System.out.println("1. 저장 | 2. 취소");
            System.out.print("입력: ");
            String sel = sc.nextLine();

            if(sel.equals("1")){
                break ;
            }
            else if(sel.equals("2")){
                return ;
            }
            else {
                System.out.println("1 ~ 2번 중 하나를 입력해주세요.");
            }
        }

        try {
            // SQL 쿼리 문을 만든다
            // INSERT INTO boards VALUE (NULL, N'봄의 정원', N'정원의 꽃이 이쁘네요.', 'winter', now(), NULL, NULL);
            String sql = new StringBuilder()
                    .append("INSERT INTO boards ")
                    .append("VALUES(NULL, ?, ?, ?, now(), NULL, NULL)")
                    .toString();

            // 쿼리를 실행한다
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, content);
            ps.setString(3, writer);
            if(DEBUG_MODE) System.out.println(ps);
            ps.executeUpdate();

            // DB에 INSERT가 성공적으로 수행되었다면, 게시물 목록을 DB에서 다시 받아와서 업데이트 한다
            readBoards();
        } catch (SQLException e){
            e.printStackTrace();
            exit();
        }
    }

    private void update(int bno, Board board) {
        System.out.println("[게시물 수정 (제목과 내용만 수정 가능합니다)]");
        System.out.print("제목: ");
        board.setBtitle(sc.nextLine());
        System.out.print("내용: ");
        board.setBcontent(sc.nextLine());

        try {
            String sql = "UPDATE boards SET btitle=?, bcontent=? WHERE bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, board.getBtitle());
            ps.setString(2, board.getBcontent());
            ps.setInt(3, bno);
            if(DEBUG_MODE) System.out.println(ps);
            ps.executeUpdate();
            if(DEBUG_MODE) System.out.println("게시물이 DB에서 수정되었습니다. bno: " + bno);

            // DB에 UPDATE가 성공적으로 수행되었다면, 게시물 목록을 DB에서 다시 받아와서 업데이트 한다
            readBoards();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void delete(int bno) {
        try {
            String sql = "DELETE FROM boards WHERE bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bno);
            if(DEBUG_MODE) System.out.println(ps);
            ps.executeUpdate();
            if(DEBUG_MODE) System.out.println("게시물이 DB에서 삭제되었습니다. bno: " + bno);

            // DB에 DELETE가 성공적으로 수행되었다면, 게시물 목록을 DB에서 다시 받아와서 업데이트 한다
            readBoards();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    //////////////////////////////////////////////////////////
    /// read : 게시글물의 내용을 확인한다
    //////////////////////////////////////////////////////////
    private void read() {
        // 새 게시물 정보를 입력받는다
        System.out.println("");
        System.out.println("[게시글 읽기]");
        while(true) {
            System.out.print("게시물 번호 (0을 입력하면 이전 메뉴로 돌아갑니다): ");
            String sel = sc.nextLine();

            // 이전 메뉴로 돌아가기
            if(sel.equals("0")){
                return ;
            }

            try {
                int bno = Integer.parseInt(sel);
                for (Board board : boards) {
                    // 게시물 번호를 boards에서 찾는다
                    if (board.getBno() == bno) {
                        // 게시물의 상세 내용을 출력한다.
                        System.out.println("작성자: " + board.getBwriter());
                        System.out.println("작성일: " + board.getBdate());
                        System.out.println("제목: " + board.getBtitle());
                        System.out.println("내용: " + board.getBcontent());
                        System.out.println("--------------------------------------------------------------");
                        while(true) {
                            System.out.println("1. 게시글 수정  |  2. 게시글 삭제  |  3. 목록으로");
                            System.out.print("입력: ");
                            String selSub = sc.nextLine();

                            if(selSub.equals("1")){
                                // 게시글 수정
                                update(bno, board);
                                break ;
                            }
                            else if(selSub.equals("2")){
                                // delete board
                                delete(bno);
                                return ;
                            }
                            else if(selSub.equals("3")){
                                break;
                            }
                            else {
                                System.out.println("1 ~ 2번 중 하나를 입력해주세요.");
                            }
                        }

                        return ;
                    }
                }
                System.out.println("존재하지 않는 게시물입니다. 게시물 번호를 정확하게 입력해주세요.");
            } catch (NumberFormatException e) {
                // 입력 값을 숫자로 변환할 수 없는 경우 예외 처리
                System.out.println("숫자만 입력 가능합니다.");
            }
        }
    }

    //////////////////////////////////////////////////////////
    /// clear : 전체 게시물을 삭제한다
    //////////////////////////////////////////////////////////
    private void clear() {
        System.out.println("");
        System.out.println("[전체 게시물 삭제]");
        System.out.println("--------------------------------------------------------------");
        while(true) {
            System.out.println("전체 게시물을 삭제합니다. 삭제 후 되돌릴 수 없습니다.");
            System.out.println("1. 전체 삭제 | 2. 취소");
            System.out.print("입력: ");
            String sel = sc.nextLine();

            if(sel.equals("1")){
                break ;
            }
            else if(sel.equals("2")){
                return ;
            }
            else {
                System.out.println("1 ~ 2번 중 하나를 입력해주세요.");
            }
        }

        try {
            // SQL 쿼리 문을 만든다
            // TRUNCATE TABLE boards;
            String sql = "TRUNCATE TABLE boards;";

            // 쿼리를 실행한다
            PreparedStatement ps = conn.prepareStatement(sql);
            if(DEBUG_MODE) System.out.println(ps);
            ps.executeUpdate();

            // DB에 INSERT가 성공적으로 수행되었다면, 게시물 목록을 DB에서 다시 받아와서 업데이트 한다
            readBoards();
        } catch (SQLException e){
            e.printStackTrace();
            exit();
        }
    }

    //////////////////////////////////////////////////////////
    /// exit : 프로그램을 종료한다
    //////////////////////////////////////////////////////////
    private void exit() {
        // DB가 연결되어 있으면 종료한다
        closeDB();

        if(DEBUG_MODE)
            System.out.println("게시판 프로그램을 종료합니다.");

        // 프로그램을 종료한다.
        System.exit(0);
    }

    public void closeDB(){
        // 리소스를 정리한다
        try{
            conn.close();
            if(DEBUG_MODE)
                System.out.println("DB was closed successfully");
        } catch(SQLException e) {}
    }

    //////////////////////////////////////////////////////////
    /// execute : 프로그램 실행
    //////////////////////////////////////////////////////////
    public void execute(){
        // boards DB에서 게시글을 가져온다
        readBoards();

        while (true) {
            printList();
            printMenu();
            processInput();
        }
    }

    //////////////////////////////////////////////////////////
    /// main : main 함수
    //////////////////////////////////////////////////////////
    public static void main(String[] args) {
        BoardEx board = new BoardEx();
        board.execute();
    }
}
