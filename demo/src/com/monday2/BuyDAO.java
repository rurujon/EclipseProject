package com.monday2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.monday2.LoginDTO;
import com.monday2.SalesDTO;
import com.util.DBConn;


public class BuyDAO {

	public int sales(SalesDTO saleDto, LoginDTO logDto) {			//구매 메서드.
		//loginid가 저장되어있는 logdto


		Connection conn = DBConn.getConnection();					//평범한 db 연동 과정
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		int result = 0;


		String topProductName = null;


		try {

			sql = "select productname, price, maker from product where productno = ?";	//구입할 물건의 productno를 where에 넣어서
																						//product 테이블에서 매칭되는 productname, price, maker를 select

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, saleDto.getProductNo());

			rs=pstmt.executeQuery();

			if(rs.next()) {

				saleDto.setProductName(rs.getString("productname"));					//saleDTO에 sale테이블에 들어갈 productname 저장
				saleDto.setPrice(rs.getInt("price"));									//마찬가지로 price 저장

				saleDto.setMaker(rs.getString("maker"));								//마찬가지로 maker 저장.

				sql="insert into sales (userid,productname,price,maker,buydate) values (?,?,?,?,sysdate) ";	//아이디,제품이름,가격,메이커,구입날짜를 update

				pstmt= conn.prepareStatement(sql);
				pstmt.setString(1, logDto.getId());
				pstmt.setString(2, saleDto.getProductName());
				pstmt.setInt(3, saleDto.getPrice());
				pstmt.setString(4, saleDto.getMaker());

				result = pstmt.executeUpdate();
				
				int currentPoint = saleDto.getPoint();											//포인트 추가 구문.
	            int addPoint = currentPoint + (int)(saleDto.getPrice() * 0.01);
	            
	            sql = "update userinfo set point = point + ? where userid = ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, addPoint);
	            pstmt.setString(2, logDto.getId());

	            pstmt.executeUpdate();


				sql="select productname, count(*) as cnt from sales where maker = ? group by productname order by count(*) desc ";
				//데이터를 입력함과 동시에, 조금전 구매한 물건의 maker 값을 가진 productname을 count해서 count가 많은 순으로 정렬
				//즉, 가장 첫 행에 가장 많이 구매한 제품이 올라오게 된다.

				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, saleDto.getMaker());

				rs=pstmt.executeQuery();

				if(rs.next()) {

					topProductName = rs.getString("productname");
					//그러니 가장 위에 있는 행 하나만 추출하면 그게 가장 많이 팔린 maker의 물건이다.

				}

				sql="update makerlist set maxproduct = ? where maker = ?";	//그대로 그 maker의 maxproduct에 업데이트
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, topProductName);
				pstmt.setString(2, saleDto.getMaker());

				pstmt.executeUpdate();

				sql="commit;";

			}

			rs.close();
			pstmt.close();


		} catch (Exception e) {
			// TODO: handle exception
		}

		return result;

	}
	
	public int move(LoginDTO logDto, SalesDTO saleDto) {			//장바구니 저장 메서드.
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		int result = 0;
		
		BuyDTO dto = new BuyDTO();
		dto.setUserid(logDto.getId());
		
		try {
			
			sql = "select productname, price, maker from product where productno = ? ";	//구입할 물건의 productno를 where에 넣어서
			//product 테이블에서 매칭되는 productname, price, maker를 select

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, saleDto.getProductNo());
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				
				dto.setProductname(rs.getString("productname"));
				dto.setPrice(rs.getInt("price"));
				dto.setMaker(rs.getString("maker"));
				
			}
			
			sql = "insert into buy (userid,productname,price,maker) values (?,?,?,?) ";	//아이디,제품이름,가격,제조사 장바구니에 저장.
			
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getProductname());
			pstmt.setInt(3, dto.getPrice());
			pstmt.setString(4, dto.getMaker());

			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	public int pointUse(LoginDTO logDto, SalesDTO saleDto) {		//포인트 사용.
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		int result = 0;
		String productName = null;
		
		try {
			
			//productname 검색
			sql = "select productname from product where productno = ? ";		//입력한 제품번호에 매칭되는 제품이름 셀렉
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, saleDto.getProductNo());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				
				productName = rs.getString("productname");		//번호에 매칭되는 productname 입력
			}
			pstmt.close();
			
			sql = "update sales set discount = ? where userid = ? and productname = ? and ";		//사용한 포인트만큼 discount에 추가.
			sql+= "buydate = (select max(buydate) from sales where userid = ? and productname = ? and discount is null) ";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, logDto.getPoint());
			pstmt.setString(2, logDto.getId());
			pstmt.setString(3, productName);
			pstmt.setString(4, logDto.getId());
			pstmt.setString(5, productName);
			
			result=pstmt.executeUpdate();
			pstmt.close();
			
			sql = "update userinfo set point = point - ? ";			//사용한 포인트만큼 userinfo의 포인트 차감.
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, logDto.getPoint());
			result = pstmt.executeUpdate();
			pstmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
		
	}
	
	public boolean pointCheck(LoginDTO logDto) {		//포인트 존재 여부 확인.
		
		boolean result = false;
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="select point from userinfo where userid = ? ";		//로그인한 아이디가 가진 포인트를 셀렉
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, logDto.getId());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				
				int savePoint = rs.getInt("point");					//유저가 가진 포인트
				int usePoint = logDto.getPoint();					//사용하고자 하는 포인트.
				
				
				if((savePoint-usePoint)>0) {						//유저가 가진 포인트가 크다면 true를 반환.
					result = true;
				}
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	public int listBuy2(LoginDTO logDto) {						//장바구니 구매.
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmtSelect = null;
		PreparedStatement pstmtInsert = null;
		ResultSet rs = null;
		String sql;
		int result = 0;
		
		try {
			
			sql = "SELECT userid, productname, price, maker FROM buy";				//장바구니 리스트의 데이터를 셀렉.
			
			pstmtSelect = conn.prepareStatement(sql);
			rs=pstmtSelect.executeQuery();
			
			sql = "INSERT INTO sales (userid, productname, price, maker, buydate) VALUES (?, ?, ?, ?, sysdate)";
			pstmtInsert = conn.prepareStatement(sql);								//sysdate와 함께 sales 테이블에 저장.
			
			while(rs.next()) {
				String userid = rs.getString("userid");
				String productName = rs.getString("productname");
				int price = rs.getInt("price");
				String maker = rs.getString("maker");
				
				pstmtInsert.setString(1, userid);
				pstmtInsert.setString(2, productName);
				pstmtInsert.setInt(3, price);
				pstmtInsert.setString(4, maker);
				
				result = pstmtInsert.executeUpdate();
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return result;
		
	}
	
	public List<BuyDTO> getList(){					//장바구니 리스트 출력.
		
		List<BuyDTO> lists = new ArrayList<BuyDTO>();
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="select * from buy ";
			
			pstmt = conn.prepareStatement(sql);	//select는 결과를 db값으로 반환한다.
			
			rs = pstmt.executeQuery();  		//그렇기에 ResultSet을 사용한다.
			
			while(rs.next()) { 		//rs에 데이터가 있는 동안
				
				BuyDTO dto = new BuyDTO();
				
				dto.setUserid(rs.getString("userid"));
				dto.setProductname(rs.getString("productname"));
				dto.setPrice(rs.getInt("price"));
				dto.setMaker(rs.getString("maker"));
				
				lists.add(dto);
			}
			
			
		} catch (Exception e) {

			System.out.println(e.toString());
		}
		
		return lists;
	}
	
	public int delete() {					//장바구니 리스트 삭제.
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		int result = 0;
		
		try {
			
			sql = "delete from buy";
			pstmt=conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
		
	}
	
	public boolean productCheck(String buyNum) {
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		boolean result = false;
		
		try {
			
			sql="select productno from product where productno = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, buyNum);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				result = true;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	
	public int listBuy(LoginDTO logDto) {						//장바구니 구매.

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmtSelect = null;
		PreparedStatement pstmtInsert = null;
		PreparedStatement pstmtUpdate = null;
		ResultSet rs = null;
		String sql;
		int result = 0;

		try {

			sql = "SELECT userid, productname, price, maker FROM buy";				//장바구니 리스트의 데이터를 셀렉.

			pstmtSelect = conn.prepareStatement(sql);
			rs=pstmtSelect.executeQuery();

			sql = "INSERT INTO sales (userid, productname, price, maker, buydate) VALUES (?, ?, ?, ?, sysdate)";
			pstmtInsert = conn.prepareStatement(sql);								//sysdate와 함께 sales 테이블에 저장.

			while(rs.next()) {
				String userid = rs.getString("userid");
				String productName = rs.getString("productname");
				int price = rs.getInt("price");
				String maker = rs.getString("maker");

				pstmtInsert.setString(1, userid);
				pstmtInsert.setString(2, productName);
				pstmtInsert.setInt(3, price);
				pstmtInsert.setString(4, maker);

				result = pstmtInsert.executeUpdate();

				int pointsAdd = (int)(price * 0.01);
				sql = "UPDATE userinfo SET point = point + ? WHERE userid = ?";
				pstmtUpdate = conn.prepareStatement(sql);
				pstmtUpdate.setInt(1, pointsAdd);
				pstmtUpdate.setString(2, userid);
				pstmtUpdate.executeUpdate();

			}

		} catch (Exception e) {
			// TODO: handle exception
		}


		return result;

	}
	
	public boolean priceCheck(LoginDTO logDto, SalesDTO saleDto) {
		
		boolean result = false;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		String productName = null;
		
		try {
			
			sql = "select productname from product where productno = ? ";		//입력한 제품번호에 매칭되는 제품이름 셀렉
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, saleDto.getProductNo());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				
				productName = rs.getString("productname");		//번호에 매칭되는 productname 입력
			}
			
			sql = "select price from product where productname = ?";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, productName);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int price = rs.getInt("price");
				int point = logDto.getPoint();
				if((price-point)>0) {
					result = true;
				}
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return result;
	}
	

}
