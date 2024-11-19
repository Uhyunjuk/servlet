package hello.servlet_study.web.frontcontroller.v1;

import hello.servlet_study.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet_study.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet_study.web.frontcontroller.v1.controller.MemberSaveControllerV1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    // URL과 컨트롤러를 매핑하는 데 사용되는 맵을 선언
    // (url, 서블릿)
    private Map<String, hello.servlet.web.frontcontroller.v1.ControllerV1> controllerMap = new HashMap<>();

    // FrontControllerServletV1 클래스의 생성자
    // 초기에 사용할 수 있도록 몇 가지 URL과 컨트롤러의 매핑을 설정
    public FrontControllerServletV1() {
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // localhost:8080/front-controller/v1/members 이렇게 요청uri가 찍히면
        String requestURI = request.getRequestURI(); // controllerMap에서 똑같은 uri key를 찾아
        hello.servlet.web.frontcontroller.v1.ControllerV1 controller = controllerMap.get(requestURI); // MemberListControllerV1() 객체인스턴스값을 반환받는다

        // key(uri)에 맵핑되는 값(객체인스턴)이 없으면 404찍어주기
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND); //404
            return;
        }

        // 인터페이스의 메소드 호출해주기
        controller.process(request, response);
    }
}
