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

	public int sales(SalesDTO saleDto, LoginDTO logDto) {			//���� �޼���.
		//loginid�� ����Ǿ��ִ� logdto


		Connection conn = DBConn.getConnection();					//����� db ���� ����
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		int result = 0;


		String topProductName = null;


		try {

			sql = "select productname, price, maker from product where productno = ?";	//������ ������ productno�� where�� �־
																						//product ���̺��� ��Ī�Ǵ� productname, price, maker�� select

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, saleDto.getProductNo());

			rs=pstmt.executeQuery();

			if(rs.next()) {

				saleDto.setProductName(rs.getString("productname"));					//saleDTO�� sale���̺� �� productname ����
				saleDto.setPrice(rs.getInt("price"));									//���������� price ����

				saleDto.setMaker(rs.getString("maker"));								//���������� maker ����.

				sql="insert into sales (userid,productname,price,maker,buydate) values (?,?,?,?,sysdate) ";	//���̵�,��ǰ�̸�,����,����Ŀ,���Գ�¥�� update

				pstmt= conn.prepareStatement(sql);
				pstmt.setString(1, logDto.getId());
				pstmt.setString(2, saleDto.getProductName());
				pstmt.setInt(3, saleDto.getPrice());
				pstmt.setString(4, saleDto.getMaker());

				result = pstmt.executeUpdate();
				
				int currentPoint = saleDto.getPoint();											//����Ʈ �߰� ����.
	            int addPoint = currentPoint + (int)(saleDto.getPrice() * 0.01);
	            
	            sql = "update userinfo set point = point + ? where userid = ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, addPoint);
	            pstmt.setString(2, logDto.getId());

	            pstmt.executeUpdate();


				sql="select productname, count(*) as cnt from sales where maker = ? group by productname order by count(*) desc ";
				//�����͸� �Է��԰� ���ÿ�, ������ ������ ������ maker ���� ���� productname�� count�ؼ� count�� ���� ������ ����
				//��, ���� ù �࿡ ���� ���� ������ ��ǰ�� �ö���� �ȴ�.

				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, saleDto.getMaker());

				rs=pstmt.executeQuery();

				if(rs.next()) {

					topProductName = rs.getString("productname");
					//�׷��� ���� ���� �ִ� �� �ϳ��� �����ϸ� �װ� ���� ���� �ȸ� maker�� �����̴�.

				}

				sql="update makerlist set maxproduct = ? where maker = ?";	//�״�� �� maker�� maxproduct�� ������Ʈ
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
	
	public int move(LoginDTO logDto, SalesDTO saleDto) {			//��ٱ��� ���� �޼���.
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		int result = 0;
		
		BuyDTO dto = new BuyDTO();
		dto.setUserid(logDto.getId());
		
		try {
			
			sql = "select productname, price, maker from product where productno = ? ";	//������ ������ productno�� where�� �־
			//product ���̺��� ��Ī�Ǵ� productname, price, maker�� select

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, saleDto.getProductNo());
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				
				dto.setProductname(rs.getString("productname"));
				dto.setPrice(rs.getInt("price"));
				dto.setMaker(rs.getString("maker"));
				
			}
			
			sql = "insert into buy (userid,productname,price,maker) values (?,?,?,?) ";	//���̵�,��ǰ�̸�,����,������ ��ٱ��Ͽ� ����.
			
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
	
	public int pointUse(LoginDTO logDto, SalesDTO saleDto) {		//����Ʈ ���.
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		int result = 0;
		String productName = null;
		
		try {
			
			//productname �˻�
			sql = "select productname from product where productno = ? ";		//�Է��� ��ǰ��ȣ�� ��Ī�Ǵ� ��ǰ�̸� ����
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, saleDto.getProductNo());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				
				productName = rs.getString("productname");		//��ȣ�� ��Ī�Ǵ� productname �Է�
			}
			pstmt.close();
			
			sql = "update sales set discount = ? where userid = ? and productname = ? and ";		//����� ����Ʈ��ŭ discount�� �߰�.
			sql+= "buydate = (select max(buydate) from sales where userid = ? and productname = ? and discount is null) ";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, logDto.getPoint());
			pstmt.setString(2, logDto.getId());
			pstmt.setString(3, productName);
			pstmt.setString(4, logDto.getId());
			pstmt.setString(5, productName);
			
			result=pstmt.executeUpdate();
			pstmt.close();
			
			sql = "update userinfo set point = point - ? ";			//����� ����Ʈ��ŭ userinfo�� ����Ʈ ����.
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, logDto.getPoint());
			result = pstmt.executeUpdate();
			pstmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
		
	}
	
	public boolean pointCheck(LoginDTO logDto) {		//����Ʈ ���� ���� Ȯ��.
		
		boolean result = false;
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="select point from userinfo where userid = ? ";		//�α����� ���̵� ���� ����Ʈ�� ����
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, logDto.getId());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				
				int savePoint = rs.getInt("point");					//������ ���� ����Ʈ
				int usePoint = logDto.getPoint();					//����ϰ��� �ϴ� ����Ʈ.
				
				
				if((savePoint-usePoint)>0) {						//������ ���� ����Ʈ�� ũ�ٸ� true�� ��ȯ.
					result = true;
				}
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	public int listBuy2(LoginDTO logDto) {						//��ٱ��� ����.
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmtSelect = null;
		PreparedStatement pstmtInsert = null;
		ResultSet rs = null;
		String sql;
		int result = 0;
		
		try {
			
			sql = "SELECT userid, productname, price, maker FROM buy";				//��ٱ��� ����Ʈ�� �����͸� ����.
			
			pstmtSelect = conn.prepareStatement(sql);
			rs=pstmtSelect.executeQuery();
			
			sql = "INSERT INTO sales (userid, productname, price, maker, buydate) VALUES (?, ?, ?, ?, sysdate)";
			pstmtInsert = conn.prepareStatement(sql);								//sysdate�� �Բ� sales ���̺� ����.
			
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
	
	public List<BuyDTO> getList(){					//��ٱ��� ����Ʈ ���.
		
		List<BuyDTO> lists = new ArrayList<BuyDTO>();
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="select * from buy ";
			
			pstmt = conn.prepareStatement(sql);	//select�� ����� db������ ��ȯ�Ѵ�.
			
			rs = pstmt.executeQuery();  		//�׷��⿡ ResultSet�� ����Ѵ�.
			
			while(rs.next()) { 		//rs�� �����Ͱ� �ִ� ����
				
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
	
	public int delete() {					//��ٱ��� ����Ʈ ����.
		
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
	
	
	public int listBuy(LoginDTO logDto) {						//��ٱ��� ����.

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmtSelect = null;
		PreparedStatement pstmtInsert = null;
		PreparedStatement pstmtUpdate = null;
		ResultSet rs = null;
		String sql;
		int result = 0;

		try {

			sql = "SELECT userid, productname, price, maker FROM buy";				//��ٱ��� ����Ʈ�� �����͸� ����.

			pstmtSelect = conn.prepareStatement(sql);
			rs=pstmtSelect.executeQuery();

			sql = "INSERT INTO sales (userid, productname, price, maker, buydate) VALUES (?, ?, ?, ?, sysdate)";
			pstmtInsert = conn.prepareStatement(sql);								//sysdate�� �Բ� sales ���̺� ����.

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
			
			sql = "select productname from product where productno = ? ";		//�Է��� ��ǰ��ȣ�� ��Ī�Ǵ� ��ǰ�̸� ����
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, saleDto.getProductNo());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				
				productName = rs.getString("productname");		//��ȣ�� ��Ī�Ǵ� productname �Է�
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
