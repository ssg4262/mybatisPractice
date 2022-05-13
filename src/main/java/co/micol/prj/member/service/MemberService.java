package co.micol.prj.member.service;

import java.util.List;

public interface MemberService {
	List<MemberVO> memberSelectList();  //전체리스트
	MemberVO memberSelect(MemberVO vo);  //한명분 데이터 가져오기
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int memberDelete(MemberVO vo);
	
	boolean isIdCheck(String id);  //아이디 중복 체크
	MemberVO memberLoginCheck(MemberVO vo); //로그인
}
