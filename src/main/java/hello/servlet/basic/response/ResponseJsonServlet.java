package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");

        // HelloData : 인코딩할 json 형식을 클래스로 나타냈던 것
        HelloData helloData = new HelloData();
        helloData.setUsername("kim");
        helloData.setAge(20);

        // HelloData를 응답 메시지 형태로 매핑하기
        // {"username":"kim", "age":20}
        String result = objectMapper.writeValueAsString(helloData);
        // 매핑한 결과(result)를 메시지 바디로 날리기
        resp.getWriter().write(result);
    }
}
