package hello.servlet_study.web.frontcontroller.v3.controller;

import hello.servlet_study.domain.member.Member;
import hello.servlet_study.domain.member.MemberRepository;
import hello.servlet_study.web.frontcontroller.ModelView;
import hello.servlet_study.web.frontcontroller.v3.ControllerV3;
import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {

        List<Member> members = memberRepository.findByAll();
        ModelView mv = new ModelView("members");
        mv.getModel().put("members", members);

        return mv;
    }
}