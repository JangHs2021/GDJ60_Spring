package com.iu.home.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public int setMemberAdd(MemberDTO memberDTO) throws Exception {
		return memberDAO.setMemberAdd(memberDTO);
	}
	
	public List<MemberDTO> memberList() {
		return memberDAO.memberList();
	}
}
