package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
  1. 서블릿 클래스는 HttpServlet을 반드시 상속받아야 한다
  2. 서블릿 클래스에는 @WebServlet annotation을 붙인다
 **/

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    /** 클래스가 호출되면 실행될 서비스 메소드 **/
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        // 쿼리 파라미터 조회하기
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // 응답 메시지 스펙 설정하기
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

        // 응답 메시지에 담을 데이터
        response.getWriter().write("hello " + username);

    }
}
