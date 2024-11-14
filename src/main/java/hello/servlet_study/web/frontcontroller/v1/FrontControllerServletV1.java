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

    //맵핑정보 만들기 - key:url, value:컨트롤러
    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    //생성자 - controllerMap이 생성될 때 미리 담아놓기
    public FrontControllerServletV1() {
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV1.service");

        //URI를 가져오고
        String requestURI = request.getRequestURI();
        //controllerMap에서 URI 꺼내고 객체인스턴스 반환하기
        ControllerV1 controller = controllerMap.get(requestURI);

        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //컨트롤러를 찾았으면 인터페이스의 process를 호출
        //이게 오버라이드 된 컨트롤러가 실행됨
        controller.process(request, response);
    }
}
