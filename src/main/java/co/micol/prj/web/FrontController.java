package co.micol.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.command.HomeCommand;
import co.micol.prj.command.MemberList;
import co.micol.prj.command.MemberLogin;
import co.micol.prj.command.MemberLoginForm;



/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

    public FrontController() {
        super();
    }

	/**
	 * 실행할 명령들을 초기설정 하는곳
	 */
	public void init(ServletConfig config) throws ServletException {
		// 호출되는 명령들의 집합
		map.put("/home.do", new HomeCommand());  //처음 접근하는 페이지 수행
		map.put("/memberList.do", new MemberList()); //멤버 목록보기
		map.put("/memberLoginForm.do", new MemberLoginForm());// 로그인 폼 호출
		map.put("/memberLogin.do", new MemberLogin()); //로그인 처리
	}

	/**
	 * 요청을 분석하고 처리하는 메소드
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  //한글 깨짐 방지
		String uri = request.getRequestURI();   //uri를 구함
		String contextPath = request.getContextPath();  //contextPath값 구함
		String page = uri.substring(contextPath.length()); //실제요청을 구함
		
		Command command = map.get(page); //command = new HomeCommand();
		String viewPage = command.run(request, response);  //보여줄 페이지 선택
		
		if(viewPage != null && !viewPage.endsWith(".do")) {   //viewResolve
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
