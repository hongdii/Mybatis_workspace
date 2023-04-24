package com.kh.mybatis.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.template.Template;
import com.kh.mybatis.member.model.dao.MemberDao;
import com.kh.mybatis.member.model.vo.Member;

public class MemberService {
	
	private MemberDao memberDao = new MemberDao();
	
	public Member loginMember(Member m) {
		// connection 객체 반환
		SqlSession sqlSession = Template.getSqlSession();
		// 전달할 객체가 여러개일 경우에 HashMap객체 생성해서 전달해줌.
		
		// mybatis 프레임워크가 xml처리 대신해줘서 변수로 선언해도됨
		Member loginUser = memberDao.loginMember(sqlSession , m);
	
		// Connection 객체 종료
		sqlSession.close();
		
		return loginUser;
	}
}
