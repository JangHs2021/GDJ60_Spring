package com.iu.home.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.home.MyTestCase;

public class MemberDAOTest extends MyTestCase {

	@Autowired
	private MemberDAO memberDAO;
	
	@Test
	public void setMemberUpdate() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setName("222");
		memberDTO.setPhone("222");
		memberDTO.setEmail("222");
		memberDTO.setAddress("222");
		memberDTO.setId("11");
		
		int result = memberDAO.setMemberUpdate(memberDTO);
		
		assertEquals(1, result);
	}
}
