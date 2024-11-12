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
	
	//전체 제품 리스트 DAO
	public List<ProductDTO> getList(){
		
		List<ProductDTO> lists = new ArrayList<ProductDTO>();
		
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="{call SelectAllProduct(?)}";
			
			cstmt = conn.prepareCall(sql);	//select는 결과를 db값으로 반환한다.
			
			//out 파라미터의 자료형
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			//프로시저 실행
			cstmt.executeUpdate();
			
			//out 파라미터의 값을 받아냄
			
			rs = (ResultSet)cstmt.getObject(1);  		//그렇기에 ResultSet을 사용한다.
			
			while(rs.next()) { 		//rs에 데이터가 있는 동안
				
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
	
	//대분류로 걸러낸 제품 출력
	public List<ProductDTO> getBigList(ProductDTO dto){
		
		List<ProductDTO> lists = new ArrayList<ProductDTO>();
		
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="{call SelectBigcatProduct(?,?)}";
			
			cstmt = conn.prepareCall(sql);	//select는 결과를 db값으로 반환한다.
			
			//out 파라미터의 자료형
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.setString(2, dto.getSearchCatal());
			
			//프로시저 실행
			cstmt.executeUpdate();
			
			//out 파라미터의 값을 받아냄
			
			System.out.println(dto.getSearchCatal());
			rs = (ResultSet)cstmt.getObject(1);  		//그렇기에 ResultSet을 사용한다.
			
			while(rs.next()) { 		//rs에 데이터가 있는 동안
				
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
	
	//소분류로 걸러낸 데이터 출력
	public List<ProductDTO> getSmallList(ProductDTO dto){
		
		List<ProductDTO> lists = new ArrayList<ProductDTO>();
		
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="{call SelectSmallcatProduct(?,?)}";
			
			cstmt = conn.prepareCall(sql);	//select는 결과를 db값으로 반환한다.
			
			//out 파라미터의 자료형
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.setString(2, dto.getSearchCatal());
			
			//프로시저 실행
			cstmt.executeUpdate();
			
			//out 파라미터의 값을 받아냄
			
			System.out.println(dto.getSearchCatal());
			rs = (ResultSet)cstmt.getObject(1);  		//그렇기에 ResultSet을 사용한다.
			
			while(rs.next()) { 		//rs에 데이터가 있는 동안
				
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
	
	//대분류 리스트 출력
	
	public List<BigCatalDTO> bigCatalList(){
		
		List<BigCatalDTO> lists = new ArrayList<BigCatalDTO>();
		
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="{call SelectBigCatal(?)}";
			
			cstmt = conn.prepareCall(sql);	//select는 결과를 db값으로 반환한다.
			
			//out 파라미터의 자료형
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			//프로시저 실행
			cstmt.executeUpdate();
			
			//out 파라미터의 값을 받아냄
			
			rs = (ResultSet)cstmt.getObject(1);  		//그렇기에 ResultSet을 사용한다.
			
			while(rs.next()) { 		//rs에 데이터가 있는 동안
				
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
	
	//소분류 리스트 출력
	
	public List<SmallCatalDTO> smallCatalList(ProductDTO dto){
		
		List<SmallCatalDTO> lists = new ArrayList<SmallCatalDTO>();
		
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="{call SelectSmallCatal(?,?)}";
			
			cstmt = conn.prepareCall(sql);	//select는 결과를 db값으로 반환한다.
			
			//out 파라미터의 자료형
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.setString(2, dto.getSearchCatal());
			
			//프로시저 실행
			cstmt.executeUpdate();
			
			//out 파라미터의 값을 받아냄
			
			rs = (ResultSet)cstmt.getObject(1);  		//그렇기에 ResultSet을 사용한다.
			
			while(rs.next()) { 		//rs에 데이터가 있는 동안
				
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
			
			cstmt = conn.prepareCall(sql);	//select는 결과를 db값으로 반환한다.
			
			//out 파라미터의 자료형
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			//프로시저 실행
			cstmt.executeUpdate();
			
			//out 파라미터의 값을 받아냄
			
			rs = (ResultSet)cstmt.getObject(1);  		//그렇기에 ResultSet을 사용한다.
			
			while(rs.next()) { 		//rs에 데이터가 있는 동안
				
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
			
			pstmt = conn.prepareStatement(sql);	//select는 결과를 db값으로 반환한다.
			
			//out 파라미터의 자료형
			pstmt.setString(1, logDto.getId());
			
			//프로시저 실행
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) { 		//rs에 데이터가 있는 동안
				
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
	
	public int sales(SalesDTO saleDto, LoginDTO logDto) {			//productno가 저장되어있는 saledto,
																	//loginid가 저장되어있는 logdto
					
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		int result = 0;
		String topProductName = null;
		
		try {
			
			conn = DBConn.getConnection();
			conn.setAutoCommit(false);
			
			sql = "select productname,price,maker,point from product a,userinfo b where productno = ?";	//구입할 물건의 productno를 where에 넣어서
					
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, saleDto.getProductNo());
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {

				saleDto.setProductName(rs.getString("productname"));					//saleDTO에 sale테이블에 들어갈 productname 저장
				saleDto.setPrice(rs.getInt("price"));									//마찬가지로 price 저장
				saleDto.setMaker(rs.getString("maker"));								//마찬가지로 maker 저장.
				saleDto.setPoint(rs.getInt("point"));

				sql="insert into sales (userid,productname,price,maker,buydate) values (?,?,?,?,sysdate) ";	//아이디,제품이름,가격,메이커,구입날짜를 update

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
