package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
//	private Context initContext = null;
//	private Context envContext = null;
//	private DataSource ds = null;

	private static BoardDAO single;

	private BoardDAO() {
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println("클래스 로드 성공~!");
//
//		} catch (ClassNotFoundException e) {
//			System.out.println("클래스 로드 실패..");
//		}
	}

	public static BoardDAO getInstance() {
		if (single == null) {
			single = new BoardDAO();
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

	// 전체 목록 가져오기
	public ArrayList<BoardDTO> getAll() {
		ArrayList<BoardDTO> list = new ArrayList<>();
		BoardDTO searDTO = null;
		if (connect()) {
			try {
				stmt = conn.createStatement();
				String sql = "select * from board order by no desc";
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					searDTO = new BoardDTO();
					searDTO.setNum(rs.getInt("no"));
					searDTO.setTitle(rs.getString("title"));
					searDTO.setId(rs.getString("id"));
					searDTO.setName(rs.getString("name"));
					searDTO.setText(rs.getString("text"));
					searDTO.setPwd(rs.getString("pwd"));
					searDTO.setDay(rs.getString("day"));

					list.add(searDTO);
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
		return list;
	}

	// 글 등록
	public boolean insert(BoardDTO bdto) {
		if (this.connect()) {
			try {
				String sql = "insert into board values (board_no.nextval,?,?,?,?,?,sysdate)";
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, bdto.getTitle());
				pstmt.setString(2, bdto.getId());
				pstmt.setString(3, bdto.getName());
				pstmt.setString(4, bdto.getText());
				pstmt.setString(5, bdto.getPwd());

				int r = pstmt.executeUpdate();

				if (r > 0) {
					return true;
				}
				pstmt.close();
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
			System.out.println("DB 접속 오류..!");
		}
		return false;
	}

	// 작성 글 불러오기
	public BoardDTO getOne(String num) {
		BoardDTO searDTO = new BoardDTO();
		if (connect()) {
			try {
				stmt = conn.createStatement();
				String sql = "select * from board where no ='" + num + "'";

				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					searDTO.setNum(rs.getInt("no"));
					searDTO.setTitle(rs.getString("title"));
					searDTO.setId(rs.getString("id"));
					searDTO.setName(rs.getString("name"));
					searDTO.setText(rs.getString("text"));
					searDTO.setPwd(rs.getString("pwd"));
					searDTO.setDay(rs.getString("day"));
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

	// 비밀번호 체크
	public boolean pwdChk(String num, String pwd) {
		if (connect()) {
			try {
				stmt = conn.createStatement();
				String sql = "select * from board where no='" + num + "'and pwd ='" + pwd + "'";
				rs = stmt.executeQuery(sql);

				if (rs.next()) {
					return true;
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
		return false;
	}

	// 글 수정
	public boolean updateOne(BoardDTO bdto) {
		if (this.connect()) {
			try {
				String sql = "update board set text = ? where no = ?";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, bdto.getText());
				psmt.setInt(2, bdto.getNum());

				int r = psmt.executeUpdate();

				if (r > 0) {
					return true;
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
			System.out.println("DB 접속 오류..!");
		}
		return false;
	}
	
	// 글 삭제
	public boolean delOne(String num) {
		if (this.connect()) {
			try {
				String sql = "delete from board where no = ?";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, num);

				int r = psmt.executeUpdate();

				if (r > 0) {
					return true;
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
			System.out.println("DB 접속 오류..!");
		}
		return false;
	}

}
