package com.iu.home.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.home.MyTestCase;

public class MemberDAOTest extends MyTestCase {

	@Autowired
	private MemberDAO memberDAO;
	
	@Test
	public void setMemberAddTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setId("2");
		memberDTO.setPw("22222");
		memberDTO.setName("HS222");
		memberDTO.setPhone("010-222-222");
		memberDTO.setEmail("2222@naver");
		memberDTO.setAddress("가산동");
		
		int result = memberDAO.setMemberAdd(memberDTO);
		
		assertEquals(1, result);
	}
}
