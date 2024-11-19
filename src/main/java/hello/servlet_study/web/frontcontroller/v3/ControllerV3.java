package hello.servlet_study.web.frontcontroller.v3;

import hello.servlet_study.web.frontcontroller.ModelView;
import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String, String> paramMap);
}
