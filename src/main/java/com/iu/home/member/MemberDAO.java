package com.iu.home.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.home.util.DBConnection;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.home.member.MemberDAO.";
	
	public int setMemberAdd(MemberDTO memberDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "setMemberAdd", memberDTO);
	}
	
	public List<MemberDTO> memberList() {
		return sqlSession.selectList(NAMESPACE + "memberList");
	}
	
	public int setMemberRoleAdd(MemberDTO memberDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "setMemberRoleAdd", memberDTO);
	}
	
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getMemberLogin", memberDTO);
	}
	
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "setMemberUpdate", memberDTO);
	}
}



