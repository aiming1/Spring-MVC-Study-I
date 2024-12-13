package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // [status-line] 응답 메시지의 맨 첫 번째: 응답 코드 (404, 503 등)
        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        // [response-header]
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("my-header", "hello");

        // [Header 편의 메서드] setHeader 함수는 양식을 지켜서 인자를 넣어야 하는 게 귀찮으니까 메소드화
        // resp.setHeader("Content-Type", "text/plain;charset=utf-8"); 를 메소드로 표현
        content(resp);
        // resp.setHeader("Set-Cookie", "myCookie=good; Max-Age=600"); 를 메소드로 표현
        cookie(resp);
        // resp.setStatus(HttpServletResponse.SC_FOUND); // 302 리다이렉트 코드
        // resp.setHeader("Location", "/basic/hello-form.html"); 를 메소드로 표현
        redirect(resp);

        // [message body]
        PrintWriter writer = resp.getWriter();
        writer.println("안녕하세요.");
    }

    private void content(HttpServletResponse resp){
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
    }

    private void cookie(HttpServletResponse resp){
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);
        resp.addCookie(cookie);
    }

    private void redirect(HttpServletResponse resp) throws IOException{
        resp.sendRedirect("/basic/hello-form.html");
    }
}
