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
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
			
			cstmt = conn.prepareCall(sql);	//select는 결과를 db값으로 반환한다.
			
			//out 파라미터의 자료형
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.setString(2, logDto.getId());
			
			//프로시저 실행
			cstmt.executeUpdate();
			
			//out 파라미터의 값을 받아냄
			
			rs = (ResultSet)cstmt.getObject(1);  		//그렇기에 ResultSet을 사용한다.
			
			while(rs.next()) { 		//rs에 데이터가 있는 동안
				
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
	
	public int sales(SalesDTO saleDto, LoginDTO logDto) {			//productno가 저장되어있는 saledto,
																	//loginid가 저장되어있는 logdto
																	
		
		Connection conn = DBConn.getConnection();
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
	/////////////////////////////////////////////////////////////////////////////////////////////
	public boolean existCheck(LoginDTO logDto, SalesDTO saleDto) {
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		String productName = null;
		
		boolean exist = false;
		
		try {
			
			//입력받은 productno로 매칭되는 productname을 product 테이블에서 검색.
			//아예 sales에도 productno 컬럼을 추가해놨으면 훨씬 편했겠지만 이미 입력한 데이터가 많으니 따로 검색작업을 수행.
			
			sql = "select productname from product where productno = ? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, saleDto.getProductNo());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				
				productName = rs.getString("productname");		//번호에 매칭되는 productname 지정.
			}
			
			
			//userid 일치, productname 일치, 평점 란이 null인 데이터가 있는지 확인.
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
			
			//입력받은 productno로 매칭되는 productname을 product 테이블에서 검색.
			sql = "select productname from product where productno = ? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, saleDto.getProductNo());
			rs=pstmt.executeQuery();
			if(rs.next()) {	
				productName = rs.getString("productname");
			}
			
			//sales 테이블의 userid와 productname이 일치하고 가장 오래된 데이터를 검색해서 평점 업데이트
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
			
			//입력받은 productno로 매칭되는 productname을 product 테이블에서 검색.
			sql = "select productname from product where productno = ? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, saleDto.getProductNo());
			rs=pstmt.executeQuery();
			if(rs.next()) {	
				productName = rs.getString("productname");
			}
			
			
			//sales 테이블의 특정 제품의 평점의 평균을 검색.
			sql = "select avg(grade) from sales where productname = ? ";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, productName);
			
			rs=pstmt.executeQuery();
			
			
			if(rs.next()) {
				avgGrade=rs.getInt("avg(grade)");	//평균 추출.
			}
			
			
			//product 테이블의 grade에 추출한 평균 평점을 update
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
