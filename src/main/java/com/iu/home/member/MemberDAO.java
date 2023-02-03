package com.iu.home.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.iu.home.util.DBConnection;

public class MemberDAO {
	
	// setAddMember
	public int setAddMember(MemberDTO memberDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		
		String sql = "INSERT INTO MEMBER2 (ID, PW, NAME, PHONE, EMAIL, ADDRESS) "
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		
		PreparedStatement st = connection.prepareStatement(sql);
	
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getPhone());
		st.setString(5, memberDTO.getEmail());
		st.setString(6, memberDTO.getAddress());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnection(st, connection);
		
		return result;
	}
	
	public static void main(String[] args) {
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setId("id1");
		memberDTO.setPw("pw1");
		memberDTO.setName("name1");
		memberDTO.setPhone("phone1");
		memberDTO.setEmail("eamil1");
		memberDTO.setAddress("address1");
		
		try {
			int result = memberDAO.setAddMember(memberDTO);
			System.out.println(result != 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
