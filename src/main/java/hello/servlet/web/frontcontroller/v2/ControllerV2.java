package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV2 {

    /** ControllerV1과의 차이점
     *
     * V1의 process는 void를 리턴 -> 인터페이스를 상속받아 override하는 컨트롤러들이 각각 view를 렌더링하기 때문
     * V2의 process는 MyView를 리턴 -> MyView가 view를 렌더링하는 부분을 담당할 것임
     *
     */

    MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    // github 테스트
}
