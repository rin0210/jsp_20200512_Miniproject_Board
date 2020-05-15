package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
//	private Context initContext = null;
//	private Context envContext = null;
//	private DataSource ds = null;

	private static MemberDAO single;

	private MemberDAO() {
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println("클래스 로드 성공~!");
//
//		} catch (ClassNotFoundException e) {
//			System.out.println("클래스 로드 실패..");
//		}
	}

	public static MemberDAO getInstance() {
		if (single == null) {
			single = new MemberDAO();
		}
		return single;
	}

	private boolean connect() {
		boolean cFalg = false;
		try {
				Context initContext = new InitialContext();
				Context envContext = (Context) initContext.lookup("java:/comp/env");
				DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
				conn = ds.getConnection();
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "11111111");
			cFalg = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cFalg;
	}

	// 아이디 중복체크
	public boolean idCheck(String id) {
		boolean result = true;
		if (connect()) {
			try {
				stmt = conn.createStatement();
				String sql = "select * from member where id='" + id + "'";
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					result = false;
				}

			} catch (SQLException e) {
				e.printStackTrace();

			} finally {
				try {
					if (stmt != null)
						stmt.close();
					if (conn != null)
						conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("DB 접속 오류!!");
		}
		return result;
	}

	// 회원 등록
	public void insert(MemberDTO mdto) {
		if (connect()) {

			try {
				String sql = "insert into member values(?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mdto.getId());
				pstmt.setString(2, mdto.getPwd());
				pstmt.setString(3, mdto.getName());

				pstmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();

			} finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("DB 접속 오류!!");
		}
	}

	// 로그인 체크
	public MemberDTO selOne(String id, String pwd) {
		MemberDTO searDTO = null;
		if (connect()) {
			try {
				stmt = conn.createStatement();
				String sql = "select * from member where id='" + id + "' and pwd='" + pwd + "'";
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					searDTO = new MemberDTO();
					searDTO.setId(rs.getString("id"));
					searDTO.setPwd(rs.getString("pwd"));
					searDTO.setName(rs.getString("name"));
				} 
				
			} catch (SQLException e) {
				e.printStackTrace();

			} finally {
				try {
					if (stmt != null)
						stmt.close();
					if (conn != null)
						conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("DB 접속 오류!!");
		}
		return searDTO;
	}

}
