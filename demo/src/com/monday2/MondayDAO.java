package com.monday2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
				
				ProductDTO newDto2 = new ProductDTO();
				
				newDto2.setProductNo(rs.getString(1));
				newDto2.setProductName(rs.getString(2));
				newDto2.setPrice(rs.getInt(3));
				newDto2.setMaker(rs.getString(4));
				newDto2.setGrade(rs.getInt(5));
				newDto2.setBigCatal(rs.getString(6));
				newDto2.setSmallCatal(rs.getString(7));
				
				lists.add(newDto2);
			}
			
			rs.close();
			cstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return lists;
		
	}
	
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
				
				ProductDTO newDto = new ProductDTO();
				
				newDto.setProductNo(rs.getString(1));
				newDto.setProductName(rs.getString(2));
				newDto.setPrice(rs.getInt(3));
				newDto.setMaker(rs.getString(4));
				newDto.setGrade(rs.getInt(5));
				newDto.setBigCatal(rs.getString(6));
				newDto.setSmallCatal(rs.getString(7));
				
				lists.add(newDto);
			}
			
			rs.close();
			cstmt.close();
			
		} catch (Exception e) {

			System.out.println(e.toString());
		}
		
		return lists;
	}
	
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
				String maxProduct = rs.getString(4);
				
				maxProduct = (maxProduct != null) ? maxProduct : "";
                
				dto.setMaxProduct(maxProduct);
				
				lists.add(dto);
			}
			
			rs.close();
			cstmt.close();
			
		} catch (Exception e) {

			System.out.println(e.toString());
		}
		
		return lists;
	}
	
	public List<SalesDTO> getSalesList(LoginDTO logDto){
		
		List<SalesDTO> lists = new ArrayList<SalesDTO>();
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="select * from sales where userid = ? order by buydate ";
			
			pstmt = conn.prepareStatement(sql);	//select�� ����� db������ ��ȯ�Ѵ�.
			
			//out �Ķ������ �ڷ���
			pstmt.setString(1, logDto.getId());
			
			//���ν��� ����
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) { 		//rs�� �����Ͱ� �ִ� ����
				
				SalesDTO dto = new SalesDTO();
				
				dto.setUserId(rs.getString("userid"));
				dto.setProductName(rs.getString("productname"));
				dto.setPrice(rs.getInt("price"));
				dto.setDiscount(rs.getInt("discount"));
				dto.setBuyDate(rs.getString("buydate"));
				dto.setMaker(rs.getString("maker"));
				dto.setGrade(rs.getInt("grade"));
				
				lists.add(dto);
			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {

			System.out.println(e.toString());
		}
		
		return lists;
	}
	
	public int sales(SalesDTO saleDto, LoginDTO logDto) {			//productno�� ����Ǿ��ִ� saledto,
																	//loginid�� ����Ǿ��ִ� logdto
					
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		int result = 0;
		String topProductName = null;
		
		try {
			
			conn = DBConn.getConnection();
			conn.setAutoCommit(false);
			
			sql = "select productname,price,maker,point from product a,userinfo b where productno = ?";	//������ ������ productno�� where�� �־
					
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, saleDto.getProductNo());
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {

				saleDto.setProductName(rs.getString("productname"));					//saleDTO�� sale���̺� �� productname ����
				saleDto.setPrice(rs.getInt("price"));									//���������� price ����
				saleDto.setMaker(rs.getString("maker"));								//���������� maker ����.
				saleDto.setPoint(rs.getInt("point"));

				sql="insert into sales (userid,productname,price,maker,buydate) values (?,?,?,?,sysdate) ";	//���̵�,��ǰ�̸�,����,����Ŀ,���Գ�¥�� update

				pstmt= conn.prepareStatement(sql);
				
				pstmt.setString(1, logDto.getId());
				pstmt.setString(2, saleDto.getProductName());
				pstmt.setInt(3, saleDto.getPrice());
				pstmt.setString(4, saleDto.getMaker());

				result = pstmt.executeUpdate();
				
				int currentPoint = saleDto.getPoint();
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
				
				conn.commit();
				
			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
		
	}
 

}
