package com.monday;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.monday.ProductDTO;
import com.util.DBConn;

import oracle.jdbc.OracleTypes;

public class MondayDAO {
	
	//��ü ��ǰ ����Ʈ DAO
	public List<ProductDTO> getList(){
		
		List<ProductDTO> lists = new ArrayList<ProductDTO>();
		
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="{call SelectAllProduct(?)}";
			
			cstmt = conn.prepareCall(sql);	//select�� ����� db������ ��ȯ�Ѵ�.
			
			//out �Ķ������ �ڷ���
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			//���ν��� ����
			cstmt.executeUpdate();
			
			//out �Ķ������ ���� �޾Ƴ�
			
			
			rs = (ResultSet)cstmt.getObject(1);  		//�׷��⿡ ResultSet�� ����Ѵ�.
			
			while(rs.next()) { 		//rs�� �����Ͱ� �ִ� ����
				
				ProductDTO dto = new ProductDTO();
				
				dto.setProductNo(rs.getString(1));
				dto.setProductName(rs.getString(2));
				dto.setPrice(rs.getInt(3));
				dto.setMaker(rs.getString(4));
				dto.setGrade(rs.getInt(5));
				dto.setBigCatal(rs.getString(6));
				dto.setSmallCatal(rs.getString(7));
				
				
				lists.add(dto);
			}
			
			rs.close();
			cstmt.close();
			
		} catch (Exception e) {

			System.out.println(e.toString());
		}
		
		return lists;
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//��з��� �ɷ��� ��ǰ ���
	public List<ProductDTO> getBigList(ProductDTO dto){
		
		List<ProductDTO> lists = new ArrayList<ProductDTO>();
		
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="{call SelectBigcatProduct(?,?)}";
			
			cstmt = conn.prepareCall(sql);	//select�� ����� db������ ��ȯ�Ѵ�.
			
			//out �Ķ������ �ڷ���
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.setString(2, dto.getSearchCatal());
			
			//���ν��� ����
			cstmt.executeUpdate();
			
			//out �Ķ������ ���� �޾Ƴ�
			
			System.out.println(dto.getSearchCatal());
			rs = (ResultSet)cstmt.getObject(1);  		//�׷��⿡ ResultSet�� ����Ѵ�.
			
			while(rs.next()) { 		//rs�� �����Ͱ� �ִ� ����
				
				
				
				dto.setProductNo(rs.getString(1));
				dto.setProductName(rs.getString(2));
				dto.setPrice(rs.getInt(3));
				dto.setMaker(rs.getString(4));
				dto.setGrade(rs.getInt(5));
				dto.setBigCatal(rs.getString(6));
				dto.setSmallCatal(rs.getString(7));
				
				
				lists.add(dto);
			}
			
			rs.close();
			cstmt.close();
			
		} catch (Exception e) {

			System.out.println(e.toString());
		}
		
		return lists;
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//�Һз��� �ɷ��� ������ ���
	public List<ProductDTO> getSmallList(ProductDTO dto){
		
		List<ProductDTO> lists = new ArrayList<ProductDTO>();
		
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="{call SelectSmallcatProduct(?,?)}";
			
			cstmt = conn.prepareCall(sql);	//select�� ����� db������ ��ȯ�Ѵ�.
			
			//out �Ķ������ �ڷ���
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.setString(2, dto.getSearchCatal());
			
			//���ν��� ����
			cstmt.executeUpdate();
			
			//out �Ķ������ ���� �޾Ƴ�
			
			System.out.println(dto.getSearchCatal());
			rs = (ResultSet)cstmt.getObject(1);  		//�׷��⿡ ResultSet�� ����Ѵ�.
			
			while(rs.next()) { 		//rs�� �����Ͱ� �ִ� ����
				
				
				
				dto.setProductNo(rs.getString(1));
				dto.setProductName(rs.getString(2));
				dto.setPrice(rs.getInt(3));
				dto.setMaker(rs.getString(4));
				dto.setGrade(rs.getInt(5));
				dto.setBigCatal(rs.getString(6));
				dto.setSmallCatal(rs.getString(7));
				
				
				lists.add(dto);
			}
			
			rs.close();
			cstmt.close();
			
		} catch (Exception e) {

			System.out.println(e.toString());
		}
		
		return lists;
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//��з� ����Ʈ ���
	
	public List<BigCatalDTO> bigCatalList(){
		
		List<BigCatalDTO> lists = new ArrayList<BigCatalDTO>();
		
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="{call SelectBigCatal(?)}";
			
			cstmt = conn.prepareCall(sql);	//select�� ����� db������ ��ȯ�Ѵ�.
			
			//out �Ķ������ �ڷ���
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			//���ν��� ����
			cstmt.executeUpdate();
			
			//out �Ķ������ ���� �޾Ƴ�
			
			
			rs = (ResultSet)cstmt.getObject(1);  		//�׷��⿡ ResultSet�� ����Ѵ�.
			
			while(rs.next()) { 		//rs�� �����Ͱ� �ִ� ����
				
				BigCatalDTO dto = new BigCatalDTO();
				
				dto.setBigCatal(rs.getString(1));
				
				lists.add(dto);
				
			}
			
			rs.close();
			cstmt.close();
			
		} catch (Exception e) {

			System.out.println(e.toString());
		}
		
		return lists;
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//�Һз� ����Ʈ ���
	
	public List<SmallCatalDTO> smallCatalList(ProductDTO dto){
		
		List<SmallCatalDTO> lists = new ArrayList<SmallCatalDTO>();
		
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="{call SelectSmallCatal(?,?)}";
			
			cstmt = conn.prepareCall(sql);	//select�� ����� db������ ��ȯ�Ѵ�.
			
			//out �Ķ������ �ڷ���
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.setString(2, dto.getSearchCatal());
			
			//���ν��� ����
			cstmt.executeUpdate();
			
			//out �Ķ������ ���� �޾Ƴ�
			
			
			rs = (ResultSet)cstmt.getObject(1);  		//�׷��⿡ ResultSet�� ����Ѵ�.
			
			while(rs.next()) { 		//rs�� �����Ͱ� �ִ� ����
				
				SmallCatalDTO smallDto = new SmallCatalDTO();
				
				smallDto.setBigCatal(rs.getString(1));
				smallDto.setSmallCatal(rs.getString(2));
				
				
				lists.add(smallDto);
			}
			
			rs.close();
			cstmt.close();
			
		} catch (Exception e) {

			System.out.println(e.toString());
		}
		
		return lists;
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//MakerList select
	public List<MakerListDTO> getMakerList(){
		
		List<MakerListDTO> lists = new ArrayList<MakerListDTO>();
		
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="{call SelectAllMakerList(?)}";
			
			cstmt = conn.prepareCall(sql);	//select�� ����� db������ ��ȯ�Ѵ�.
			
			//out �Ķ������ �ڷ���
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			//���ν��� ����
			cstmt.executeUpdate();
			
			//out �Ķ������ ���� �޾Ƴ�
			
			
			rs = (ResultSet)cstmt.getObject(1);  		//�׷��⿡ ResultSet�� ����Ѵ�.
			
			while(rs.next()) { 		//rs�� �����Ͱ� �ִ� ����
				
				MakerListDTO dto = new MakerListDTO();
				
				dto.setMaker(rs.getString(1));
				dto.setAddr(rs.getString(2));
				dto.setTel(rs.getString(3));
				dto.setMainProduct(rs.getString(4));
				dto.setMaxProduct(rs.getString(5));
				
				lists.add(dto);
			}
			
			rs.close();
			cstmt.close();
			
		} catch (Exception e) {

			System.out.println(e.toString());
		}
		
		return lists;
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public List<SalesDTO> getSalesList(LoginDTO logDto){
		
		List<SalesDTO> lists = new ArrayList<SalesDTO>();
		
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="{call SelectSalesList(?,?)}";
			
			cstmt = conn.prepareCall(sql);	//select�� ����� db������ ��ȯ�Ѵ�.
			
			//out �Ķ������ �ڷ���
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.setString(2, logDto.getId());
			
			//���ν��� ����
			cstmt.executeUpdate();
			
			//out �Ķ������ ���� �޾Ƴ�
			
			rs = (ResultSet)cstmt.getObject(1);  		//�׷��⿡ ResultSet�� ����Ѵ�.
			
			while(rs.next()) { 		//rs�� �����Ͱ� �ִ� ����
				
				SalesDTO dto = new SalesDTO();
				
				dto.setUserId(rs.getString(1));
				dto.setProductName(rs.getString(2));
				dto.setPrice(rs.getInt(3));
				dto.setDiscount(rs.getInt(4));
				dto.setBuyDate(rs.getString(5));
				
				
				lists.add(dto);
			}
			
			rs.close();
			cstmt.close();
			
		} catch (Exception e) {

			System.out.println(e.toString());
		}
		
		return lists;
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public int sales(SalesDTO saleDto, LoginDTO logDto) {			//productno�� ����Ǿ��ִ� saledto,
																	//loginid�� ����Ǿ��ִ� logdto
																	
		
		Connection conn = DBConn.getConnection();
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
	/////////////////////////////////////////////////////////////////////////////////////////////
	public boolean existCheck(LoginDTO logDto, SalesDTO saleDto) {
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		String productName = null;
		
		boolean exist = false;
		
		try {
			
			//�Է¹��� productno�� ��Ī�Ǵ� productname�� product ���̺��� �˻�.
			//�ƿ� sales���� productno �÷��� �߰��س����� �ξ� ���߰����� �̹� �Է��� �����Ͱ� ������ ���� �˻��۾��� ����.
			
			sql = "select productname from product where productno = ? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, saleDto.getProductNo());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				
				productName = rs.getString("productname");		//��ȣ�� ��Ī�Ǵ� productname ����.
			}
			
			
			//userid ��ġ, productname ��ġ, ���� ���� null�� �����Ͱ� �ִ��� Ȯ��.
			sql = "select * from sales where userid = ? and productname = ? and grade is null";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, logDto.getId());
			pstmt.setString(2, productName);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				exist = true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return exist;
		
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public int gradeInput(SalesDTO saleDto,LoginDTO logDto) {
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		int result = 0;
		int avgGrade = 0;
		String productName = null;
		
		try {
			
			//�Է¹��� productno�� ��Ī�Ǵ� productname�� product ���̺��� �˻�.
			sql = "select productname from product where productno = ? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, saleDto.getProductNo());
			rs=pstmt.executeQuery();
			if(rs.next()) {	
				productName = rs.getString("productname");
			}
			
			//sales ���̺��� userid�� productname�� ��ġ�ϰ� ���� ������ �����͸� �˻��ؼ� ���� ������Ʈ
			sql = "update sales set grade = ? where userid = ? and productname = ? and ";
			sql+= "buydate = (select min(buydate) from sales where userid = ? and productname = ? and grade is null )";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, saleDto.getGrade());
			pstmt.setString(2, logDto.getId());
			pstmt.setString(3, productName);
			pstmt.setString(4, logDto.getId());
			pstmt.setString(5, productName);
			
			result=pstmt.executeUpdate();		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return result;
		
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public int avgGradeSet(SalesDTO saleDto) {
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		int result = 0;
		int avgGrade = 0;
		String productName = null;
		
		try {
			
			//�Է¹��� productno�� ��Ī�Ǵ� productname�� product ���̺��� �˻�.
			sql = "select productname from product where productno = ? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, saleDto.getProductNo());
			rs=pstmt.executeQuery();
			if(rs.next()) {	
				productName = rs.getString("productname");
			}
			
			
			//sales ���̺��� Ư�� ��ǰ�� ������ ����� �˻�.
			sql = "select avg(grade) from sales where productname = ? ";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, productName);
			
			rs=pstmt.executeQuery();
			
			
			if(rs.next()) {
				avgGrade=rs.getInt("avg(grade)");	//��� ����.
			}
			
			
			//product ���̺��� grade�� ������ ��� ������ update
			sql = "update product set grade = ? where productname = ? ";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, avgGrade);
			pstmt.setString(2, productName);
			
			result=pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		return result;
		
		
	}
 

}
