package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHtmlServlet", urlPatterns = "/response-html")
public class ResponseHtmlServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html"); // html을 응답 메시지로 줄 거야!!
        resp.setCharacterEncoding("utf-8"); // 인코딩은 이렇게 해

        // 이게 실화인가? 아무튼 정적으로 코드를 넣어서 인코딩을 함...
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("   <div>안녕?</div>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
