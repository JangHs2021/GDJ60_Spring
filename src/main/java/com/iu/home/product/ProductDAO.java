package com.iu.home.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iu.home.util.DBConnection;

public class ProductDAO {
	
	// getMax
	public Long getProductNum() throws Exception {
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT PRODUCT_SEQ.NEXTVAL FROM DUAL";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		rs.next();
		
		//rs.getLong("MAX(PRODUCTNUM)");
		Long num = rs.getLong(1);
		
		DBConnection.disConnection(rs, st, connection);
		
		return num;
	}
	
	// -----------------------------------------------------------------------------------
	public List<ProductDTO> getProductList() throws Exception {
		ArrayList<ProductDTO> ar = new ArrayList<ProductDTO>();
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT PRODUCTNUM, PRODUCTNAME, PRODUCTJUMSU "
				+ "FROM PRODUCT ORDER BY PRODUCTJUMSU DESC";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductNum(rs.getLong("PRODUCTNUM"));
			productDTO.setProductName(rs.getString("PRODUCTNAME"));
			productDTO.setProductJumsu(rs.getDouble("PRODUCTJUMSU"));
			ar.add(productDTO);
		}
	
		DBConnection.disConnection(rs, st, connection);
		
		return ar;
	}
	
	public int setAddProduct(ProductDTO productDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		
		String sql = "INSERT INTO PRODUCT (PRODUCTNUM, PRODUCTNAME, PRODUCTDETAIL, PRODUCTJUMSU) "
				+ "VALUES(?, ?, ?, 0.0)";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setLong(1, productDTO.getProductNum());
		st.setString(2, productDTO.getProductName());
		st.setString(3, productDTO.getProductDetail());
		//st.setDouble(3, productDTO.getProductJumsu());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnection(st, connection);
		
		return result;
	}
	
	// -----------------------------------------------------------------------------------
	public int setAddProductOption(ProductOptionDTO productOptionDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		
		String sql = "INSERT INTO PRODUCTOPTION (OPTIONNUM, PRODUCTNUM, OPTIONNAME, OPTIONPRICE, OPTIONSTOCK) "
				+ "VALUES(PRODUCT_SEQ.NEXTVAL, ?, ?, ?, ?)";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		//st.setLong(1, productOptionDTO.getOptionNum());
		st.setLong(1, productOptionDTO.getProductNum());
		st.setString(2, productOptionDTO.getOptionName());
		st.setInt(3, productOptionDTO.getOptionPrice());
		st.setInt(4, productOptionDTO.getOptionStock());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnection(st, connection);
		
		return result;
	}
	
	public List<ProductOptionDTO> getProductOptionList() throws Exception {
		//List<ProductOptionDTO> ar = new ArrayList<ProductOptionDTO>();
		ArrayList<ProductOptionDTO> ar = new ArrayList<ProductOptionDTO>();
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT * FROM PRODUCTOPTION";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ProductOptionDTO productOptionDTO = new ProductOptionDTO();
			productOptionDTO.setOptionNum(rs.getLong("OPTIONNUM"));
			productOptionDTO.setProductNum(rs.getLong("PRODUCTNUM"));
			productOptionDTO.setOptionName(rs.getString("OPTIONNAME"));
			productOptionDTO.setOptionPrice(rs.getInt("OPTIONPRICE"));
			productOptionDTO.setOptionStock(rs.getInt("OPTIONSTOCK"));
			ar.add(productOptionDTO);
		}
		
		DBConnection.disConnection(rs, st, connection);
		
		return ar;
	}
}
