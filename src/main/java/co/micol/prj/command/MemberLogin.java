package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.comm.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;

public class MemberLogin implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 로그인 처리
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession();
		
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		
		vo = memberDao.memberLoginCheck(vo);
		
		if(vo != null) {
			session.setAttribute("id", vo.getId());
			session.setAttribute("author", vo.getAuthor());
			session.setAttribute("name", vo.getName());
			
			request.setAttribute("message", vo.getName() + "님 환영합니다.");
		}else {
			request.setAttribute("message", "아이디 또는 패스워드가 틀립니다.");
		}
		
		return "member/memberLoginResult";
	}

}
